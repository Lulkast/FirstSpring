package ru.lulka.services;

import ru.lulka.models.Post;

import java.text.ParseException;
import java.util.Set;

public interface PostService {
    Set<Post> findBySubject(Post.Subject subject) throws ParseException;
    Set<Post> getAll() throws ParseException;
}
