package ru.dezlo.room.enterprise.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.enterprise.models.ModelForumArticle;

import java.util.List;

@Repository
public interface RepoForumArticles extends JpaRepository<ModelForumArticle, Long> {

    ModelForumArticle findFirstById(Integer id);

    List<ModelForumArticle> findAllByHashTagId(Integer hashTagId);

}
