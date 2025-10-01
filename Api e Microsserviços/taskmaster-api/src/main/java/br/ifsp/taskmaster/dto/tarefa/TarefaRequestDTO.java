package br.ifsp.taskmaster.dto.tarefa;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaRequestDTO {

    @NotBlank(message = "O título não pode estar vazio")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @NotBlank(message = "A tarefa deve ter ao menos uma categoria")
    private String categoria;

    @NotNull(message = "A tarefa deve ter uma data limite")
    private LocalDate dataLimite;
}
