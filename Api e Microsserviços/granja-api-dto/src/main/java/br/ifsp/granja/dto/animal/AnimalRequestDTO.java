package br.ifsp.granja.dto.animal;

import java.sql.Date;
import java.util.List;

import br.ifsp.granja.dto.peso.PesoRequestDTO;
import br.ifsp.granja.dto.vacina.VacinaRequestDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalRequestDTO {
    @NotBlank(message = "O Animal necessita de um nome")
    private String nomeAnimal;

	@NotBlank(message = "Digite o sexo do frango/franga")
    private String sexoAnimal; 
	
    @NotNull(message = "Digite a data de nacimento da franga")
    private Date dataNascimentoAnimal; 
	
    @NotBlank(message = "Digite a fazenda na qual o animal esta")
    private String fazenda;

	@NotBlank(message = "A franga deve estar cadastrada em uma granja")
    private String granja;

    @NotBlank(message = "Digite o pai da galinha")
    private String paiAnimal; 
	
    @NotBlank(message = "Digite o mãe da galinha")
    private String maeAnimal;
	
    @NotBlank(message = "Digite o vendedor do animal")
    private String vendedor;
	
    @NotNull(message = "O preco não pode estar vazio")
    private double precoAnimal;
	
    @NotNull(message = "A galinha deve ter uma data de nascimento")
    private Date dataCompra;
	
    @NotBlank(message = "Digite observações sobre o animal")
    private String dadosExtra;
	
	private List<VacinaRequestDTO> vacinas;

	private List<PesoRequestDTO> pesos;
}
