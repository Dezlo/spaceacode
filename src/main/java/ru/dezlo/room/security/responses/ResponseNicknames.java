package ru.dezlo.room.security.responses;

import lombok.Data;

@Data
public class ResponseNicknames {

    private Integer id;

    private String nickname;

    public ResponseNicknames(Integer id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
