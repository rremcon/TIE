package com.example.tie.services;

import com.example.tie.controllers.RemoteController;
import com.example.tie.dtos.TelevisionDto;
import com.example.tie.dtos.TelevisionInputDto;
import com.example.tie.exceptions.RecordNotFoundException;
import com.example.tie.models.Television;
import com.example.tie.repositories.RemoteRepository;
import com.example.tie.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final RemoteRepository remoteRepository;

    @Autowired public TelevisionService (TelevisionRepository televisionRepository, RemoteRepository remoteRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteRepository = remoteRepository;
    }

//    public TelevisionService(RemoteRepository remoteRepository) {
//        this.remoteRepository = remoteRepository;
//    }
//
//    public TelevisionService(TelevisionRepository repo) {
//        this.repo = repo;
//    }


    public Iterable<TelevisionDto> getTelevisions() {
        Iterable<Television> allTvs = televisionRepository.findAll();
        ArrayList<TelevisionDto> tvDtoList = new ArrayList<>();

        for (Television tv : allTvs) {
            TelevisionDto tvDto = TelevisionDto.fromTelevision(tv);

            tvDtoList.add(tvDto);
        }
        return tvDtoList;
    }


    public TelevisionDto getTelevision(Long id) {
        if (televisionRepository.findById(id).isPresent()) {
            Television tv = televisionRepository.findById(id).get();

            return TelevisionDto.fromTelevision(tv);
            //return televisionRepository.findById(id).get();

        } else {
            throw new RecordNotFoundException(String.format("TV with id %d not found", id));
        }
    }


    public Long saveTelevision(TelevisionInputDto tvDto) {

        Television savedTv = televisionRepository.save(tvDto.toTelevision(tvDto));
        return savedTv.getId();
    }


    public TelevisionDto updateTelevision(Long id, TelevisionInputDto televisionInputDto) {
        if (televisionRepository.findById(id).isPresent()) {
            Television tv = televisionRepository.findById(id).get();

                Television tvUpdated = TelevisionDto.fromTelevision();
                tvUpdated.setId(tv.getId());

                televisionRepository.save(tvUpdated);

                return TelevisionDto.fromTelevision(tv);
            }



        public void deleteTelevision(Long id){
            televisionRepository.deleteById(id);

        }

        return null;

    }
}
