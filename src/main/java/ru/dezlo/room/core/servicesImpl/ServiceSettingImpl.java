package ru.dezlo.room.core.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.dezlo.room.core.models.ModelUser;
import ru.dezlo.room.core.repos.RepoUser;
import ru.dezlo.room.core.requests.RequestChangePassword;
import ru.dezlo.room.core.services.ServiceSetting;

@Service
public class ServiceSettingImpl implements ServiceSetting {

    @Autowired
    RepoUser repoUser;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void changePassword(RequestChangePassword requestChangePassword, ModelUser modelUser) {
        modelUser.setPassword(passwordEncoder.encode(requestChangePassword.getNewPassword()));
        repoUser.save(modelUser);
    }
}
