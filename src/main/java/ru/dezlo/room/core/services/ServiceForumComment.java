package ru.dezlo.room.core.services;

import ru.dezlo.room.core.models.ModelForumComment;
import ru.dezlo.room.core.requests.RequestForumComment;
import ru.dezlo.room.core.responses.ResponseLikes;

import java.util.List;

public interface ServiceForumComment {

    void addForumComment(RequestForumComment requestForumComment) throws Exception;

    void switchLike(Integer userId, Integer commentId);

    List<ModelForumComment> getComments(Integer userId, Integer articleId);

    List<ResponseLikes> getCommentLikes(Integer commentId, Integer userId);
}
