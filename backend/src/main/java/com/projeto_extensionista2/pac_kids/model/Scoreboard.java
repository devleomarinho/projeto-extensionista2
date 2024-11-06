package com.projeto_extensionista2.pac_kids.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Scoreboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pontuacao = 0;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAtualizacao = new Date();

    @OneToOne
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    private Aluno aluno;

    @OneToMany(mappedBy = "scoreboard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atividade> atividades = new ArrayList<>();

    public void adicionarPontuacao(int pontos) {
        this.pontuacao += pontos;
        this.ultimaAtualizacao = new Date();
    }
}
