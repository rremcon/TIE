package com.example.tie.controllers;


import com.example.tie.repositories.WallBracketRepository;
import com.example.tie.services.WallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {

    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }


}
