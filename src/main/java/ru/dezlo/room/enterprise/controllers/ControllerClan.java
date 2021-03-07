package ru.dezlo.room.enterprise.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dezlo.room.enterprise.responses.common.Result;
import ru.dezlo.room.enterprise.services.ServiceClan;

import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/clan")
public class ControllerClan {

    @Autowired
    ServiceClan serviceClan;

    @PostMapping("/create")
    public Result createClan(@RequestBody Map<String, String> request){
        Result result;
        try {
            result = new Result();
            serviceClan.createClan(request.get("clanName"));

        } catch (Exception e){
            result = Result.builder()
                    .code(1)
                    .message(e.getLocalizedMessage())
                    .build();
        }
        return result;
    }


}
