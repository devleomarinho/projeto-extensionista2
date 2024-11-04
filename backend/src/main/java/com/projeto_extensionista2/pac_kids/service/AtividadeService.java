package com.projeto_extensionista2.pac_kids.service;

import com.projeto_extensionista2.pac_kids.model.Atividade;
import com.projeto_extensionista2.pac_kids.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    // Lista todas as atividades
    public List<Atividade> getAllAtividades() {
        return atividadeRepository.findAll();
    }

    // Busca uma atividade por ID
    public Optional<Atividade> getAtividadeById(Long id) {
        return atividadeRepository.findById(id);
    }

    // Cria uma nova atividade
    public Atividade createAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    // Atualiza uma atividade existente
    public Optional<Atividade> updateAtividade(Long id, Atividade atividadeDetails) {
        return atividadeRepository.findById(id)
                .map(atividade -> {
                    atividade.setTitulo(atividadeDetails.getTitulo());
                    atividade.setDescricao(atividadeDetails.getDescricao());
                    atividade.setPontuacao(atividadeDetails.getPontuacao());
                    atividade.setScoreboard(atividadeDetails.getScoreboard());
                    return atividadeRepository.save(atividade);
                });
    }

    // Exclui uma atividade
    public boolean deleteAtividade(Long id) {
        return atividadeRepository.findById(id)
                .map(atividade -> {
                    atividadeRepository.delete(atividade);
                    return true;
                }).orElse(false);
    }
}
