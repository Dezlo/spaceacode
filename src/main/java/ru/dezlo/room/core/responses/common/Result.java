package ru.dezlo.room.core.responses.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dezlo.room.utils.ErrorCodes;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    @Builder.Default
    private int code = ErrorCodes.forCode(ErrorCodes.NO_ERRORS);

    @Builder.Default
    private String message = ErrorCodes.forMessage(ErrorCodes.NO_ERRORS);

}
