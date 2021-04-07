package ru.dezlo.room.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.dezlo.room.core.models.ModelUser;
import ru.dezlo.room.core.responses.ResponseNicknames;

import java.util.List;

public interface RepoUser extends JpaRepository<ModelUser, Integer> {

    ModelUser findByNicknameOrEmail(String login, String email);

    ModelUser findByEmail(String email);

    ModelUser findByNickname(String nickname);

    @Query(value = "select new ru.dezlo.room.core.responses.ResponseNicknames(l.id, l.nickname) " +
            "from ModelUser as l")
    List<ResponseNicknames> findNicknames();

}