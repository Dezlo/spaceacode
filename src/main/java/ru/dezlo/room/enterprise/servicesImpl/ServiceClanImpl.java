package ru.dezlo.room.enterprise.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dezlo.room.enterprise.models.ModelClan;
import ru.dezlo.room.enterprise.repos.RepoClan;
import ru.dezlo.room.enterprise.services.ServiceClan;

@Service
public class ServiceClanImpl implements ServiceClan {

    @Autowired
    RepoClan repoClan;

    @Override
    public void createClan(String clanName) {
        ModelClan modelClan = ModelClan.builder()
                .name(clanName)
                .build();
        repoClan.save(modelClan);
    }
}
