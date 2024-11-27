package com.projeto_extensionista2.pac_kids.controller;

import com.projeto_extensionista2.pac_kids.dtos.AtividadeComPerguntasDTO;
import com.projeto_extensionista2.pac_kids.model.Atividade;
import com.projeto_extensionista2.pac_kids.model.Pergunta;
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
    public List<Atividade> listarAtividades() {
        return atividadeService.listarAtividades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atividade> listarAtividadePorId(@PathVariable Long id) {
        return atividadeService.listarAtividadePorId(id)
                .map(atividade -> ResponseEntity.ok().body(atividade))
                .orElse(ResponseEntity.notFound().build());
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

    @PostMapping("/criar")
    public ResponseEntity<Atividade> criarAtividade(@RequestBody    AtividadeComPerguntasDTO atividadeDTO) {
        Atividade novaAtividade = atividadeService.criarAtividadeComPerguntas(atividadeDTO);
        return ResponseEntity.ok(novaAtividade);
    }

    @PostMapping("/verificar/{perguntaId}")
    public ResponseEntity<String> verificarResposta(@PathVariable Long perguntaId, @RequestParam String respostaUsuario) {
        return ResponseEntity.ok(atividadeService.verificarResposta(perguntaId, respostaUsuario));
    }

}
