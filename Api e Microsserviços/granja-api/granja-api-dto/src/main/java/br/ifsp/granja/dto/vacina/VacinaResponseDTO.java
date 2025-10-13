package br.ifsp.granja.dto.vacina;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacinaResponseDTO {
    private Long id;
    private Date dataVacina;
    private String nomeVacina;
}
