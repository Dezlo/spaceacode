package ru.dezlo.room.security.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestChangePassword {

    private String login;

    private String oldPassword;

    private String newPassword;
}
