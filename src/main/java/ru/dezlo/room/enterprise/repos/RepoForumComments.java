package ru.dezlo.room.enterprise.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.enterprise.models.ModelForumComment;

import java.util.List;

@Repository
public interface RepoForumComments extends JpaRepository<ModelForumComment, Long> {

    List<ModelForumComment> findAllByArticleId(Integer articleId);
}
