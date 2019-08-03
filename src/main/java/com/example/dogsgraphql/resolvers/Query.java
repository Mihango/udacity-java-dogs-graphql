package com.example.dogsgraphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.dogsgraphql.exceptions.DogNotFoundException;
import com.example.dogsgraphql.models.Dog;
import com.example.dogsgraphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class Query implements GraphQLQueryResolver {

    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<Dog> findAllDogs() {
        return StreamSupport.stream(dogRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Dog findDogById(Long id) {
        // return dogRepository.findById(id).orElseThrow(DogNotFoundException::new);
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found");
        }
    }
}
