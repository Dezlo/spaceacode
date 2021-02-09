package ru.dezlo.room.security.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.dezlo.room.security.jwt.JwtProvider;
import ru.dezlo.room.security.models.ModelUser;
import ru.dezlo.room.security.repos.RepositoryUser;
import ru.dezlo.room.security.requests.RequestAuth;
import ru.dezlo.room.security.requests.RequestRegister;
import ru.dezlo.room.security.responses.ResponseAuth;
import ru.dezlo.room.security.servicesImpl.ServiceUser;
import ru.dezlo.room.security.servicesImpl.ServiceUserImpl;
import ru.dezlo.room.utils.ErrorCodes;
import ru.dezlo.room.enterprise.responses.common.Result;

@RestController
@Slf4j
@CrossOrigin
public class ControllerAuth {

    @Autowired
    RepositoryUser repositoryUser;
    @Autowired
    private ServiceUser serviceUser;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseAuth registerUser(@RequestBody RequestRegister requestRegister) {
        log.debug(requestRegister.toString());
        ModelUser modelUser = ModelUser.builder()
                .nickname(requestRegister.getNickname())
                .email(requestRegister.getEmail())
                .password(requestRegister.getPassword())
                .build();
        Result result;
        if (repositoryUser.findByNickname(modelUser.getNickname()) != null)
        result = Result.builder()
                    .code(ErrorCodes.forCode(ErrorCodes.NICKNAME_ALREADY_EXISTS))
                    .message(ErrorCodes.forMessage(ErrorCodes.NICKNAME_ALREADY_EXISTS))
                    .build();
        else if (repositoryUser.findByEmail(modelUser.getEmail()) != null)
            result = Result.builder()
                    .code(ErrorCodes.forCode(ErrorCodes.EMAIL_ALREADY_EXISTS))
                    .message(ErrorCodes.forMessage(ErrorCodes.EMAIL_ALREADY_EXISTS))
                    .build();
        else {
            serviceUser.saveUser(modelUser);
            result = Result.builder()
                    .code(0)
                    .message("No error")
                    .build();
        }
        ResponseAuth responseAuth = new ResponseAuth();
        responseAuth.setResult(result);
        return responseAuth;
    }

    @PostMapping("/auth")
    public ResponseEntity<ResponseAuth> auth(@RequestBody RequestAuth request) {
        log.debug(request.toString());
        ModelUser modelUser;
        Result result;
        String token = null;
        ResponseAuth responseAuth;
        try {
            modelUser = serviceUser.findByLoginAndPassword(request.getLogin(), request.getPassword());
            token = "Bearer " + jwtProvider.generateToken(modelUser.getNickname(), modelUser.getId(), modelUser.getEmail());
            result = Result.builder()
                    .code(ErrorCodes.forCode(ErrorCodes.NO_ERRORS))
                    .message(ErrorCodes.forMessage(ErrorCodes.NO_ERRORS))
                    .build();
        } catch (Exception e) {
            result = Result.builder()
                    .code(ErrorCodes.forCode(ErrorCodes.USER_NOT_FOUND))
                    .message(ErrorCodes.forMessage(ErrorCodes.USER_NOT_FOUND))
                    .build();
        }
        responseAuth = ResponseAuth.builder()
                .result(result)
                .token(token)
                .build();
        log.debug("token: " + token);
        return new ResponseEntity<>(responseAuth ,HttpStatus.OK);
    }
}