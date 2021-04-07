package ru.dezlo.room.core.services;

import org.springframework.stereotype.Service;
import ru.dezlo.room.core.models.ModelUserToClan;
import ru.dezlo.room.core.responses.ResponseClans;
import ru.dezlo.room.core.responses.ResponseUserCountToClan;

import java.sql.SQLException;
import java.util.List;

@Service
public interface ServiceClan {

    ResponseClans getClan();

    void createClan(String title);

    List<ResponseUserCountToClan> getUserCountInClan() throws SQLException;

    void addUserToClan(ModelUserToClan modelUserToClan);
}
