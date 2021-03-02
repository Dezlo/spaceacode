package ru.dezlo.room.enterprise.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dezlo.room.enterprise.models.ModelChallenge;

@Repository
public interface RepoChallenge extends JpaRepository<ModelChallenge, Long> {

}
