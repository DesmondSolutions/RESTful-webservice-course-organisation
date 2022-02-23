package com.desmond.springboot.resource;

import com.desmond.springboot.entity.Course;
import com.desmond.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

        @PostMapping
        public ResponseEntity<Course> addCourse(@RequestBody final Course course){
            return new ResponseEntity<>(courseService.addCourse(course), HttpStatus.CREATED);

        }

        @GetMapping
        public ResponseEntity<List<Course>> getCourses(){
            return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
        }

        @GetMapping("/{courseId}")
        public ResponseEntity<Course> getCourseById(@PathVariable final int courseId){
            return new ResponseEntity<>(courseService.getCourseById(courseId), HttpStatus.OK);
        }

        @DeleteMapping("/{courseId}")
        public ResponseEntity<Course> deleteCourse(@PathVariable final int courseId){
            return new ResponseEntity<>(courseService.deleteCourse(courseId), HttpStatus.OK);
        }

        @PutMapping("/{courseId}")
        public ResponseEntity<Course> editCourse(@PathVariable final int courseId,
                           @RequestBody final Course course){
            return new ResponseEntity<>(courseService.editCourse(courseId,course), HttpStatus.OK);
        }

        @PostMapping("/{courseId}/reviews/add/{reviewId}")
        public ResponseEntity<Course> addCourseReview(@PathVariable final int courseId,
                            @PathVariable final int reviewId){
            return new ResponseEntity<>(courseService.addReviewToCourse(courseId, reviewId), HttpStatus.CREATED);
        }

        @DeleteMapping("/{courseId}/reviews/delete/{reviewId}")
        public ResponseEntity<Course> removeCourseReview(@PathVariable final int courseId,
                                                        @PathVariable final int reviewId) {
            return new ResponseEntity<>(courseService.removeReviewFromCourse(courseId, reviewId), HttpStatus.OK);
        }

        @PostMapping("/{courseId}/students/add/{studentId}")
        public ResponseEntity<Course> addStudentToCourse(@PathVariable final int courseId,
                                                         @PathVariable final int studentId) {
            return new ResponseEntity<>(courseService.addStudentToCourse(courseId, studentId), HttpStatus.CREATED);
        }

        @DeleteMapping("/{courseId}/students/delete/{studentId}")
        public ResponseEntity<Course> removeStudentFromCourse(@PathVariable final int courseId,
                                                              @PathVariable final int studentId){
            return new ResponseEntity<>(courseService.removeStudentFromCourse(courseId, studentId), HttpStatus.CREATED);
        }

}
