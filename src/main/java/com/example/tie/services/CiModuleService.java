package com.example.tie.services;

import com.example.tie.dtos.CiModuleDto;
import com.example.tie.exceptions.RecordNotFoundException;
import com.example.tie.models.CiModule;
import com.example.tie.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {

    private final CiModuleRepository ciModuleRepository;

    public CiModuleService(CiModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CiModuleDto> getCiModules() {
        List<CiModule> ciModules = ciModuleRepository.findAll();
        List<CiModuleDto> dtos = new ArrayList<>();
        for (CiModule ci : ciModules) {
            dtos.add(transferToDto(ci));
        }
        return dtos;
    }

    public CiModuleDto getCiModule(Long id) {
        Optional<CiModule> ciModule = ciModuleRepository.findById(id);
        if (ciModule.isPresent()) {
            CiModuleDto ci = transferToDto(ciModule.get());
            return ci;
        } else {
            throw new RecordNotFoundException("No ci-module found");
        }
    }

    public CiModuleDto addCiModule(CiModuleDto ciModuleDto) {
        ciModuleRepository.save(transferToCiModule(ciModuleDto));
        return ciModuleDto;
    }

    public void deleteCiModule(Long id) {
        ciModuleRepository.deleteById(id);
    }

    public void updateCiModule(Long id, CiModuleDto ciModuleDto) {
        if (!ciModuleRepository.existsById(id)) {
            throw new RecordNotFoundException("no ci-module found");
        }
        CiModule savedCiModule = ciModuleRepository.findById(id).orElse(null);
        savedCiModule.setId(ciModuleDto.getId());
        savedCiModule.setType(ciModuleDto.getType());
        savedCiModule.setName(ciModuleDto.getName());
        savedCiModule.setPrice(ciModuleDto.getPrice());

        ciModuleRepository.save(savedCiModule);
    }

    public CiModule transferToCiModule(CiModuleDto dto) {
        CiModule ciModule = new CiModule();

        ciModule.setId(dto.getId());
        ciModule.setName(dto.getName());
        ciModule.setType(dto.getType());
        ciModule.setPrice(dto.getPrice());

        return ciModule;
    }

    public static CiModuleDto transferToDto(CiModule ciModule) {
    var dto = new CiModuleDto();

    dto.id = ciModule.getId();
    dto.name = ciModule.getName();
    dto.type = ciModule.getType();
    dto.price = ciModule.getPrice();

    return dto;
}

}
