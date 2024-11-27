package com.projeto_extensionista2.pac_kids.dtos;
import lombok.Data;

import java.util.List;

@Data
public class AtividadeComPerguntasDTO {
    private String nome;
    private String descricao;
    private List<PerguntaDTO> perguntas;
}

