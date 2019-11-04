package ru.lulkast.services;

import ru.lulkast.exceptions.UserNotFoundException;
import ru.lulkast.models.User;

import java.util.Set;
import java.util.UUID;

    public interface UserService {
        User getByUUID(UUID uuid) throws UserNotFoundException;

        User save(User user);

        Set<User> getAll();
    }

