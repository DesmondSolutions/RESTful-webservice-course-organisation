package com.desmond.springboot.service;

import com.desmond.springboot.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    Student deleteStudent(int id);
    Student editStudent(int studentId, Student student);
    Student addStudent(Student student);




}
