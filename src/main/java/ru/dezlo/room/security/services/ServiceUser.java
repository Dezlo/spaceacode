package ru.dezlo.room.security.services;

import ru.dezlo.room.security.models.ModelUser;

public interface ServiceUser {

    void saveUser(ModelUser modelUser);

    ModelUser findByNicknameOrEmail(String login);

    ModelUser findByLoginAndPassword(String login, String password);
}