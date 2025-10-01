package br.ifsp.taskmaster.dto.tarefa;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaResponseDTO {
    
    private Long id;
    private String titulo;
    private String descricao;
    private String categoria;
    private LocalDate dataLimite;
}
