package com.example.dogsgraphql.service;

import com.example.dogs.models.Dog;

import java.util.List;

public interface DogService {
    List<String> retrieveDogBreed();
    Dog retrieveDogById(Long id);
    List<String> retrieveDogNames();
    Iterable<Dog> retrieveDogs();
}
