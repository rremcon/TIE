package com.example.tie.services;

import com.example.tie.dtos.TelevisionDto;
import com.example.tie.dtos.WallBracketDto;
import com.example.tie.exceptions.RecordNotFoundException;
import com.example.tie.models.Television;
import com.example.tie.models.TelevisionWallBracket;
import com.example.tie.models.TelevisionWallBracketKey;
import com.example.tie.models.WallBracket;
import com.example.tie.repositories.TelevisionRepository;
import com.example.tie.repositories.TelevisionWallBracketRepository;
import com.example.tie.repositories.WallBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class TelevisionWallBracketService {

    private TelevisionRepository televisionRepository;

    private WallBracketRepository wallBracketRepository;

    private TelevisionWallBracketRepository televisionWallBracketRepository;

    public TelevisionWallBracketService(TelevisionRepository televisionRepository, WallBracketRepository wallBracketRepository, TelevisionWallBracketRepository televisionWallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.wallBracketRepository = wallBracketRepository;
        this.televisionWallBracketRepository = televisionWallBracketRepository;
    }

    public Collection<TelevisionDto> getTelevisionsByWallBracketId(Long wallBracketId) {
        Collection<TelevisionDto> dtos = new HashSet<>();
        Collection<TelevisionWallBracket> televisionWallBrackets = televisionWallBracketRepository.findAllByWallBracketId(wallBracketId);
        for (TelevisionWallBracket televisionWallBracket : televisionWallBrackets) {
            Television television = televisionWallBracket.getTelevision();
            TelevisionDto dto = new TelevisionDto();

            television.setId(dto.getId());
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

            dtos.add(dto);
        }
        return dtos;

    }


    public Collection<WallBracketDto> getWallBracketsByTelevisionId(Long televisionId) {
        Collection<WallBracketDto> dtos = new HashSet<>();
        Collection<TelevisionWallBracket> televisionWallBrackets = televisionWallBracketRepository.findAllByTelevisionId(televisionId);
        for (TelevisionWallBracket televisionWallBracket : televisionWallBrackets) {
            WallBracket wallBracket = televisionWallBracket.getWallBracket();
        var dto = new WallBracketDto();

        dto.setId(wallBracket.getId());
        dto.setName(wallBracket.getName());
        dto.setSize(wallBracket.getSize());
        dto.setAdjustable(wallBracket.getAdjustable());
        dto.setPrice(wallBracket.getPrice());

        dtos.add(dto);
    }
    return dtos;

    }


    public TelevisionWallBracketKey addTelevisionWallBracket(Long televisionId, Long wallBracketId) {
        var televisionWallBracket = new TelevisionWallBracket();
        if (!televisionRepository.existsById(televisionId))
        {throw new RecordNotFoundException(); }
        Television television = televisionRepository.findById(televisionId).orElse(null);
        if (!wallBracketRepository.existsById(wallBracketId))
        {throw new RecordNotFoundException(); }
        WallBracket wallBracket = wallBracketRepository.findById(wallBracketId).orElse(null);
        televisionWallBracket.setTelevision(television);
        televisionWallBracket.setWallBracket(wallBracket);
        TelevisionWallBracketKey id = new TelevisionWallBracketKey(televisionId, wallBracketId);
        televisionWallBracket.setId(id);
        televisionWallBracketRepository.save(televisionWallBracket);
        return id;

        }
    }

