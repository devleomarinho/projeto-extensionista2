package com.projeto_extensionista2.pac_kids.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String texto;

    @ManyToOne
    @JoinColumn(name = "atividade_id")
    private Atividade atividade;

    @OneToOne(mappedBy = "pergunta", cascade = CascadeType.ALL)
    private Resposta resposta;

}
