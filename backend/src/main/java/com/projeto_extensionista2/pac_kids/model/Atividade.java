package com.projeto_extensionista2.pac_kids.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private int pontuacao;

    @ManyToOne
    @JoinColumn(name = "scoreboard_id")
    private Scoreboard scoreboard;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
}
