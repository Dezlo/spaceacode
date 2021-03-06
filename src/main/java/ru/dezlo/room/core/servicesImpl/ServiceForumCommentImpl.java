package ru.dezlo.room.core.servicesImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dezlo.room.core.models.ModelForumArticle;
import ru.dezlo.room.core.models.ModelForumComment;
import ru.dezlo.room.core.models.ModelForumCommentLike;
import ru.dezlo.room.core.repos.RepoForumArticles;
import ru.dezlo.room.core.repos.RepoForumCommentLike;
import ru.dezlo.room.core.repos.RepoForumComments;
import ru.dezlo.room.core.requests.RequestForumComment;
import ru.dezlo.room.core.responses.ResponseLikes;
import ru.dezlo.room.core.services.ServiceForumComment;

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
