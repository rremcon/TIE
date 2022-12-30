package com.example.tie.controllers;

import com.example.tie.dtos.TelevisionDto;
import com.example.tie.dtos.WallBracketDto;
import com.example.tie.services.TelevisionWallBracketService;
import com.example.tie.services.WallBracketService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {

    private final WallBracketService wallBracketService;
    private final TelevisionWallBracketService televisionWallBracketService;

    public WallBracketController(WallBracketService wallBracketService, TelevisionWallBracketService televisionWallBracketService) {
        this.wallBracketService = wallBracketService;
        this.televisionWallBracketService = televisionWallBracketService;
    }

    @GetMapping("")
    public List<WallBracketDto> getWallBrackets() {
        List<WallBracketDto> wallBrackets = wallBracketService.getWallBrackets();
        return wallBrackets;

    }

    @GetMapping("{id}")
    public WallBracketDto getWallBracket(@PathVariable("id") Long id) {
        WallBracketDto wallBracketDto = wallBracketService.getWallBracket(id);
        return wallBracketDto;
    }

    @PostMapping("")
    public WallBracketDto addWallBracket(@RequestBody WallBracketDto dto) {
        WallBracketDto wallBracket = wallBracketService.addWallBracket(dto);
        return wallBracket;
    }

    @DeleteMapping("{id}")
    public void deleteWallBracket(@PathVariable("id") Long id) {
        wallBracketService.deleteWallBracket(id);
    }


    @PutMapping("{id}")
    public WallBracketDto updateWallBracket(@PathVariable("id") Long id, @RequestBody WallBracketDto dto) {
        wallBracketService.updateWallBracket(id, dto);
        return dto;
    }


    @GetMapping("/televisions/{wallBracketId}")
    public Collection<TelevisionDto> getTelevisionsByWallBracketId(@PathVariable("wallBracketId") Long wallBracketId) {
        return televisionWallBracketService.getTelevisionsByWallBracketId(wallBracketId);
    }

}
