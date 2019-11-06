package ru.lulkast.services;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lulkast.exceptions.UserNotFoundException;
import ru.lulkast.models.User;
import ru.lulkast.repositories.UserRepository;

import java.util.Objects;
import java.util.Set;

@Service
public class UserServiceImplement
        extends BaseAbstractService <User, String, UserRepository>
        implements UserService {

//    private UserRepository repository;
//
//    @Autowired
//    public UserServiceImplement(UserRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public User getById(String id) {
//        User foundUser =  repository.findById(id).get();
//        return foundUser;
//    }
//
//    @Override
//    public User save(User user) {
//        try {
//            if (Objects.isNull(user) ||
//                    Strings.isNullOrEmpty(user.getUserName()) ||
//                    Strings.isNullOrEmpty(user.getPassword()))
//                throw new IllegalArgumentException("userName or password is null");
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }
//        return repository.save(user);
//    }
//
//
//    @Override
//    public Set<User> getAll() {
//        return (Set<User>) repository.findAll();
//    }

}
