package ru.dezlo.room.enterprise.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dezlo.room.enterprise.models.ModelForumPreview;

public interface RepoForumPreview extends JpaRepository<ModelForumPreview, Integer> {
}
