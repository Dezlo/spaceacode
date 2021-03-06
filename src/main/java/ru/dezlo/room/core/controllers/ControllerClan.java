package ru.dezlo.room.core.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dezlo.room.core.models.ModelUserToClan;
import ru.dezlo.room.core.responses.ResponseClans;
import ru.dezlo.room.core.responses.ResponseUserCountToClan;
import ru.dezlo.room.core.responses.common.ResponseCommonList;
import ru.dezlo.room.core.responses.common.ResponseCommonOne;
import ru.dezlo.room.core.responses.common.Result;
import ru.dezlo.room.core.services.ServiceClan;

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

    /**
     * @return Result
     */

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

    /**
     * @param request -> String title
     * @return Result
     */

    @PostMapping("/create")
    public Result createClan(@RequestBody Map<String, String> request) {
        log.debug("request: " + request);
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

    /**
     * @return Result
     */

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

    /**
     * @param modelUserToClan -> {
     *                        Integer userId;
     *                        Integer clanId;
     *                        }
     * @return Result
     */

    @PostMapping("/addUser")
    public ResponseCommonOne addUserToClan(@RequestBody ModelUserToClan modelUserToClan) {
        Result result;
        try {
            serviceClan.addUserToClan(modelUserToClan);
            result = new Result();
        } catch (Exception e) {
            result = Result.builder()
                    .code(1)
                    .message(e.getLocalizedMessage())
                    .build();
        }
        return ResponseCommonOne.builder()
                .result(result)
                .build();
    }
}
