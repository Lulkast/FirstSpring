package ru.lulkast.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
    private static final long serialVersionUID = 1L;

    private UUID uuid;
    private String userName;
    private String password;

    public User(UUID uuid, String userName, String password) {
        this.uuid = uuid;
        this.userName = userName;
        this.password = password;
    }

    public User( String userName, String password) {
        this.uuid = UUID.randomUUID();
        this.userName = userName;
        this.password = password;
    }
}

