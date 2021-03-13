package ru.dezlo.room.enterprise.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.enterprise.models.ModelClan;
import ru.dezlo.room.enterprise.responses.ResponseLikes;
import ru.dezlo.room.enterprise.responses.ResponseUserCountToClan;

import java.util.List;

@Repository
public interface RepoClan extends JpaRepository<ModelClan, Long> {
}
