package ru.dezlo.room.courses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    private List<LevelCourses> basic;
    private List<LevelCourses> middle;
    private List<LevelCourses> expert;
}
