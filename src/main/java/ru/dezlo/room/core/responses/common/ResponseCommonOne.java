package ru.dezlo.room.core.responses.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseCommonOne<T> {

    private Result result;

    private T payload;

}
