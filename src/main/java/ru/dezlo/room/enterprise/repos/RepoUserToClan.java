package ru.dezlo.room.enterprise.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.enterprise.models.ModelUserToClan;

@Repository
public interface RepoUserToClan extends JpaRepository<ModelUserToClan, Long> {

}
