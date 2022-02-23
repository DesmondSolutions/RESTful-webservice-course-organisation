package com.desmond.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="review")
@Data
public class Review {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="comment")
    private String comments;

}
