package ru.dezlo.room.core.responses.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseCommonList<T> {

    private Result result;

    private List<T> payload;
}
