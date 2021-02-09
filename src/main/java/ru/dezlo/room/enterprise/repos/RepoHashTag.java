package ru.dezlo.room.enterprise.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.enterprise.models.ModelHashTag;

@Repository
public interface RepoHashTag extends JpaRepository<ModelHashTag, Integer> {

    ModelHashTag findByHashTagId(Integer id);
}
