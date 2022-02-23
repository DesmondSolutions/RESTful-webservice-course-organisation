package com.desmond.springboot.service;

import com.desmond.springboot.entity.InstructorDetails;

import java.util.List;

public interface InstructorDetailsService {

    List<InstructorDetails> getAllInstructorDetails();
    InstructorDetails getInstructorDetailsById(int id);
    InstructorDetails deleteInstructorDetails(int id);
    InstructorDetails saveInstructorDetails(InstructorDetails instructorDetails);
    InstructorDetails editInstructorDetails(int id, InstructorDetails instructorDetails);
}
