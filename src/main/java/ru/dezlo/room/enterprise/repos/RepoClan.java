package ru.dezlo.room.enterprise.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.enterprise.models.ModelClan;

@Repository
public interface RepoClan extends JpaRepository<ModelClan, Long> {
}
