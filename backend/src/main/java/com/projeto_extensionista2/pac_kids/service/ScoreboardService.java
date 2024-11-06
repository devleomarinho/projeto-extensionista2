package com.projeto_extensionista2.pac_kids.service;

import com.projeto_extensionista2.pac_kids.model.Atividade;
import com.projeto_extensionista2.pac_kids.model.Scoreboard;
import com.projeto_extensionista2.pac_kids.repository.AtividadeRepository;
import com.projeto_extensionista2.pac_kids.repository.ScoreboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Date;

@Service
public class ScoreboardService {

    @Autowired
    private ScoreboardRepository scoreboardRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    public Scoreboard findByAlunoId(Long alunoId) {
        return scoreboardRepository.findByAlunoId(alunoId);
    }

    @Transactional
    public Scoreboard addAtividade(Long alunoId, Atividade atividade) {
        Scoreboard scoreboard = findByAlunoId(alunoId);
        if (scoreboard == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Scoreboard not found for alunoId " + alunoId);
        }
        scoreboard.adicionarPontuacao(atividade.getPontuacao());
        atividade.setScoreboard(scoreboard);
        atividadeRepository.save(atividade);
        return scoreboardRepository.save(scoreboard);
    }

    public List<Atividade> findAtividadesByAlunoId(Long alunoId) {
        Scoreboard scoreboard = findByAlunoId(alunoId);
        return scoreboard != null ? scoreboard.getAtividades() : null;
    }

    @Transactional
    public Scoreboard updateScoreboard(Long alunoId, Scoreboard updatedScoreboard) {
        Scoreboard scoreboard = findByAlunoId(alunoId);
        if (scoreboard == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Scoreboard not found for alunoId " + alunoId);
        }
        scoreboard.setPontuacao(updatedScoreboard.getPontuacao());
        scoreboard.setUltimaAtualizacao(new Date());
        return scoreboardRepository.save(scoreboard);
    }
}
