package com.desmond.springboot.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
                   CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
    private Instructor instructor;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    private List<Review> reviews;

    @JsonIgnore
    @ManyToMany(fetch= FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name="course_student",
            joinColumns=@JoinColumn(name="course_id"),
            inverseJoinColumns=@JoinColumn(name="student_id"))
    private List<Student> students;


    @Transactional
    public void addReview(Review tempReview) {
        if(reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(tempReview);
    }

    @Transactional
    public void removeReview(Review tempReview) {
        if(reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.remove(tempReview);
    }

    @Transactional
    public void addStudent(Student theStudent) {
        if(students == null) {
            students = new ArrayList<>();
        }
        students.add(theStudent);
    }

    @Transactional
    public void removeStudent(Student tempStudent){
        if(students == null){
            students = new ArrayList<>();
        }
        students.remove(tempStudent);
    }
}
