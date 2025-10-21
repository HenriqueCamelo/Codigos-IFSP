package br.ifsp.granja.dto.animal;

import java.sql.Date;
import java.util.List;

import br.ifsp.granja.dto.alimento.AlimentoResponseDTO;
import br.ifsp.granja.dto.peso.PesoResponseDTO;
import br.ifsp.granja.dto.vacina.VacinaResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalResponseDTO {
    private Long id;
    private String nomeAnimal;
    private String sexoAnimal;
    private Date dataNascimentoAnimal;
    private String fazenda;
    private String granja;
    private String paiAnimal; 
    private String maeAnimal;
    private String vendedor;
    private double precoAnimal;
    private Date dataCompra;
    private String dadosExtra;
    private List<VacinaResponseDTO> vacinas;
    private List<PesoResponseDTO> pesos;
    private List<AlimentoResponseDTO> alimentos;
}
