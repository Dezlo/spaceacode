package ru.dezlo.room.security.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dezlo.room.security.models.ModelUser;

public interface RepositoryUser extends JpaRepository<ModelUser, Integer> {

    ModelUser findByNicknameOrEmail(String login, String email);

    ModelUser findByEmail(String email);

    ModelUser findByNickname(String nickname);

}