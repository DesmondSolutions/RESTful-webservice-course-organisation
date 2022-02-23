package com.desmond.springboot.serviceImpl;

import com.desmond.springboot.exception.CourseNotFoundException;
import com.desmond.springboot.entity.Course;
import com.desmond.springboot.entity.Review;
import com.desmond.springboot.entity.Student;
import com.desmond.springboot.repository.CourseRepository;
import com.desmond.springboot.service.CourseService;
import com.desmond.springboot.service.ReviewService;
import com.desmond.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ReviewService reviewService;

    public CourseServiceImpl(){

    }

    public CourseServiceImpl(CourseRepository courseRepository, StudentService studentService,
                               ReviewService reviewService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
        this.reviewService = reviewService;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElseThrow(() ->
               new CourseNotFoundException(id));
    }

    @Override
    public Course deleteCourse(int id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
        return course;
    }

    @Override
    @Transactional
    public Course editCourse(int id, Course course) {
        Course courseToEdit = getCourseById(id);
        courseToEdit.setTitle(course.getTitle());
        courseToEdit.setInstructor(course.getInstructor());
        courseToEdit.setStudents(course.getStudents());
        courseToEdit.setReviews(course.getReviews());

        return courseToEdit;
    }

    @Override
    @Transactional
    public Course addReviewToCourse(int courseId, int reviewId) {
        Course course = getCourseById(courseId);
        Review review = reviewService.getReviewById(reviewId);
        course.addReview(review);
        return course;
    }

    @Override
    @Transactional
    public Course addStudentToCourse(int courseId, int studentId) {
        Course course = getCourseById(courseId);
        Student student = studentService.getStudentById(studentId);
        course.addStudent(student);
        return course;
    }

    @Override
    @Transactional
    public Course removeStudentFromCourse(int courseId, int studentId) {
        Course course = getCourseById(courseId);
        Student student = studentService.getStudentById(studentId);
        course.removeStudent(student);
        return course;
    }

    @Override
    @Transactional
    public Course removeReviewFromCourse(int courseId, int reviewId) {
        Course course = getCourseById(courseId);
        Review review = reviewService.getReviewById(reviewId);
        course.removeReview(review);
        return course;
    }
}
