package com.desmond.springboot.serviceImpl;

import com.desmond.springboot.exception.StudentNotFoundException;
import com.desmond.springboot.entity.Student;
import com.desmond.springboot.repository.StudentRepository;
import com.desmond.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(){

    }
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow(() ->
                new StudentNotFoundException(id));
    }

    @Override
    public Student deleteStudent(int id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
        return student;
    }

    @Override
    @Transactional
    public Student editStudent(int studentId, Student student) {
        Student studentToEdit = getStudentById(studentId);
        studentToEdit.setEmail(student.getEmail());
        studentToEdit.setFirstName(student.getFirstName());
        studentToEdit.setLastName(student.getLastName());

        return studentToEdit;
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }


}
