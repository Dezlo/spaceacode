package ru.dezlo.room.core.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dezlo.room.core.models.ModelUser;
import ru.dezlo.room.core.repos.RepoUser;
import ru.dezlo.room.core.requests.RequestChangePassword;
import ru.dezlo.room.core.responses.common.ResponseCommonOne;
import ru.dezlo.room.core.responses.common.Result;
import ru.dezlo.room.core.services.ServiceSetting;
import ru.dezlo.room.core.services.ServiceUser;
import ru.dezlo.room.utils.ErrorCodes;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/setting")
public class ControllerSetting {

    @Autowired
    ServiceSetting serviceSetting;

    @Autowired
    ServiceUser serviceUser;

    @Autowired
    RepoUser repoUser;

    @PostMapping("/changePassword")
    public ResponseCommonOne changePassword(@RequestBody RequestChangePassword requestChangePassword) {
        Result result;
        ModelUser modelUser;
        try {
            result = new Result();
            modelUser = serviceUser.findByLoginAndPassword(requestChangePassword.getLogin(), requestChangePassword.getOldPassword());
            serviceSetting.changePassword(requestChangePassword, modelUser);

        } catch (Exception e) {
            result = Result.builder()
                    .code(ErrorCodes.forCode(ErrorCodes.USER_NOT_FOUND))
                    .message(ErrorCodes.forMessage(ErrorCodes.USER_NOT_FOUND))
                    .build();
        }
        return ResponseCommonOne.builder()
                .result(result)
                .build();
    }
}
