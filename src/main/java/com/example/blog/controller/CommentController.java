package com.example.blog.controller;

import com.example.blog.model.Comment;
import com.example.blog.repository.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/comments")
@Controller
public class CommentController {

    private CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    //@ResponseBody
    @PostMapping("")
    public String create(@ModelAttribute Comment comment, RedirectAttributes redirectAttributes){
        commentRepository.save(comment);
        redirectAttributes.addFlashAttribute("message","Added");
        return "redirect:/posts/" + comment.getPost().getId();
    }


}
