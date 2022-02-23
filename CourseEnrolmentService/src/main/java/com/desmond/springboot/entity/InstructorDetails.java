package com.desmond.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="instructor_detail")
public class InstructorDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="youtube_channel")
    private String youtubeChannel;
    @Column(name="hobby")
    private String hobby;


    @OneToOne(mappedBy="instructorDetail", cascade= {CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.MERGE,CascadeType.REFRESH})
    private Instructor instructor;

}
