package com.projeto_extensionista2.pac_kids.controller;

import com.projeto_extensionista2.pac_kids.model.Responsavel;
import com.projeto_extensionista2.pac_kids.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarResponsavel(@RequestBody Responsavel responsavel) {
        responsavelService.criarResponsavel(responsavel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Responsavel> listarTodosResponsaveis() {
        return responsavelService.listarTodosResponsaveis();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Responsavel> buscarResponsavelPorId(@PathVariable Long id) {
        return responsavelService.buscarResponsavelPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarResponsavelPorId(@PathVariable Long id) {
        responsavelService.deletarResponsavelPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarResponsavelPorId(@PathVariable Long id, @RequestBody Responsavel responsavel) {
        responsavelService.atualizarResponsavelPorId(id, responsavel);
    }
}
