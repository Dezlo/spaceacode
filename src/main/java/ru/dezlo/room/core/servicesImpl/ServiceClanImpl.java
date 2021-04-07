package ru.dezlo.room.core.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.dezlo.room.core.models.ModelClan;
import ru.dezlo.room.core.models.ModelUserToClan;
import ru.dezlo.room.core.repos.RepoClan;
import ru.dezlo.room.core.repos.RepoUser;
import ru.dezlo.room.core.repos.RepoUserToClan;
import ru.dezlo.room.core.responses.ResponseClans;
import ru.dezlo.room.core.responses.ResponseUserCountToClan;
import ru.dezlo.room.core.services.ServiceClan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceClanImpl implements ServiceClan {

    @Autowired
    RepoClan repoClan;
    @Autowired
    RepoUser repoUser;
    @Autowired
    RepoUserToClan repoUserToClan;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public ResponseClans getClan() {

        return ResponseClans.builder()
                .users(repoUser.findNicknames())
                .clans(repoClan.findAll())
                .build();
    }

    @Override
    public void createClan(String title) {
        ModelClan modelClan = ModelClan.builder()
                .title(title)
                .build();
        repoClan.save(modelClan);
    }

    @Override
    public List<ResponseUserCountToClan> getUserCountInClan() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select clan_id, " +
                "(select title from clan where clan.id = clan_id), " +
                "count(user_id) from user_to_clan " +
                "group by clan_id");
        List<ResponseUserCountToClan> responseUserCountToClan = new ArrayList<>();
        while (resultSet.next()) {
            responseUserCountToClan.add(ResponseUserCountToClan.builder()
                    .id(resultSet.getInt("clan_id"))
                    .title(resultSet.getString("title"))
                    .count(resultSet.getLong("count"))
                    .build());
        }
        resultSet.close();
        statement.close();
        connection.close();
        return responseUserCountToClan;
    }

    @Override
    public void addUserToClan(ModelUserToClan modelUserToClan) {
        repoUserToClan.save(modelUserToClan);
    }
}
