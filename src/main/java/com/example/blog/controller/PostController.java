package com.example.blog.controller;

import com.example.blog.model.Comment;
import com.example.blog.model.Post;
import com.example.blog.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/posts")
@Controller
public class PostController {

    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/add") //zmienna dla adnotacji
    public String addPost(ModelMap modelMap){
        modelMap.put("post", new Post());
        return "posts/add"; //skierowanie do pliku html
    }

    @PostMapping("") //obsługa
    public String createPost(@ModelAttribute Post post){
        postRepository.save(post);
        return "redirect:/posts/" + post.getId();
    }

    // posts/1
    @GetMapping("/{id}")
    public String showPost(@PathVariable Integer id, ModelMap modelMap){
        Post post =postRepository.findById(id).get();
        modelMap.put("post", post);
        Comment comment = new Comment();
        comment.setPost(post);
        //musimy przekazać pusty komentarz
        modelMap.put("comment", comment);
        modelMap.put("comments", post.getComments());//dodawanie komentarzy
        return "posts/show";
    }



}