package com.desmond.springboot.resource;

import com.desmond.springboot.entity.Course;
import com.desmond.springboot.entity.Instructor;
import com.desmond.springboot.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @PostMapping
    public ResponseEntity<Instructor> addInstructor(@RequestBody final Instructor instructor){
        return new ResponseEntity<Instructor>(instructorService.saveInstructor(instructor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors(){
        return new ResponseEntity <List<Instructor>>(instructorService.getAllInstructors(), HttpStatus.OK);
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable("instructorId") final int id){
        return new ResponseEntity<Instructor>(instructorService.getInstructorById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{instructorId}")
    public ResponseEntity<Instructor> deleteInstructor(@PathVariable("instructorId")final int id){
        return new ResponseEntity<Instructor>(instructorService.deleteInstructor(id), HttpStatus.OK);
    }

    @PutMapping("/{instructorId}")
    public ResponseEntity<Instructor> editCustomer(@PathVariable("instructorId")final int id,
                                                  @RequestBody final Instructor instructor){
        return new ResponseEntity<Instructor>(instructorService.editInstructor(id, instructor), HttpStatus.OK);
    }

    @PostMapping("/{instructorId}/{courseId}")
    public ResponseEntity<Instructor> addCourseToInstructor(@PathVariable("instructorId") final int instructorId,
                                                         @PathVariable("courseId") final int courseId){
        return new ResponseEntity<Instructor>(instructorService.addCourseToInstructor(instructorId, courseId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{instructorId}/{courseId}")
    public ResponseEntity<Instructor> deleteCourseFromInstructor(@PathVariable("customerId") final int instructorId,
                                                               @PathVariable final int courseId){
        return new ResponseEntity<Instructor>(instructorService.removeCourseFromInstructor(instructorId, courseId), HttpStatus.OK);
    }

    @GetMapping("/{instructorId}/courses")
    public ResponseEntity<List<Course>> readAllCoursesByInstructorId(@PathVariable("instructorId") final int instructorId){
        return new ResponseEntity <List<Course>>(instructorService.getAllCoursesOfferedByAParticularInstructor(instructorId), HttpStatus.OK);

    }

}
