package com.projeto_extensionista2.pac_kids.service;

import com.projeto_extensionista2.pac_kids.dtos.AtividadeComPerguntasDTO;
import com.projeto_extensionista2.pac_kids.dtos.PerguntaDTO;
import com.projeto_extensionista2.pac_kids.model.Atividade;
import com.projeto_extensionista2.pac_kids.model.Pergunta;
import com.projeto_extensionista2.pac_kids.model.Resposta;
import com.projeto_extensionista2.pac_kids.repository.AtividadeRepository;
import com.projeto_extensionista2.pac_kids.repository.PerguntaRepository;
import com.projeto_extensionista2.pac_kids.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    public List<Atividade> listarAtividades() {
        return atividadeRepository.findAll();
    }


    public Optional<Atividade> listarAtividadePorId(Long id) {
        return atividadeRepository.findById(id);
    }

    public Optional<Atividade> updateAtividade(Long id, Atividade atividadeDetails) {
        return atividadeRepository.findById(id)
                .map(atividade -> {
                    atividade.setNome(atividadeDetails.getNome());
                    atividade.setDescricao(atividadeDetails.getDescricao());
                    atividade.setScoreboard(atividadeDetails.getScoreboard());
                    return atividadeRepository.save(atividade);
                });
    }


    public boolean deleteAtividade(Long id) {
        return atividadeRepository.findById(id)
                .map(atividade -> {
                    atividadeRepository.delete(atividade);
                    return true;
                }).orElse(false);
    }

    public Atividade criarAtividadeComPerguntas(AtividadeComPerguntasDTO atividadeDTO) {
        Atividade novaAtividade = new Atividade();
        novaAtividade.setNome(atividadeDTO.getNome());
        novaAtividade.setDescricao(atividadeDTO.getDescricao());
        atividadeRepository.save(novaAtividade);

        for (PerguntaDTO perguntaDTO : atividadeDTO.getPerguntas()) {
            Pergunta pergunta = new Pergunta();
            pergunta.setTexto(perguntaDTO.getTexto());
            pergunta.setAtividade(novaAtividade);
            perguntaRepository.save(pergunta);

            Resposta resposta = new Resposta();
            resposta.setTexto(perguntaDTO.getResposta().getTexto());
            resposta.setPergunta(pergunta);
            respostaRepository.save(resposta);
        }

        return novaAtividade;
    }

    public String verificarResposta(Long perguntaId, String respostaUsuario) {
        Pergunta pergunta = perguntaRepository.findById(perguntaId)
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));

        Resposta respostaCorreta = respostaRepository.findByPerguntaId(perguntaId)
                .orElseThrow(() -> new RuntimeException("Resposta não encontrada"));

        if (respostaCorreta.getTexto().equalsIgnoreCase(respostaUsuario)) {
            Atividade atividade = pergunta.getAtividade();
            atividade.setScoreboard(atividade.getScoreboard() + 1);
            atividadeRepository.save(atividade);
            return "Resposta correta! Pontuação: " + atividade.getScoreboard();
        } else {
            return "Resposta incorreta.";
        }
    }





}
