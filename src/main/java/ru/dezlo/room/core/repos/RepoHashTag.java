package ru.dezlo.room.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.core.models.ModelHashTag;

@Repository
public interface RepoHashTag extends JpaRepository<ModelHashTag, Integer> {

    ModelHashTag findByHashTagId(Integer id);
}
