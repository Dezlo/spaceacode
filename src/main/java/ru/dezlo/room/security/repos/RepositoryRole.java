package ru.dezlo.room.security.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dezlo.room.security.models.ModelRole;

public interface RepositoryRole extends JpaRepository<ModelRole, Integer> {


    ModelRole findByName(String name);
}
