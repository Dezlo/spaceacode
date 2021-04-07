package ru.dezlo.room.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.core.models.ModelForumComment;

import java.util.List;

@Repository
public interface RepoForumComments extends JpaRepository<ModelForumComment, Long> {

    List<ModelForumComment> findAllByArticleId(Integer articleId);
}
