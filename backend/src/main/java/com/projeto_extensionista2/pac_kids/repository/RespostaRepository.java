package com.projeto_extensionista2.pac_kids.repository;

import com.projeto_extensionista2.pac_kids.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

    Optional<Resposta> findByPerguntaId(Long perguntaId);
}
