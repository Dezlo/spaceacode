package ru.dezlo.room.core.services;

import ru.dezlo.room.core.models.ModelForumArticle;
import ru.dezlo.room.core.responses.ResponseLikes;

import java.util.List;

public interface ServiceForumArticle {

    List<ModelForumArticle> getForumList(Integer hashTagId) throws Exception;

    ModelForumArticle getArticle(Integer articleId);

    void addForumArticle(ModelForumArticle modelForumArticle) throws Exception;

    void switchLike(Integer userId, Integer articleId);

    List<ResponseLikes> getLikes(Integer articleId, Integer userId);
}
