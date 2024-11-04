package com.projeto_extensionista2.pac_kids.repository;

import com.projeto_extensionista2.pac_kids.model.Scoreboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreboardRepository extends JpaRepository<Scoreboard, Long> {
    Scoreboard findByAlunoId(Long alunoId);
}
