package com.projeto_extensionista2.pac_kids.service;

import com.projeto_extensionista2.pac_kids.model.Aluno;
import com.projeto_extensionista2.pac_kids.model.Responsavel;
import com.projeto_extensionista2.pac_kids.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsavelService {

    @Autowired
    ResponsavelRepository responsavelRepository;

    public void criarResponsavel(Responsavel responsavel){
        responsavelRepository.save(responsavel);
    }

    public List<Responsavel> listarTodosResponsaveis(){
        return responsavelRepository.findAll();
    }

    public Optional<Responsavel> buscarResponsavelPorId(Long id){
        return responsavelRepository.findById(id);
    }

    public void deletarResponsavelPorId(Long id){
        responsavelRepository.deleteById(id);
    }

    public void atualizarResponsavelPorId(Long id, Responsavel responsavel){
        Optional<Responsavel> optionalResponsavel = responsavelRepository.findById(id);
        if(optionalResponsavel.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Responsável não encontrado no banco de dados");
        }
        Responsavel responsavelExistente = optionalResponsavel.get();
        responsavelExistente.setNome(responsavel.getNome());
        responsavelExistente.setCpf(responsavel.getCpf());
        responsavelExistente.setEmail(responsavel.getEmail());
        responsavelExistente.setTelefone(responsavel.getTelefone());
        responsavelExistente.setDataNascimento(responsavel.getDataNascimento());
        responsavelRepository.save(responsavelExistente);

    }
}
