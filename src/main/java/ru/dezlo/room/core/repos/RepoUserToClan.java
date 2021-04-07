package ru.dezlo.room.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.core.models.ModelUserToClan;

@Repository
public interface RepoUserToClan extends JpaRepository<ModelUserToClan, Long> {

}
