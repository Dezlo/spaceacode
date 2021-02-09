package ru.dezlo.room.security.requests;

import lombok.Data;


@Data
public class RequestRegister {

    private String nickname;

    private String email;

    private String password;
}