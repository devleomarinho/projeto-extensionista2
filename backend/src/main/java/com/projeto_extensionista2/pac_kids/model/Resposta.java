package com.projeto_extensionista2.pac_kids.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String texto;

    @OneToOne
    @JoinColumn(name = "pergunta_id")
    private Pergunta pergunta;


}
