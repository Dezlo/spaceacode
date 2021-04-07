package ru.dezlo.room.core.responses;

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
