package ru.lulkast.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.lulkast.models.Ad;

import javax.swing.*;

public interface AdRepository extends CrudRepository <Ad, Spring> {
    Ad findAdsBySubject (String subject);

}
