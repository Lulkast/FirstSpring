package ru.lulka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lulka.models.Post;
import ru.lulka.services.PostService;

import java.text.ParseException;
import java.util.Set;

@Controller
public class PostControllerImplementation implements PostController {

    private PostService service;

    @Autowired
    public PostControllerImplementation(PostService service) {
        this.service = service;
    }

    @GetMapping("/post/subject")
    @Override
    public String findBySubject(@RequestParam ("subject") String subject, Model model) throws ParseException {
        final Set<Post> allPosts = service.findBySubject(Post.Subject.valueOf(subject));
        model.addAttribute("posts", allPosts);
        return "users/posts";
    }

    @GetMapping("/post/all")
    @Override
    public String getAllPosts(Model model) throws ParseException {
        final Set<Post> allPosts = service.getAll();
        model.addAttribute("posts", allPosts);
        return "users/posts";
    }
}
