package ru.dezlo.room.enterprise.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dezlo.room.enterprise.models.ModelChallenge;
import ru.dezlo.room.enterprise.services.ServiceChallenge;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/challenge")
public class ControllerChallenge {

    @Autowired
    ServiceChallenge serviceChallenge;

    @GetMapping
    public List<ModelChallenge> getChallenges() {
        return serviceChallenge.getChallenges();
    }
}
