package br.ifsp.granja.dto.peso;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PesoRequestDTO {
    @NotNull(message = "A data da pesagem da franga é necessária")
    private Date dataPesagem;
    
    @NotNull(message = "O peso da galinha é obrigatório")
    private float pesoAnimal;
}
