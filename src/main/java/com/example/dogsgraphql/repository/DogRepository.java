package com.example.dogsgraphql.repository;

import com.example.dogsgraphql.models.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query("select d.id, d.name from Dog d")
    List<String> findAllName();
}
