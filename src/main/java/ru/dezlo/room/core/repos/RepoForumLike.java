package ru.dezlo.room.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.core.models.ModelForumLike;
import ru.dezlo.room.core.responses.ResponseLikes;

import java.util.List;

@Repository
public interface RepoForumLike extends JpaRepository<ModelForumLike, Long> {

    ModelForumLike findFirstByUserIdAndArticleId(Integer userId, Integer articleId);

    @Query(value = "select new ru.dezlo.room.core.responses.ResponseLikes(l.articleId, count(l.articleId)) " +
            "from ModelForumLike as l where l.articleId = (:articleId) group by l.articleId")
    List<ResponseLikes> getLikes(@Param("articleId") Integer articleId);

    @Query(value = "select count(*) from public.forum_like la where la.user_id = (:userId) and la.article_id = (:articleId)", nativeQuery = true)
    Integer isLikedForum(@Param("userId") Integer userId,
                         @Param("articleId") Integer articleId);
}
