package com.desmond.springboot.serviceImpl;

import com.desmond.springboot.exception.InstructorDetailsNotFoundException;
import com.desmond.springboot.entity.InstructorDetails;
import com.desmond.springboot.repository.InstructorDetailsRepository;
import com.desmond.springboot.service.InstructorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorDetailsServiceImpl implements InstructorDetailsService {

    @Autowired
    private InstructorDetailsRepository instructorDetailsRepository;

    public InstructorDetailsServiceImpl(InstructorDetailsRepository instructorDetailsRepository) {
        this.instructorDetailsRepository = instructorDetailsRepository;
    }

    @Override
    public List<InstructorDetails> getAllInstructorDetails() {
        return instructorDetailsRepository.findAll();
    }

    @Override
    public InstructorDetails getInstructorDetailsById(int id) {
        return instructorDetailsRepository.findById(id).orElseThrow(() ->
                new InstructorDetailsNotFoundException(id));
    }

    @Override
    public InstructorDetails deleteInstructorDetails(int id) {
        InstructorDetails instructorDetails = getInstructorDetailsById(id);
        instructorDetailsRepository.delete(instructorDetails);
        return instructorDetails;
    }

    @Override
    public InstructorDetails saveInstructorDetails(InstructorDetails instructorDetails) {
        return instructorDetailsRepository.save(instructorDetails);
    }

    @Override
    @Transactional
    public InstructorDetails editInstructorDetails(int id, InstructorDetails instructorDetails) {
        InstructorDetails instructorDetailsToEdit = getInstructorDetailsById(id);
        instructorDetailsToEdit.setInstructor(instructorDetails.getInstructor());
        instructorDetailsToEdit.setHobby(instructorDetails.getHobby());

        return instructorDetailsToEdit;
    }
}
