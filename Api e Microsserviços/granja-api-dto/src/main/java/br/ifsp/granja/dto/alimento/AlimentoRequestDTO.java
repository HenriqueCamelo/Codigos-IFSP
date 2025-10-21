package br.ifsp.granja.dto.alimento;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlimentoRequestDTO {
    @NotNull(message = "A data da alimentação da franga é necessária")
    private Date dataRegistroAlimento;
    
    @NotNull(message = "A quantidade de água é obrigatório")
    private float quantidadeAgua;
    
    @NotNull(message = "O quanitdade de ração é obrigatório")
    private float quantidadeRacao;
}
