package ru.dezlo.room.enterprise.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dezlo.room.enterprise.models.ModelChallenge;
import ru.dezlo.room.enterprise.repos.RepoChallenge;
import ru.dezlo.room.enterprise.services.ServiceChallenge;
import ru.dezlo.room.utils.DateUtils;

import java.util.List;

@Service
public class ServiceChallengeImpl implements ServiceChallenge {

    @Autowired
    RepoChallenge repoChallenge;

    @Override
    public List<ModelChallenge> getChallenges() {
        List<ModelChallenge> list = repoChallenge.findAll();
        return list;
    }
}
