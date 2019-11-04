package ru.lulka.repositories;

import ru.lulka.models.Post;

import java.text.ParseException;
import java.util.Set;

public interface PostRepository {

    Set<Post> findBySubject(Post.Subject subject) throws ParseException;

    Post savePost(Post post);

    Set<Post> findAll() throws ParseException;
}
