package com.example.blog.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //automatycznie zwiększa Id
    private Integer id;

    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL) //wskazuje na zmienną post w zmiennej Comment
    private List<Comment> comments = new ArrayList<>();

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

}
