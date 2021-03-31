package ru.dezlo.room.security.services;

import ru.dezlo.room.security.models.ModelUser;
import ru.dezlo.room.security.requests.RequestChangePassword;

public interface ServiceSetting {

    void changePassword(RequestChangePassword requestChangePassword, ModelUser modelUser);
}
