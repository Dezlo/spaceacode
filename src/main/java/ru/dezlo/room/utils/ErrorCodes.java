package ru.dezlo.room.utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorCodes {
    NO_ERRORS(0, "No error"),
    EMAIL_ALREADY_EXISTS(1, "Email already exists"),
    NICKNAME_ALREADY_EXISTS(1, "Nickname already exist"),
    USER_NOT_FOUND(2, "User not found"),
    HASH_TAG_NOT_FOUND(3, "hash tag no found");

    private int code;
    private String message;

    public static int forCode(ErrorCodes e) {
        return e.code;
    }

    public static String forMessage(ErrorCodes e) {
        return e.message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}

