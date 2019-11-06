package ru.lulkast.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "AdNeo")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Ad {

    @Id
    private String id;
    private String userName;
    private String text;
    private String foto;
    private Date date;
    private Subject subject;

    public Ad(String text, String foto, Subject subject) {
        this.id = UUID.randomUUID().toString();
        this.userName = "GUEST";
        this.date = new Date();
        this.foto = foto;
        this.subject = subject;
        this.text = text;
    }

    public Ad(String text, String userName, String foto, Subject subject) {
        this.id = UUID.randomUUID().toString();
        this.date = new Date();
        this.foto = foto;
        this.subject = subject;
        this.text = text;
        this.userName = userName;
    }

    public Ad(String id, String userName, String text, String foto, Date date, Subject subject) {
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

