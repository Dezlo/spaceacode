package ru.dezlo.room.security.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.dezlo.room.enterprise.responses.ResponseClans;
import ru.dezlo.room.enterprise.responses.ResponseLikes;
import ru.dezlo.room.security.models.ModelUser;
import ru.dezlo.room.security.responses.ResponseNicknames;

import java.util.List;
import java.util.Map;

public interface RepoUser extends JpaRepository<ModelUser, Integer> {

    ModelUser findByNicknameOrEmail(String login, String email);

    ModelUser findByEmail(String email);

    ModelUser findByNickname(String nickname);

    @Query(value = "select new ru.dezlo.room.security.responses.ResponseNicknames(l.id, l.nickname) " +
            "from ModelUser as l")
    List<ResponseNicknames> findNicknames();

}