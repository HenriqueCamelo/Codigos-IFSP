package br.ifsp.granja.dto.animal;

import java.sql.Date;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalPatchDTO {
    private Optional<String> nomeAnimal = Optional.empty();
    private Optional<String> sexoAnimal = Optional.empty();
    private Optional<Date> dataNascimentoAnimal = Optional.empty();
    private Optional<String> fazenda = Optional.empty();
    private Optional<String> granja = Optional.empty();
    private Optional<String> paiAnimal = Optional.empty(); 
    private Optional<String> maeAnimal = Optional.empty();
    private Optional<String> vendedor = Optional.empty();
    private Optional<Double> precoAnimal = Optional.empty();
    private Optional<Date> dataCompra = Optional.empty();
    private Optional<String> dadosExtra = Optional.empty();

}
