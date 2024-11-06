package com.projeto_extensionista2.pac_kids.controller;

import com.projeto_extensionista2.pac_kids.model.Atividade;
import com.projeto_extensionista2.pac_kids.model.Scoreboard;
import com.projeto_extensionista2.pac_kids.service.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/scoreboard")
public class ScoreController {

    @Autowired
    private ScoreboardService scoreboardService;

    @GetMapping("/{alunoId}")
    public ResponseEntity<Scoreboard> getScoreboard(@PathVariable Long alunoId) {
        Scoreboard scoreboard = scoreboardService.findByAlunoId(alunoId);
        return scoreboard != null ? ResponseEntity.ok(scoreboard) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{alunoId}/atividades")
    public ResponseEntity<Scoreboard> addAtividade(@PathVariable Long alunoId, @Valid @RequestBody Atividade atividade) {
        Scoreboard updatedScoreboard = scoreboardService.addAtividade(alunoId, atividade);
        return ResponseEntity.ok(updatedScoreboard);
    }

    @GetMapping("/{alunoId}/atividades")
    public ResponseEntity<List<Atividade>> getAtividades(@PathVariable Long alunoId) {
        List<Atividade> atividades = scoreboardService.findAtividadesByAlunoId(alunoId);
        return atividades != null ? ResponseEntity.ok(atividades) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{alunoId}")
    public ResponseEntity<Scoreboard> updateScoreboard(@PathVariable Long alunoId, @Valid @RequestBody Scoreboard updatedScoreboard) {
        Scoreboard scoreboard = scoreboardService.updateScoreboard(alunoId, updatedScoreboard);
        return ResponseEntity.ok(scoreboard);
    }
}
