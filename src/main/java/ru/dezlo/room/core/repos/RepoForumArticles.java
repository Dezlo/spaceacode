package ru.dezlo.room.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.core.models.ModelForumArticle;

import java.util.List;

@Repository
public interface RepoForumArticles extends JpaRepository<ModelForumArticle, Long> {

    ModelForumArticle findFirstById(Integer id);

    List<ModelForumArticle> findAllByHashTagId(Integer hashTagId);

}
