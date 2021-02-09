package ru.dezlo.room.enterprise.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestBlogOrForumArticle {

    private Integer authorId;
    private String title;
    private String article;
    private Integer hashTagId;
}
