package br.ifsp.granja.dto.vacina;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacinaRequestDTO {
    @NotNull(message = "A data da vacinação é necessária")
    private Date dataVacina;
	
    @NotBlank(message = "É preciso um nome para a vacina")
    private String nomeVacina;
}
