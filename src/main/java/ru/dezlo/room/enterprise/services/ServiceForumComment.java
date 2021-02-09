package ru.dezlo.room.enterprise.services;

import ru.dezlo.room.enterprise.models.ModelForumComment;
import ru.dezlo.room.enterprise.requests.RequestForumComment;
import ru.dezlo.room.enterprise.responses.common.ResponseLikes;

import java.util.List;

public interface ServiceForumComment {

    void addForumComment(RequestForumComment requestForumComment) throws Exception;

    void switchLike(Integer userId, Integer commentId);

    List<ModelForumComment> getComments(Integer userId, Integer articleId);

    List<ResponseLikes> getCommentLikes(Integer commentId, Integer userId);
}
