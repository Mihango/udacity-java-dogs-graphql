package com.example.dogsgraphql.service.impl;

import com.example.dogs.exceptions.DogNotFoundExceptions;
import com.example.dogs.models.Dog;
import com.example.dogs.repository.DogRepository;
import com.example.dogs.service.DogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DogServiceImpl implements DogService {

    private DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<String> retrieveDogBreed() {
        return StreamSupport.stream(dogRepository.findAll().spliterator(), false)
                .map(Dog::getBreed)
                .collect(Collectors.toList());
    }

    public Dog retrieveDogById(Long id) {
        return dogRepository.findById(id).orElseThrow(DogNotFoundExceptions::new);
    }

    public List<String> retrieveDogNames() {
//        return StreamSupport.stream(dogRepository.findAll().spliterator(), false)
//                .map(Dog::getName)
//                .collect(Collectors.toList());

        return dogRepository.findAllName();
    }

    @Override
    public Iterable<Dog> retrieveDogs() {
        return dogRepository.findAll();
    }
}
