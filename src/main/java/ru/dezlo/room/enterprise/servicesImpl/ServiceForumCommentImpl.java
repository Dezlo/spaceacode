package ru.dezlo.room.enterprise.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dezlo.room.enterprise.models.ModelForumArticle;
import ru.dezlo.room.enterprise.models.ModelForumComment;
import ru.dezlo.room.enterprise.models.ModelForumCommentLike;
import ru.dezlo.room.enterprise.repos.RepoForumArticles;
import ru.dezlo.room.enterprise.repos.RepoForumCommentLike;
import ru.dezlo.room.enterprise.repos.RepoForumComments;
import ru.dezlo.room.enterprise.requests.RequestForumComment;
import ru.dezlo.room.enterprise.responses.common.ResponseLikes;
import ru.dezlo.room.enterprise.services.ServiceForumComment;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ServiceForumCommentImpl implements ServiceForumComment {

    @Autowired
    RepoForumComments repoForumComments;

    @Autowired
    RepoForumArticles repoForumArticles;

    @Autowired
    RepoForumCommentLike repoForumCommentLike;

    public void addForumComment(RequestForumComment requestForumComment) throws Exception {

        ModelForumArticle modelForumArticle = repoForumArticles.findFirstById(requestForumComment.getArticleId());
        if (modelForumArticle != null) {

            ModelForumComment modelForumComment = ModelForumComment.builder()
                    .authorId(requestForumComment.getAuthorId())
                    .message(requestForumComment.getMessage())
                    .dateCreated(new Date())
                    .articleId(requestForumComment.getArticleId())
                    .build();

            repoForumComments.save(modelForumComment);
        } else throw new Exception("Article id not found");
    }

    public void switchLike(Integer userId, Integer commentId) {
        ModelForumCommentLike modelForumCommentLike = ModelForumCommentLike.builder()
                .userId(userId)
                .commentId(commentId)
                .build();
        if (repoForumCommentLike.findFirstByUserIdAndCommentId(userId, commentId) != null)
            repoForumCommentLike.delete(modelForumCommentLike);
        else
            repoForumCommentLike.save(modelForumCommentLike);
    }

    public List<ModelForumComment> getComments(Integer userId, Integer articleId) {
        List<ModelForumComment> listComments = repoForumComments.findAllByArticleId(articleId);
        return listComments;
    }

    public List<ResponseLikes> getCommentLikes(Integer commentId, Integer userId) {
        List<ResponseLikes> likes = repoForumCommentLike.getLikes(commentId);
        for (ResponseLikes elem : likes) {
            elem.setIsLiked(repoForumCommentLike.isLikedForum(userId, elem.getArticleId()));
        }
        return likes;
    }


}
