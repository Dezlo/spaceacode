package ru.dezlo.room.courses;

import lombok.Builder;
import lombok.Data;
import ru.dezlo.room.core.responses.common.Result;

@Data
@Builder
public class ResponseCourses {
    private Result result;
    private PayloadCourses payload;
}
