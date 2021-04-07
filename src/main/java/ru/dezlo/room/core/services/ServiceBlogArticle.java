package ru.dezlo.room.core.services;

import ru.dezlo.room.core.models.ModelBlogArticle;
import ru.dezlo.room.core.requests.RequestBlogOrForumArticle;
import ru.dezlo.room.core.responses.ResponseLikes;

import java.util.List;

public interface ServiceBlogArticle {

    List<ModelBlogArticle> getBlogList();

    void addBlogArticle(RequestBlogOrForumArticle requestBlogOrForumArticle) throws Exception;

    void switchLike(Integer userId, Integer articleId);

    List<ResponseLikes> getLikes(Integer articleId, Integer userId);

    ModelBlogArticle getArticle(Integer articleId);
}
