package ru.dezlo.room.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.core.models.ModelChallenge;

@Repository
public interface RepoChallenge extends JpaRepository<ModelChallenge, Long> {

}
