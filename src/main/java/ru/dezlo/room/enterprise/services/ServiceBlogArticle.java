package ru.dezlo.room.enterprise.services;

import ru.dezlo.room.enterprise.models.ModelBlogArticle;
import ru.dezlo.room.enterprise.requests.RequestBlogOrForumArticle;
import ru.dezlo.room.enterprise.responses.ResponseLikes;

import java.util.List;

public interface ServiceBlogArticle {

    List<ModelBlogArticle> getBlogList();

    void addBlogArticle(RequestBlogOrForumArticle requestBlogOrForumArticle) throws Exception;

    void switchLike(Integer userId, Integer articleId);

    List<ResponseLikes> getLikes(Integer articleId, Integer userId);

    ModelBlogArticle getArticle(Integer articleId);
}
