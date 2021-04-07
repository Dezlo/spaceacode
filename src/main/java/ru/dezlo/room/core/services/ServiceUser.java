package ru.dezlo.room.core.services;

import ru.dezlo.room.core.models.ModelUser;

public interface ServiceUser {

    void saveUser(ModelUser modelUser);

    ModelUser findByNicknameOrEmail(String login);

    ModelUser findByLoginAndPassword(String login, String password);
}
