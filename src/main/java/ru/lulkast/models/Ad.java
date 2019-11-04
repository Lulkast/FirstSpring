package ru.lulkast.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "AD")
public class Ad {
    @Id
    final String id;
    final String userName;
    final String text;
    final String foto;
    final Date date;
    final ru.lulka.models.Post.Subject subject;

    public Ad(String text, String foto, ru.lulka.models.Post.Subject subject) {
        this.id = UUID.randomUUID().toString();
        this.userName = "GUEST";
        this.date = new Date();
        this.foto = foto;
        this.subject = subject;
        this.text = text;
    }

    public Ad(String text, String userName, String foto, ru.lulka.models.Post.Subject subject) {
        this.id = UUID.randomUUID().toString();
        this.date = new Date();
        this.foto = foto;
        this.subject = subject;
        this.text = text;
        this.userName = userName;
    }

    public Ad(String id, String userName, String text, String foto, Date date, ru.lulka.models.Post.Subject subject) {
        this.id = id;
        this.userName = userName;
        this.text = text;
        this.foto = foto;
        this.date = date;
        this.subject = subject;
    }

    public enum Subject {
        CLOTHES,
        WORK,
        CARS,
        ANIMALS,
        SERVICEZ,
        REAL_ESTATE
    }
}

