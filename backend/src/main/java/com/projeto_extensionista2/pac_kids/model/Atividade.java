package com.projeto_extensionista2.pac_kids.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    private int scoreboard = 0;

}
