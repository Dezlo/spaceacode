package ru.dezlo.room.enterprise.services;

import ru.dezlo.room.enterprise.models.ModelForumArticle;
import ru.dezlo.room.enterprise.responses.ResponseLikes;

import java.util.List;

public interface ServiceForumArticle {

    List<ModelForumArticle> getForumList(Integer hashTagId) throws Exception;

    ModelForumArticle getArticle(Integer articleId);

    void addForumArticle(ModelForumArticle modelForumArticle) throws Exception;

    void switchLike(Integer userId, Integer articleId);

    List<ResponseLikes> getLikes(Integer articleId, Integer userId);
}
