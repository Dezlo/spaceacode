package ru.dezlo.room.core.responses;

import lombok.Data;

@Data
public class ResponseLikes {

    private Integer articleId;

    private Long likes;

    private Integer isLiked;

    public ResponseLikes(Integer articleId, Long count) {
        this.articleId = articleId;
        this.likes = count;
    }
}
