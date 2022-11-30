package com.example.tie.services;

import com.example.tie.dtos.TelevisionDto;
import com.example.tie.dtos.TelevisionInputDto;
import com.example.tie.exceptions.RecordNotFoundException;
import com.example.tie.models.Television;
import com.example.tie.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class TelevisionService {

    private final TelevisionRepository repo;

    public TelevisionService(TelevisionRepository repo) {
        this.repo = repo;
    }


    public Iterable<TelevisionDto> getTvs() {
        Iterable<Television> allTvs = repo.findAll();
        ArrayList<TelevisionDto> tvDtoList = new ArrayList<>();

        for (Television tv : allTvs) {
            TelevisionDto tvDto = new TelevisionDto();

            tvDtoList.add(tvDto);
        }
        return tvDtoList;
    }


    public TelevisionDto getTv(Long id) {
        if (repo.findById(id).isPresent()) {
            Television tv = repo.findById(id).get();
        }
        return TelevisionDto.fromTelevision(tv);

    }


    public Long saveTv(TelevisionInputDto tvDto) {

        Television savedTv = repo.save(tvDto.toTelevision());

        return savedTv.getId();
    }


    public TelevisionDto updateTv(Long id, TelevisionInputDto tvInputDto) {
        if (repo.findById(id).isPresent()) {
            Television tv = repo.findById(id).get();

            repo.save(tv);

            return TelevisionDto.fromTelevision(tv);
        }



    public void deleteTv(Long id) {
            repo.deleteById(id);

        }

    }
}
