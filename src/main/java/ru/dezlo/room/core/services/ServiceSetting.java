package ru.dezlo.room.core.services;

import ru.dezlo.room.core.models.ModelUser;
import ru.dezlo.room.core.requests.RequestChangePassword;

public interface ServiceSetting {

    void changePassword(RequestChangePassword requestChangePassword, ModelUser modelUser);
}
