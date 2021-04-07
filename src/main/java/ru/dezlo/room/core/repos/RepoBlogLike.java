package ru.dezlo.room.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.core.models.ModelBlogLike;
import ru.dezlo.room.core.responses.ResponseLikes;

import java.util.List;

@Repository
public interface RepoBlogLike extends JpaRepository<ModelBlogLike, Long> {

    ModelBlogLike findFirstByUserIdAndArticleId(Integer userId, Integer articleId);

    @Query(value = "select new ru.dezlo.room.core.responses.ResponseLikes(l.articleId, count(l.articleId)) " +
            "from ModelBlogLike as l where l.articleId = (:articleId) group by l.articleId")
    List<ResponseLikes> getLikes(@Param("articleId") Integer articleId);

    @Query(value = "select count(*) from public.blog_like la where la.user_id = (:userId) and la.article_id = (:articleId)", nativeQuery = true)
    Integer isLikedBlog(@Param("userId") Integer userId,
                        @Param("articleId") Integer articleId);
}
