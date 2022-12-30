package com.example.tie.services;

import com.example.tie.dtos.WallBracketDto;
import com.example.tie.exceptions.RecordNotFoundException;
import com.example.tie.models.WallBracket;
import com.example.tie.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {
    private final WallBracketRepository wallBracketRepository;

    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<WallBracketDto> getWallBrackets() {
        List<WallBracket> wallBracketList = wallBracketRepository.findAll();
        List<WallBracketDto> dtos = new ArrayList<>();
        for (WallBracket wb : wallBracketList) {
            dtos.add(transferToDto(wb));
        }
        return dtos;
    }

    public WallBracketDto getWallBracket(Long id) {
        Optional<WallBracket> wallBracket = wallBracketRepository.findById(id);
        if(wallBracket.isPresent()) {
            WallBracketDto dto = transferToDto(wallBracket.get());
            return dto;
        } else {
            throw new RecordNotFoundException("No wallbracket found");
        }
    }


    public WallBracketDto addWallBracket(WallBracketDto wallBracketDto) {
        WallBracket wallBracket = transferToWallBracket(wallBracketDto);
        wallBracketRepository.save(wallBracket);
        return transferToDto(wallBracket);
    }


    public void deleteWallBracket(Long id) {
        wallBracketRepository.deleteById(id);
    }

    public void updateWallBracket(Long id, WallBracketDto wallBracketDto) {
        if(!wallBracketRepository.existsById(id)) {
            throw new RecordNotFoundException("No wallbracket found");
        }
        WallBracket storedWallBracket = wallBracketRepository.findById(id).orElse(null);
        storedWallBracket.setId(wallBracketDto.getId());
        storedWallBracket.setSize(wallBracketDto.getSize());
        storedWallBracket.setAdjustable(wallBracketDto.getAdjustable());
        storedWallBracket.setName(wallBracketDto.getName());
        storedWallBracket.setPrice(wallBracketDto.getPrice());

        wallBracketRepository.save(storedWallBracket);
    }


    public WallBracketDto transferToDto(WallBracket wallBracket) {
        var dto = new WallBracketDto();

        dto.setId(wallBracket.getId());
        dto.setName(wallBracket.getName());
        dto.setSize(wallBracket.getSize());
        dto.setAdjustable(wallBracket.getAdjustable());
        dto.setPrice(wallBracket.getPrice());

        return dto;
    }


    public WallBracket transferToWallBracket(WallBracketDto wallBracketDto) {
        var wallBracket = new WallBracket();

        wallBracket.setId(wallBracketDto.getId());
        wallBracket.setName(wallBracketDto.getName());
        wallBracket.setSize(wallBracketDto.getSize());
        wallBracket.setAdjustable(wallBracketDto.getAdjustable());
        wallBracket.setPrice(wallBracketDto.getPrice());

        return wallBracket;
    }

}

