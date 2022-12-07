package com.example.tie.services;

import com.example.tie.repositories.RemoteRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoteService {

    private final RemoteRepository remoteRepository;

    public RemoteService(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

}
