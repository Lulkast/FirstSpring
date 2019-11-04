package ru.lulka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lulka.models.Post;
import ru.lulka.repositories.PostRepository;

import java.text.ParseException;
import java.util.Set;

@Service
public class PostServiceImplementation implements PostService {

    private PostRepository repository;

    @Autowired
    public PostServiceImplementation(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Post> findBySubject(Post.Subject subject) throws ParseException{
        return repository.findBySubject(subject);
    }

    @Override
    public Set<Post> getAll() throws ParseException {
        return repository.findAll();
    }
}
