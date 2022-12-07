package com.example.tie.controllers;

import com.example.tie.dtos.IdInputDto;
import com.example.tie.dtos.RemoteInputDto;
import com.example.tie.dtos.TelevisionDto;
import com.example.tie.dtos.TelevisionInputDto;
import com.example.tie.exceptions.RecordNotFoundException;
import com.example.tie.models.Remote;
import com.example.tie.models.Television;
import com.example.tie.repositories.TelevisionRepository;
import com.example.tie.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }


    @GetMapping("")
    public ResponseEntity<Iterable<TelevisionDto>>getTelevisions() {
        return ResponseEntity.ok(televisionService.getTelevisions());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable Long id) {
        if (id > 0) {
            return ResponseEntity.ok(televisionService.getTelevision(id));
        } else {
            throw new RecordNotFoundException(String.format("TV with id %d not found", id));
        }
    }


    @PostMapping("")
    public ResponseEntity<Object> saveTelevision(@RequestBody TelevisionInputDto tvDto) {

        Long savedId = televisionService.saveTelevision(tvDto);
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/televisions/" + savedId).toUriString());

        return ResponseEntity.created(uri).body("television saved");
    }


    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionDto tvDto = televisionService.updateTelevision(id, televisionInputDto);

        return ResponseEntity.ok().body(tvDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
//        return ResponseEntity.noContent(televisionService.deleteTelevision(id));
    }

}