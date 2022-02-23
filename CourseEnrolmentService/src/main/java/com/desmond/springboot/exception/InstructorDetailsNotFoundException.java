package com.desmond.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InstructorDetailsNotFoundException extends RuntimeException{
    private int id;

    public InstructorDetailsNotFoundException(int id) {
        super(String.format("Instructor details with id : %d was not found", id));
        this.id = id;
    }
}
