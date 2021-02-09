package ru.dezlo.room.enterprise.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dezlo.room.enterprise.models.ModelBlogArticle;
import ru.dezlo.room.enterprise.models.ModelBlogLike;
import ru.dezlo.room.enterprise.repos.RepoBlogArticle;
import ru.dezlo.room.enterprise.repos.RepoBlogLike;
import ru.dezlo.room.enterprise.repos.RepoHashTag;
import ru.dezlo.room.enterprise.requests.RequestBlogOrForumArticle;
import ru.dezlo.room.enterprise.responses.common.ResponseLikes;
import ru.dezlo.room.enterprise.services.ServiceBlogArticle;

import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class ServiceBlogArticleImpl implements ServiceBlogArticle {

    @Autowired
    RepoBlogArticle repoBlogArticle;

    @Autowired
    RepoHashTag repoHashTag;

    @Autowired
    RepoBlogLike repoBlogLike;

    public List<ModelBlogArticle> getBlogList() {
        return repoBlogArticle.findAll();
    }

    public void addBlogArticle(RequestBlogOrForumArticle requestBlogOrForumArticle) throws Exception {

        ModelBlogArticle modelBlogArticle = ModelBlogArticle.builder()
                .authorId(requestBlogOrForumArticle.getAuthorId())
                .title(requestBlogOrForumArticle.getTitle())
                .article(requestBlogOrForumArticle.getArticle())
                .dateCreated(new Date())
                .hashTagId(requestBlogOrForumArticle.getHashTagId())
                .build();

        if (repoHashTag.findByHashTagId(requestBlogOrForumArticle.getHashTagId()) == null)
            throw new Exception("HashTag not found");

        repoBlogArticle.save(modelBlogArticle);
    }

    public void switchLike(Integer userId, Integer articleId) {
        ModelBlogLike modelBlogLike = ModelBlogLike.builder()
                .userId(userId)
                .articleId(articleId)
                .build();
        if (repoBlogLike.findFirstByUserIdAndArticleId(userId, articleId) != null)
            repoBlogLike.delete(modelBlogLike);
        else
            repoBlogLike.save(modelBlogLike);
    }

    public List<ResponseLikes> getLikes(Integer articleId, Integer userId) {
        List<ResponseLikes> likes = repoBlogLike.getLikes(articleId);
        for (ResponseLikes elem : likes) {
            elem.setIsLiked(repoBlogLike.isLikedBlog(userId, elem.getArticleId()));
        }
        return likes;
    }

    public ModelBlogArticle getArticle(Integer articleId) {
        ModelBlogArticle modelBlogArticle = repoBlogArticle.findFirstById(articleId);
        modelBlogArticle.setViews(modelBlogArticle.getViews() + 1);
        repoBlogArticle.save(modelBlogArticle);
        return modelBlogArticle;
    }
}
