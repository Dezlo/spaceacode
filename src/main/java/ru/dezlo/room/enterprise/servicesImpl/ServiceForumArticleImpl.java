package ru.dezlo.room.enterprise.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dezlo.room.enterprise.models.ModelForumArticle;
import ru.dezlo.room.enterprise.models.ModelForumLike;
import ru.dezlo.room.enterprise.repos.RepoForumArticles;
import ru.dezlo.room.enterprise.repos.RepoForumLike;
import ru.dezlo.room.enterprise.repos.RepoHashTag;
import ru.dezlo.room.enterprise.responses.common.ResponseLikes;
import ru.dezlo.room.enterprise.services.ServiceForumArticle;

import java.util.List;

@Service
@Slf4j
public class ServiceForumArticleImpl implements ServiceForumArticle {

    @Autowired
    RepoForumArticles repoForumArticles;

    @Autowired
    RepoHashTag repoHashTag;

    @Autowired
    RepoForumLike repoForumLike;

    public List<ModelForumArticle> getForumList(Integer hashTagId) throws Exception {
        if (repoHashTag.findByHashTagId(hashTagId) == null)
            throw new Exception("HashTag not found");

        return repoForumArticles.findAllByHashTagId(hashTagId);
    }

    public ModelForumArticle getArticle(Integer articleId){
        ModelForumArticle modelForumArticle = repoForumArticles.findFirstById(articleId);
        modelForumArticle.setViews(modelForumArticle.getViews() + 1);
        repoForumArticles.save(modelForumArticle);
        return modelForumArticle;
    }

    public void addForumArticle(ModelForumArticle modelForumArticle) throws Exception {

        if (repoHashTag.findByHashTagId(modelForumArticle.getHashTagId()) == null)
            throw new Exception("HashTag not found");

        repoForumArticles.save(modelForumArticle);
    }

    public void switchLike(Integer userId, Integer articleId) {
        ModelForumLike modelForumLike = ModelForumLike.builder()
                .userId(userId)
                .articleId(articleId)
//                .hashTagId(repoForumArticles.findFirstById(articleId).getHashTagId())
                .build();
        if (repoForumLike.findFirstByUserIdAndArticleId(userId, articleId) != null)
            repoForumLike.delete(modelForumLike);
        else
            repoForumLike.save(modelForumLike);
    }

    public List<ResponseLikes> getLikes(Integer articleId, Integer userId) {
        List<ResponseLikes> likes = repoForumLike.getLikes(articleId);
        for (ResponseLikes elem : likes) {
            elem.setIsLiked(repoForumLike.isLikedForum(userId, elem.getArticleId()));
        }
        return likes;
    }

}