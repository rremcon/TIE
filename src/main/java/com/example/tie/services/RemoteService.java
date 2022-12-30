package com.example.tie.services;

import com.example.tie.dtos.RemoteDto;
import com.example.tie.exceptions.RecordNotFoundException;
import com.example.tie.models.Remote;
import com.example.tie.repositories.RemoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteService {

    private final RemoteRepository remoteRepository;
    public RemoteService(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }


    public List<RemoteDto> getRemotes() {
        List<RemoteDto> dtos = new ArrayList<>();
        List<Remote> remotes = remoteRepository.findAll();
        for (Remote rm : remotes) {
            dtos.add(transferToDto(rm));
        }
        return dtos;
    }

    public RemoteDto getRemote(Long id) {
        Optional<Remote> remote = remoteRepository.findById(id);
        if(remote.isPresent()) {
            return transferToDto(remote.get());
        } else {
            throw new RecordNotFoundException("No remote found");
        }
    }

    public RemoteDto addRemote(RemoteDto remoteDto) {
        Remote rm = transferToRemote(remoteDto);
        remoteRepository.save(rm);
        return remoteDto;
    }

    public void deleteRemote(Long id) {
        remoteRepository.deleteById(id);
    }

    public void updateRemote(Long id, RemoteDto remoteDto) {
        if(!remoteRepository.existsById(id)) {
            throw new RecordNotFoundException("No remote found");
        }
        Remote storedRemote = remoteRepository.findById(id).orElse(null);
        storedRemote.setId(remoteDto.getId());
        storedRemote.setCompatibleWith(remoteDto.getCompatibleWith());
        storedRemote.setBatteryType(remoteDto.getBatteryType());
        storedRemote.setName(remoteDto.getName());
        storedRemote.setPrice(remoteDto.getPrice());
        storedRemote.setBrand(remoteDto.getBrand());
        storedRemote.setOriginalStock(remoteDto.getOriginalStock());

        remoteRepository.save(storedRemote);
    }


    public RemoteDto transferToDto(Remote remote) {
        var dto = new RemoteDto();

        dto.id = remote.getId();
        dto.compatibleWith = remote.getCompatibleWith();
        dto.batteryType = remote.getBatteryType();
        dto.name = remote.getName();
        dto.brand = remote.getBrand();
        dto.originalStock = remote.getOriginalStock();

        return dto;
    }


    public Remote transferToRemote(RemoteDto dto) {
        var remote = new Remote();

        remote.setId(dto.getId());
        remote.setCompatibleWith(dto.getCompatibleWith());
        remote.setBatteryType(dto.getBatteryType());
        remote.setName(dto.getName());
        remote.setBrand(dto.getBrand());
        remote.setPrice(dto.getPrice());
        remote.setOriginalStock(dto.getOriginalStock());

        return remote;
    }

}
