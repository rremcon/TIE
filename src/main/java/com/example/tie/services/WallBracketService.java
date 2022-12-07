package com.example.tie.services;

import com.example.tie.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;

    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

}
