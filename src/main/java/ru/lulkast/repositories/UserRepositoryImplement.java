package ru.lulkast.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.lulkast.models.User;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImplement implements UserRepository {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImplement(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

    @Override
    public Set<User> findAll() {
        final List <Map <String, Object>> usersAsList = jdbcTemplate.queryForList("select id, username, password from Users");
        return usersAsList.stream().map(this::convertUserFromMap).collect(Collectors.toSet());
    }

    private User convertUserFromMap(Map<String, Object> userAsMap){
        return new User(UUID.fromString(userAsMap.get("id").toString()), userAsMap.get("username").toString(), userAsMap.get("password").toString());
    }
}
