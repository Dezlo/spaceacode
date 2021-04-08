package ru.dezlo.room.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dezlo.room.core.models.ModelRole;

public interface RepoRole extends JpaRepository<ModelRole, Integer> {


    ModelRole findByName(String name);
}
