package com.example.tie.controllers;

import com.example.tie.services.TelevisionWallBracketService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tvwb")
public class TelevisionWallBracketController {

    private TelevisionWallBracketService televisionWallBracketService;

    public TelevisionWallBracketController(TelevisionWallBracketService televisionWallbracketService) {
        this.televisionWallBracketService = televisionWallbracketService;
    }


    @PostMapping("/{televisionId}/{wallBracketId}")
    public void addTelevisionWallBracket(@PathVariable("televisionId") Long televisionId, @PathVariable("wallBracketId") Long wallbracketId) {
        televisionWallBracketService.addTelevisionWallBracket(televisionId, wallbracketId);
    }

}
