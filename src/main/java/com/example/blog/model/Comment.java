package com.example.blog.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Post post; //pole do którego postu jest/odnosi się

    @Override
    public String toString() {
        return getDescription();
    }
}

