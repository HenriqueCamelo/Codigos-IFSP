package br.ifsp.granja.dto.peso;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PesoResponseDTO {
    private Long id;
    private Date dataPesagem;
    private float pesoAnimal;
}
