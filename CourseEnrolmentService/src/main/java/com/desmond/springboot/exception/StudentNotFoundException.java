package com.desmond.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException{
    private int id;

    public StudentNotFoundException(int id) {
        super(String.format("Student with id: %d was not found", id ));
        this.id = id;
    }


}
