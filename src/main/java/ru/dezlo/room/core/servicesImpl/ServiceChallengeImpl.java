package ru.dezlo.room.core.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dezlo.room.core.models.ModelChallenge;
import ru.dezlo.room.core.repos.RepoChallenge;
import ru.dezlo.room.core.services.ServiceChallenge;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ServiceChallengeImpl implements ServiceChallenge {

    @Autowired
    RepoChallenge repoChallenge;

    @Override
    public List<ModelChallenge> getChallenges() {
        List<ModelChallenge> list = repoChallenge.findAll();
        List<ModelChallenge> result = new ArrayList<>();
        list.forEach(elem -> {
                    if (new Date().before(elem.getTimeInterval())) {
                        result.add(elem);
                    }
                }
        );
        return result;
    }
}
