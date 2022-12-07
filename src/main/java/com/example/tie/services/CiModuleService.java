package com.example.tie.services;

import com.example.tie.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

@Service
public class CiModuleService {

    private final CiModuleRepository ciModuleRepository;

    public CiModuleService(CiModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

}
