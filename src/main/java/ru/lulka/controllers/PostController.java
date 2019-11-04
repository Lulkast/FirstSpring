package ru.lulka.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lulka.models.Post;

import java.text.ParseException;
import java.util.Set;

public interface PostController {

    public String findBySubject(@RequestParam("subject") String subject, Model model) throws ParseException;

    String getAllPosts(Model model) throws ParseException;
}
