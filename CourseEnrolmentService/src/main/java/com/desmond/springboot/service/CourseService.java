package com.desmond.springboot.service;

import com.desmond.springboot.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course>getAllCourses();
    Course addCourse(Course course);
    Course getCourseById(int id);
    Course deleteCourse(int id);
    Course editCourse(int id, Course course);
    Course addReviewToCourse(int courseId, int reviewId);
    Course addStudentToCourse(int courseId, int studentId);
    Course removeStudentFromCourse(int courseId, int studentId);
    Course removeReviewFromCourse(int courseId, int reviewId);

}
