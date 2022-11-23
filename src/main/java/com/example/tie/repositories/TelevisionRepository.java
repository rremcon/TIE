package com.example.tie.repositories;

import com.example.tie.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelevisionRepository extends JpaRepository<Television, Long> {

    //public Iterable<Television> findByBrand(String brand);

}
