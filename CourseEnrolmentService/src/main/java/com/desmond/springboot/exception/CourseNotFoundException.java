package com.desmond.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends RuntimeException{
    private int id;

    public CourseNotFoundException(int id) {
        super(String.format("Course with id: %d not found", id));
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
