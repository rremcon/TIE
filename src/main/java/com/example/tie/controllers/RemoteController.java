package com.example.tie.controllers;

import com.example.tie.repositories.RemoteRepository;
import com.example.tie.services.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remotes")
public class RemoteController {

    private final RemoteService remoteService;

    public RemoteController(RemoteService remoteService) {
        this.remoteService = remoteService;
    }
}
