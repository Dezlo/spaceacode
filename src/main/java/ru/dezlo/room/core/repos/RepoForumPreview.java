package ru.dezlo.room.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dezlo.room.core.models.ModelForumPreview;

public interface RepoForumPreview extends JpaRepository<ModelForumPreview, Integer> {
}
