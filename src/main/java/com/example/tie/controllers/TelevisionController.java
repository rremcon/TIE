package com.example.tie.controllers;

import com.example.tie.dtos.TelevisionDto;
import com.example.tie.dtos.TelevisionInputDto;
import com.example.tie.exceptions.RecordNotFoundException;
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


//    @Autowired
//    private TelevisionRepository repo;

    private final TelevisionService serv;

    public TelevisionController(TelevisionService serv) {
        this.serv = serv;
    }


    @GetMapping("")
    public ResponseEntity<Iterable<TelevisionDto>>getTvs() {
        return ResponseEntity.ok(serv.getTvs());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getTv(@PathVariable int id) {
        if (id < 4) {
            return new ResponseEntity<>("television " + id, HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("Id not found");
        }
    }


    @PostMapping("")
    public ResponseEntity<Object> saveTv(@RequestBody TelevisionInputDto tvDto) {

        Long savedId = serv.saveTv(tvDto);
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/televisions/" + savedId).toUriString());

        return ResponseEntity.created(uri).body("television saved");
    }


    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTv(@PathVariable int id, @RequestBody Television television) {
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTv(@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }


}
