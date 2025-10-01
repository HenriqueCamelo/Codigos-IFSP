package br.ifsp.taskmaster.dto.tarefa;

import java.time.LocalDate;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaPatchDTO {
    private Optional<String> titulo = Optional.empty();
    private Optional<String> descricao = Optional.empty();
    private Optional<String> categoria = Optional.empty();
    private Optional<LocalDate> dataLimite = Optional.empty();
}
