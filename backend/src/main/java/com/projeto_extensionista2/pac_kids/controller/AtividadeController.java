package com.projeto_extensionista2.pac_kids.controller;

import com.projeto_extensionista2.pac_kids.model.Atividade;
import com.projeto_extensionista2.pac_kids.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public List<Atividade> getAllAtividades() {
        return atividadeService.getAllAtividades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atividade> getAtividadeById(@PathVariable Long id) {
        return atividadeService.getAtividadeById(id)
                .map(atividade -> ResponseEntity.ok().body(atividade))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Atividade createAtividade(@RequestBody Atividade atividade) {
        return atividadeService.createAtividade(atividade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atividade> updateAtividade(@PathVariable Long id, @RequestBody Atividade atividadeDetails) {
        return atividadeService.updateAtividade(id, atividadeDetails)
                .map(updatedAtividade -> ResponseEntity.ok().body(updatedAtividade))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtividade(@PathVariable Long id) {
        boolean deleted = atividadeService.deleteAtividade(id);
        return deleted ? ResponseEntity.noContent().<Void>build() : ResponseEntity.notFound().build();
    }
}
