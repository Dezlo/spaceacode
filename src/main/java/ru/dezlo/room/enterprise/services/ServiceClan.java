package ru.dezlo.room.enterprise.services;

import org.springframework.stereotype.Service;
import ru.dezlo.room.enterprise.responses.ResponseClans;

@Service
public interface ServiceClan {

    ResponseClans getClan();

    void createClan(String title);
}
