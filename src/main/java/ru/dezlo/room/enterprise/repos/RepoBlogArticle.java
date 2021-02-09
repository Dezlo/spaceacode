package ru.dezlo.room.enterprise.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.enterprise.models.ModelBlogArticle;

@Repository
public interface RepoBlogArticle extends JpaRepository<ModelBlogArticle, Long> {

    ModelBlogArticle findFirstById(Integer id);

}

