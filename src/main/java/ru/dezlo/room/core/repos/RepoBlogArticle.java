package ru.dezlo.room.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.core.models.ModelBlogArticle;

@Repository
public interface RepoBlogArticle extends JpaRepository<ModelBlogArticle, Long> {

    ModelBlogArticle findFirstById(Integer id);

}

