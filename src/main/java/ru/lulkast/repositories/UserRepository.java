package ru.lulkast.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.lulkast.models.User;

public interface UserRepository extends CrudRepository<User, String> {
}
