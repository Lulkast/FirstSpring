package ru.lulkast.services;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lulkast.exceptions.UserNotFoundException;
import ru.lulkast.models.User;
import ru.lulkast.repositories.UserRepository;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImplement implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceImplement(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getByUUID(UUID uuid) throws UserNotFoundException {
        User foundUser = repository.findByUUID(uuid);
        if (Objects.isNull(foundUser)) throw new UserNotFoundException("User is not found");
        return foundUser;
    }

    @Override
    public User save(User user) {
        try {
            if (Objects.isNull(user) ||
                    Strings.isNullOrEmpty(user.getUserName())||
                    Strings.isNullOrEmpty(user.getPassword())) throw new IllegalArgumentException("userName or password is null");
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

        return repository.saveUser(user);
    }


    @Override
    public Set<User> getAll() {
        return repository.findAll();
    }
}
