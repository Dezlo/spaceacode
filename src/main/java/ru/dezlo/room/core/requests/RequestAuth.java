package ru.dezlo.room.core.requests;

import lombok.Data;

@Data
public class RequestAuth {
    private String login;
    private String password;
}