package com.projeto_extensionista2.pac_kids.service;

import com.projeto_extensionista2.pac_kids.model.Aluno;
import com.projeto_extensionista2.pac_kids.model.Scoreboard;
import com.projeto_extensionista2.pac_kids.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public void criarAluno(Aluno aluno){
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setAluno(aluno);
        scoreboard.setPontuacao(0);
        aluno.setScoreboard(scoreboard);
        alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodosAlunos(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoPorId(Long id){
        return alunoRepository.findById(id);
    }

    public void deletarAlunoPorId(Long id){
        alunoRepository.deleteById(id);
    }

    public void atualizarAlunoPorId(Long id, Aluno aluno){
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if(optionalAluno.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado no banco de dados");
        }
        Aluno alunoExistente = optionalAluno.get();
        alunoExistente.setNome(aluno.getNome());
        alunoExistente.setEmail(aluno.getEmail());
        alunoExistente.setCpf(aluno.getCpf());
        alunoExistente.setDataNascimento(aluno.getDataNascimento());
        alunoRepository.save(alunoExistente);

    }

    public Optional<Scoreboard> buscarScoreboardDoAluno(Long alunoId) {
        return alunoRepository.findById(alunoId)
                .map(Aluno::getScoreboard);
    }

    public void atualizarPontuacao(Long alunoId, int pontuacao) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(alunoId);
        if (alunoOpt.isPresent()) {
            Scoreboard scoreboard = alunoOpt.get().getScoreboard();
            scoreboard.setPontuacao(scoreboard.getPontuacao() + pontuacao);
            alunoRepository.save(alunoOpt.get());
        }
    }




}
