package ru.dezlo.room.core.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.dezlo.room.core.models.ModelRole;
import ru.dezlo.room.core.models.ModelUser;
import ru.dezlo.room.core.repos.RepoUser;
import ru.dezlo.room.core.repos.RepoRole;
import ru.dezlo.room.core.services.ServiceUser;

@Service
public class ServiceUserImpl implements ServiceUser {

    @Autowired
    private RepoUser repoUser;
    @Autowired
    private RepoRole repoRole;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(ModelUser modelUser) {
        ModelRole userModelRole = repoRole.findByName("ROLE_USER");
        modelUser.setModelRole(userModelRole);
        modelUser.setPassword(passwordEncoder.encode(modelUser.getPassword()));
        repoUser.save(modelUser);
    }

    public ModelUser findByNicknameOrEmail(String login) {
        return repoUser.findByNicknameOrEmail(login, login);
    }

    public ModelUser findByLoginAndPassword(String login, String password) {
        ModelUser modelUser = findByNicknameOrEmail(login);
        if (modelUser != null) {
            if (passwordEncoder.matches(password, modelUser.getPassword())) {
                return modelUser;
            }
        }
        return null;
    }
}