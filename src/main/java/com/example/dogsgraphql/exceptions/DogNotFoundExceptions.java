package com.example.dogsgraphql.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dog not found")
public class DogNotFoundExceptions extends RuntimeException {

    public DogNotFoundExceptions() {
    }

    public DogNotFoundExceptions(String message) {
        super(message);
    }
}
