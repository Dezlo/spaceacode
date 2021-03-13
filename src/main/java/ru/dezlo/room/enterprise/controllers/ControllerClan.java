package ru.dezlo.room.enterprise.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dezlo.room.enterprise.responses.ResponseClans;
import ru.dezlo.room.enterprise.responses.ResponseUserCountToClan;
import ru.dezlo.room.enterprise.responses.common.ResponseCommonList;
import ru.dezlo.room.enterprise.responses.common.ResponseCommonOne;
import ru.dezlo.room.enterprise.responses.common.Result;
import ru.dezlo.room.enterprise.services.ServiceClan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/clan")
public class ControllerClan {

    @Autowired
    ServiceClan serviceClan;

    @GetMapping("/create")
    public ResponseCommonOne<ResponseClans> getClan() {
        Result result;
        ResponseClans payload = new ResponseClans();
        try {
            result = new Result();
            payload = serviceClan.getClan();
        } catch (Exception e) {
            result = Result.builder()
                    .code(1)
                    .message(e.getLocalizedMessage())
                    .build();
        }
        return ResponseCommonOne.<ResponseClans>builder()
                .result(result)
                .payload(payload)
                .build();
    }

    @PostMapping("/create")
    public Result createClan(@RequestBody Map<String, String> request) {
        Result result;
        try {
            result = new Result();
            serviceClan.createClan(request.get("title"));

        } catch (Exception e) {
            result = Result.builder()
                    .code(1)
                    .message(e.getLocalizedMessage())
                    .build();
        }
        return result;
    }

    @GetMapping("/find")
    public ResponseCommonList<ResponseUserCountToClan> getUserCountInClan() {
        Result result;
        List<ResponseUserCountToClan> payload = new ArrayList<>();
        try {
            result = new Result();
            payload = serviceClan.getUserCountInClan();
        } catch (Exception e) {
            result = Result.builder()
                    .code(1)
                    .message(e.getLocalizedMessage())
                    .build();
        }
        return ResponseCommonList.<ResponseUserCountToClan>builder()
                .result(result)
                .payload(payload)
                .build();
    }
}
