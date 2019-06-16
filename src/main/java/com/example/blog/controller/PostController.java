package com.example.blog.controller;

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

    @GetMapping("/add")
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
        modelMap.put("post", postRepository.findById(id).get());
        return "posts/show";
    }


}
