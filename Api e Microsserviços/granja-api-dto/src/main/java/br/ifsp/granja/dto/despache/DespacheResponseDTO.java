package br.ifsp.granja.dto.despache;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DespacheResponseDTO {
    private Long animalId;
    private String nomeAnimal;
    private LocalDate dataDespache;
    private String motivo;
}
