package ru.dezlo.room.enterprise.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestForumComment {

    private Integer authorId;
    private Integer articleId;
    private String message;
}
