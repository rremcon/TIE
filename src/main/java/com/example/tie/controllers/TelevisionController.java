package com.example.tie.controllers;

import com.example.tie.dtos.TelevisionDto;
import com.example.tie.dtos.WallBracketDto;
import com.example.tie.inputDto.IdInputDto;
import com.example.tie.inputDto.TelevisionInputDto;
import com.example.tie.services.TelevisionService;
import com.example.tie.services.TelevisionWallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;
    private final TelevisionWallBracketService televisionWallBracketService;

    public TelevisionController(TelevisionService televisionService, TelevisionWallBracketService televisionWallBracketService) {
        this.televisionService = televisionService;
        this.televisionWallBracketService = televisionWallBracketService;
    }


    @GetMapping("")
    public ResponseEntity<List<TelevisionDto>> getTelevisions(@RequestParam(value = "brand", required = false) Optional<String> brand) {

        List<TelevisionDto> dtos;

        if (brand.isEmpty()) {
            dtos = televisionService.getTelevisions();
        } else {
            dtos = televisionService.getTelevisionsByBrand(brand.get());
        }

        return ResponseEntity.ok().body(dtos);
    }

        @GetMapping("/{id}")
        public ResponseEntity<TelevisionDto> getTelevision(@PathVariable("id") Long id) {
            TelevisionDto television = televisionService.getTelevisionById(id);

            return ResponseEntity.ok().body(television);
        }


        @PostMapping("")
        public ResponseEntity<Object> saveTelevision (@Valid @RequestBody TelevisionInputDto televisionInputDto){

            TelevisionDto dto = televisionService.saveTelevision(televisionInputDto);

            return ResponseEntity.created(null).body(dto);
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Object> deleteTelevision (@PathVariable("id") Long id){
            televisionService.deleteTelevision(id);
            return ResponseEntity.noContent().build();
        }


        @PutMapping("/{id}")
        public ResponseEntity<Object> updateTelevision (@PathVariable Long
        id, @Valid @RequestBody TelevisionInputDto newTelevision){

            TelevisionDto dto = televisionService.updateTelevision(id, newTelevision);

            return ResponseEntity.ok().body(dto);
        }


    @PutMapping("/televisions/{id}/remote")
    public void assignRemoteControllerToTelevision(@PathVariable("id") Long id,@Valid @RequestBody IdInputDto input) {
        televisionService.assignRemoteToTelevision(id, input.id);
    }

    @PutMapping("/televisions/{id}/{ciModuleId}")
    public void assignCIModuleToTelevision(@PathVariable("id") Long id, @PathVariable("ciModuleId") Long ciModuleId) {
        televisionService.assignCiModuleToTelevision(id, ciModuleId);
    }

    @GetMapping("/televisions/wallBrackets/{televisionId}")
    public Collection<WallBracketDto> getWallBracketsByTelevisionId(@PathVariable("televisionId") Long televisionId){
        return televisionWallBracketService.getWallBracketsByTelevisionId(televisionId);
    }

    }
