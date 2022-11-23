package com.example.tie.controllers;

import com.example.tie.exceptions.RecordNotFoundException;
import com.example.tie.models.Television;
import com.example.tie.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {


    @Autowired
    private TelevisionRepository repos;


    @GetMapping("")
    public ResponseEntity<Iterable<Television>>getTvs() {
        return ResponseEntity.ok(repos.findAll());
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
    public ResponseEntity<Object> addTv(@RequestBody Television television) {
        return ResponseEntity.created(null).body("television added");
    }


    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTv(@PathVariable int id, @RequestBody Television television) {
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeTv(@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }


}
