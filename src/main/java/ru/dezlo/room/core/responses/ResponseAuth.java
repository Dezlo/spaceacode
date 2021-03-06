package ru.dezlo.room.core.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dezlo.room.core.responses.common.Result;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseAuth {

    private Result result;
    private String token;
}