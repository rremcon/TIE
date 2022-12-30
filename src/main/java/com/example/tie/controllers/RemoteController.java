package com.example.tie.controllers;

import com.example.tie.dtos.RemoteDto;
import com.example.tie.services.RemoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remotes")
public class RemoteController {

    private final RemoteService remoteService;
    public RemoteController(RemoteService remoteService) {
        this.remoteService = remoteService;
    }


    @GetMapping("")
    public List<RemoteDto> getRemotes() {
        List<RemoteDto> dtos = remoteService.getRemotes();
        return dtos;
    }


    @GetMapping("{id}")
    public RemoteDto getRemote(@PathVariable("id") Long id) {
        RemoteDto dto = remoteService.getRemote(id);
        return dto;
    }

    @PostMapping("")
    public RemoteDto addRemote(@RequestBody RemoteDto dto) {
        RemoteDto dto1 = remoteService.addRemote(dto);
        return dto1;
    }


    @DeleteMapping("{id}")
    public void deleteRemote(@PathVariable("id") Long id) {
        remoteService.deleteRemote(id);
    }


    @PutMapping("{id}")
    public RemoteDto updateTelevision(@PathVariable("id") Long id, @RequestBody RemoteDto dto) {
        remoteService.updateRemote(id, dto);
        return dto;
    }

}
