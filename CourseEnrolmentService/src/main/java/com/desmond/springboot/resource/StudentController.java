package com.desmond.springboot.resource;

import com.desmond.springboot.entity.Student;
import com.desmond.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> GetAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable("studentId") final int studentId){
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody final Student student){
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@RequestBody final Student student,
                                                 @PathVariable final int studentId){
        return  new ResponseEntity<>(studentService.editStudent(studentId, student), HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Student> removeStudent(@PathVariable final int studentId){
        return new ResponseEntity<>(studentService.deleteStudent(studentId), HttpStatus.OK);
    }



}
