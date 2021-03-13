package ru.dezlo.room.enterprise.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseUserCountToClan {

    private Integer id;

    private String title;

    private Long count;

}
