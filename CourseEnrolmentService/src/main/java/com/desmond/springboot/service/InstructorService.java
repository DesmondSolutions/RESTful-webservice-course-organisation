package com.desmond.springboot.service;

import com.desmond.springboot.entity.Course;
import com.desmond.springboot.entity.Instructor;

import java.util.List;

public interface InstructorService {

    List<Instructor> getAllInstructors();
    Instructor getInstructorById(int id);
    Instructor deleteInstructor(int id);
    Instructor saveInstructor(Instructor instructor);
    Instructor editInstructor(int InstructorId, Instructor instructor);
    Instructor addCourseToInstructor(int instructorId, int courseId);
    Instructor removeCourseFromInstructor(int instructorId, int courseId);
    List<Course> getAllCoursesOfferedByAParticularInstructor(int instructorId);




}
