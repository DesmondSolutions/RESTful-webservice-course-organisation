package com.desmond.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReviewNotFoundException extends RuntimeException{
    private int id;

    public ReviewNotFoundException(int id) {
        super(String.format("Review with id : %d was not found", id));
        this.id = id;
    }
}
