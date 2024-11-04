package com.projeto_extensionista2.pac_kids.service;

import com.projeto_extensionista2.pac_kids.model.Atividade;
import com.projeto_extensionista2.pac_kids.model.Scoreboard;
import com.projeto_extensionista2.pac_kids.repository.AtividadeRepository;
import com.projeto_extensionista2.pac_kids.repository.ScoreboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScoreboardService {

    @Autowired
    private ScoreboardRepository scoreboardRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    public Scoreboard findByAlunoId(Long alunoId) {
        return scoreboardRepository.findByAlunoId(alunoId);
    }

    public Scoreboard addAtividade(Long alunoId, Atividade atividade) {
        Scoreboard scoreboard = findByAlunoId(alunoId);
        if (scoreboard != null) {
            scoreboard.setPontuacaoTotal(scoreboard.getPontuacaoTotal() + atividade.getPontuacao());
            scoreboard.getAtividades().add(atividade);
            atividade.setScoreboard(scoreboard);
            atividadeRepository.save(atividade);
            return scoreboardRepository.save(scoreboard);
        }
        return null;
    }

    public List<Atividade> findAtividadesByAlunoId(Long alunoId) {
        Scoreboard scoreboard = findByAlunoId(alunoId);
        return scoreboard != null ? scoreboard.getAtividades() : null;
    }

    public Scoreboard updateScoreboard(Long alunoId, Scoreboard updatedScoreboard) {
        Scoreboard scoreboard = findByAlunoId(alunoId);
        if (scoreboard != null) {
            scoreboard.setPontuacaoTotal(updatedScoreboard.getPontuacaoTotal());
            scoreboard.setUltimaAtualizacao(updatedScoreboard.getUltimaAtualizacao());
            return scoreboardRepository.save(scoreboard);
        }
        return null;
    }
}
