package com.example.blog.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //automatycznie zwiększa Id
    private Integer id;

    private String content;

}
