package ru.dezlo.room.courses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LevelCourses {
    private Integer id;
    private String name;
}
