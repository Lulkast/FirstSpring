package ru.lulkast.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.lulkast.models.Ad;

public interface AdRepository extends CrudRepository <Ad, String> {
    Ad findAdBySubject (Ad.Subject subject);
}
