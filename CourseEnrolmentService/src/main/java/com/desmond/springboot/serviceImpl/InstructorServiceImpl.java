package com.desmond.springboot.serviceImpl;

import com.desmond.springboot.exception.InstructorNotFoundException;
import com.desmond.springboot.entity.Course;
import com.desmond.springboot.entity.Instructor;
import com.desmond.springboot.repository.InstructorRepository;
import com.desmond.springboot.service.CourseService;
import com.desmond.springboot.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private CourseService courseService;

    public InstructorServiceImpl(){

    }
    public InstructorServiceImpl(InstructorRepository instructorRepository, CourseService courseService) {
        this.instructorRepository = instructorRepository;
        this.courseService = courseService;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorById(int id) {
        return instructorRepository.findById(id).orElseThrow(() ->
                new InstructorNotFoundException(id));
    }

    @Override
    public Instructor deleteInstructor(int id) {
        Instructor instructorToDelete = getInstructorById(id);
        instructorRepository.delete(instructorToDelete);
        return instructorToDelete;
    }


    @Override
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    @Transactional
    public Instructor editInstructor(int instructorId, Instructor instructor) {
        Instructor instructorToEdit = getInstructorById(instructorId);
        instructorToEdit.setInstructorDetail(instructor.getInstructorDetail());
        instructorToEdit.setCourses(instructor.getCourses());
        instructorToEdit.setEmail(instructor.getEmail());
        instructorToEdit.setFirstName(instructor.getFirstName());
        instructorToEdit.setLastName(instructor.getLastName());
        return instructorToEdit;
    }

    @Override
    @Transactional
    public Instructor addCourseToInstructor(int instructorId, int courseId) {
        Instructor instructor = getInstructorById(instructorId);
        Course course = courseService.getCourseById(courseId) ;
        instructor.add(course);

        return instructor;
    }

    @Override
    @Transactional
    public Instructor removeCourseFromInstructor(int instructorId, int courseId) {
        Instructor instructor = getInstructorById(instructorId);
        Course course = courseService.getCourseById(courseId) ;
        instructor.remove(course);

        return instructor;
    }

    @Override
    @Transactional
    public List<Course> getAllCoursesOfferedByAParticularInstructor(int instructorId) {
        Instructor instructor = getInstructorById(instructorId);
        return instructor.getCourses();

    }
}
