package ru.lulka.models;

import lombok.*;
import ru.lulkast.models.User;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Post {
    final UUID uuid;
    final String userName;
    final String text;
    final String foto;
    final Date date;
    final Subject subject;

    public Post (String text, String foto, Subject subject){
        this.uuid = UUID.randomUUID();
        this.userName = "GUEST";
        this.date = new Date();
        this.foto = foto;
        this.subject = subject;
        this.text = text;
    }
    public Post (String text, String userName, String foto, Subject subject){
        this.uuid = UUID.randomUUID();
        this.date = new Date();
        this.foto = foto;
        this.subject = subject;
        this.text = text;
        this.userName = userName;
    }

    public Post(UUID uuid, String userName, String text, String foto, Date date, Subject subject) {
        this.uuid = uuid;
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
