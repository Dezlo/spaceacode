package ru.dezlo.room.security.requests;

import lombok.Data;

@Data
public class RequestAuth {
    private String login;
    private String password;
}