package com.desmond.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
}
