package ru.dezlo.room.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.core.models.ModelForumCommentLike;
import ru.dezlo.room.core.responses.ResponseLikes;

import java.util.List;

@Repository
public interface RepoForumCommentLike extends JpaRepository<ModelForumCommentLike, Long> {

    ModelForumCommentLike findFirstByUserIdAndCommentId(Integer userId, Integer commentId);


    @Query(value = "select new ru.dezlo.room.core.responses.ResponseLikes(l.commentId, count(l.commentId)) " +
            "from ModelForumCommentLike as l where l.commentId = (:commentId) group by l.commentId")
    List<ResponseLikes> getLikes(@Param("commentId") Integer commentId);

    @Query(value = "select count(*) from public.forum_comment_like la where la.user_id = (:userId) and la.comment_id = (:commentId)", nativeQuery = true)
    Integer isLikedForum(@Param("userId") Integer userId,
                         @Param("commentId") Integer commentId);
}
