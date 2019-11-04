package ru.lulka.repositories;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.lulka.models.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/*
    @Override
    public User findByUUID(UUID uuid) {
     final Map<String, Object> userAsMap = jdbcTemplate.queryForMap("select id, username, password from " +
                "users where id=?", uuid.toString());
        User findedUser = convertUserFromMap(userAsMap);
        return findedUser;
    }
    @Override
    public User saveUser(User user)  {
     if (Objects.isNull(user.getUuid())) user.setUuid(UUID.randomUUID());
        jdbcTemplate.update("insert into users (id, username, password)" +
                "values (?, ?, ?)", user.getUuid().toString(), user.getUserName(), user.getPassword());
        return findByUUID(user.getUuid());
    }
*/
@Repository
public class PostRepositoryImplement implements PostRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PostRepositoryImplement(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Set<Post> findBySubject(Post.Subject subject) throws ParseException {

        final List <Map <String, Object>> postAsList = jdbcTemplate.queryForList("select id, username, texd, foto, postdate, subject from posts" +
                "posts where subject=?", subject.toString());
        Set <Post> posts = new HashSet<>();
        for (Map<String, Object> stringObjectMap : postAsList) {
            posts.add(convertPostFromMap(stringObjectMap));
        }
        return posts;
    }

    @Override
    public Post savePost(Post post) {
        return null;
    }

    @Override
    public Set<Post> findAll() throws ParseException {
        final List<Map<String, Object>> postsAsList = jdbcTemplate.queryForList("select id, username, texd, foto, postdate, subject from posts");
        Set<Post> posts = new HashSet<>();
        for (Map<String, Object> stringObjectMap : postsAsList) {
            posts.add(convertPostFromMap(stringObjectMap));
        }
        return posts;
    }

    private Post convertPostFromMap(Map<String, Object> postAsMap) throws ParseException {
        String s = postAsMap.get("postdate").toString();
        Date date = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(s);
        Post.Subject subject = Post.Subject.valueOf(postAsMap.get("subject").toString());
        return new Post(UUID.fromString(postAsMap.get("id").toString()), postAsMap.get("username").toString(), postAsMap.get("texd").toString(), postAsMap.get("foto").toString(), date, subject);
    }
}
