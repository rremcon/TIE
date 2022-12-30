package com.example.tie.services;

import com.example.tie.dtos.TelevisionDto;
import com.example.tie.inputDto.TelevisionInputDto;
import com.example.tie.exceptions.RecordNotFoundException;
import com.example.tie.models.Television;
import com.example.tie.repositories.CiModuleRepository;
import com.example.tie.repositories.RemoteRepository;
import com.example.tie.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final RemoteRepository remoteRepository;

    private final RemoteService remoteService;

    private final CiModuleRepository ciModuleRepository;

    private final CiModuleService ciModuleService;


    public TelevisionService(TelevisionRepository televisionRepository, RemoteRepository remoteRepository, RemoteService remoteService, CiModuleRepository ciModuleRepository, CiModuleService ciModuleService) {
        this.televisionRepository = televisionRepository;
        this.remoteRepository = remoteRepository;
        this.remoteService = remoteService;
        this.ciModuleRepository = ciModuleRepository;
        this.ciModuleService = ciModuleService;
    }


    public List<TelevisionDto> getTelevisions() {
        List<Television> tvList = televisionRepository.findAll();
        return transferTvListToDtoList(tvList);
    }


    public List<TelevisionDto> getTelevisionsByBrand(String brand) {
        List<Television> tvList = televisionRepository.findByBrand(brand);
        return transferTvListToDtoList(tvList);
    }



    public List<TelevisionDto> transferTvListToDtoList(List<Television> televisions) {
        List<TelevisionDto> tvDtoList = new ArrayList<>();

        for (Television tv : televisions) {
            TelevisionDto dto = transferToDto(tv);
            if (tv.getCimodule() != null) {
                dto.setCiModuleDto(ciModuleService.transferToDto(tv.getCimodule()));
            }
            if (tv.getRemote() != null) {
                dto.setRemoteDto(remoteService.transferToDto(tv.getRemote()));
            }
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }


    public TelevisionDto getTelevisionById(Long id) {

        if (televisionRepository.findById(id).isPresent()) {
            Television tv = televisionRepository.findById(id).get();
            TelevisionDto dto = transferToDto(tv);
            if (tv.getCimodule() != null) {
                dto.setCiModuleDto(ciModuleService.transferToDto(tv.getCimodule()));
            }
            if (tv.getRemote() != null) {
                dto.setRemoteDto(remoteService.transferToDto(tv.getRemote()));
            }
            return transferToDto(tv);
        } else {
            throw new RecordNotFoundException("no tv found");
        }
    }


    public TelevisionDto saveTelevision(TelevisionInputDto dto) {

        Television savedTv = transferToTelevision(dto);
        televisionRepository.save(savedTv);

        return transferToDto(savedTv);
    }


    public void deleteTelevision(@RequestBody Long id) {

        televisionRepository.deleteById(id);

    }


    public TelevisionDto updateTelevision(Long id, TelevisionInputDto inputDto) {
        if (televisionRepository.findById(id).isPresent()) {
            Television tv = televisionRepository.findById(id).get();

            Television tvUpdated = transferToTelevision(inputDto);
            tvUpdated.setId(tv.getId());

            televisionRepository.save(tvUpdated);

            return transferToDto(tvUpdated);
        } else {
            throw new RecordNotFoundException("no tv found");
        }
    }


    public Television transferToTelevision(TelevisionInputDto dto) {
        Television television = new Television();

        //television.setId(dto.getId());
        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());


        return television;
    }


    public TelevisionDto transferToDto(Television television) {
        TelevisionDto dto = new TelevisionDto();

        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());

        return dto;
    }


    public void assignRemoteToTelevision(Long id, Long remoteId) {
        var optionalTelevision = televisionRepository.findById(id);
        var optionalRemote = remoteRepository.findById(remoteId);

        if (optionalTelevision.isPresent() && optionalRemote.isPresent()) {
            var television = optionalTelevision.get();
            var remote = optionalRemote.get();

            television.setRemote(remote);
            televisionRepository.save(television);
        } else {
            throw new RecordNotFoundException();
        }
    }


    public void assignCiModuleToTelevision(Long id, Long ciModuleId) {
        var optionalTelevision = televisionRepository.findById(id);
        var optionalCiModule = ciModuleRepository.findById(ciModuleId);

        if (optionalTelevision.isPresent() && optionalCiModule.isPresent()) {
            var television = optionalTelevision.get();
            var ciModule = optionalCiModule.get();

            television.setCimodule(ciModule);
            televisionRepository.save(television);
        } else {
            throw new RecordNotFoundException();
        }
    }
}








