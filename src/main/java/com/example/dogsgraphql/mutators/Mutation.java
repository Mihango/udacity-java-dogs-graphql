package com.example.dogsgraphql.mutators;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.dogsgraphql.exceptions.DogNotFoundException;
import com.example.dogsgraphql.models.Dog;
import com.example.dogsgraphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog createDog(String name, String breed, String origin) {
        return dogRepository.save(new Dog(name, breed, origin));
    }

    public boolean deleteDog(Long id) {
        dogRepository.deleteById(id);
        return true;
    }

    public Dog updateDogName(Long id, String name) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(name);
            return dogRepository.save(dog);
        } else {
            throw new DogNotFoundException("Dog Not Found");
        }
    }
}
