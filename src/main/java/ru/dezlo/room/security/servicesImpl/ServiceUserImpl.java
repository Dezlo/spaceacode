package ru.dezlo.room.security.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.dezlo.room.security.models.ModelRole;
import ru.dezlo.room.security.models.ModelUser;
import ru.dezlo.room.security.repos.RepositoryRole;
import ru.dezlo.room.security.repos.RepoUser;

@Service
public class ServiceUserImpl implements ServiceUser{

    @Autowired
    private RepoUser repoUser;
    @Autowired
    private RepositoryRole repositoryRole;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(ModelUser modelUser) {
        ModelRole userModelRole = repositoryRole.findByName("ROLE_USER");
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