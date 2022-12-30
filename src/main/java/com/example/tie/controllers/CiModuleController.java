package com.example.tie.controllers;

import com.example.tie.dtos.CiModuleDto;
import com.example.tie.services.CiModuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modules")
public class CiModuleController {

    private final CiModuleService ciModuleService;
    public CiModuleController(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }


@GetMapping("")
public List<CiModuleDto> getAllCiModules() {

    List<CiModuleDto> dtos = ciModuleService.getCiModules();

    return dtos;
}

@GetMapping("{id}")
public CiModuleDto getCiModule(@PathVariable("id") Long id) {

    CiModuleDto ciModuleDto = ciModuleService.getCiModule(id);

    return ciModuleDto;
}


@PostMapping("")
public CiModuleDto addCiModule(@RequestBody CiModuleDto dto) {
    CiModuleDto ciModuleDto = ciModuleService.addCiModule(dto);
    return ciModuleDto;
}


@DeleteMapping("{id}")
public void deleteCiModule(@PathVariable("id") Long id) {
    ciModuleService.deleteCiModule(id);
}


@PutMapping("{id}")
public CiModuleDto updateCiModule(@PathVariable("id") Long id, @RequestBody CiModuleDto ciModuleDto ) {
    ciModuleService.updateCiModule(id, ciModuleDto);
    return ciModuleDto;
}

}



