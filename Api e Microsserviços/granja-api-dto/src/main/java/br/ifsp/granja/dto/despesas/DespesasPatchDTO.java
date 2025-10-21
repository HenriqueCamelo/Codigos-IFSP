package br.ifsp.granja.dto.despesas;

import java.sql.Date;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DespesasPatchDTO {
    private Optional<Integer> idDespesa = Optional.empty();
    private Optional<Date> dataComp = Optional.empty(); 
    private Optional<String> endere = Optional.empty(); 
    private Optional<String> cidade = Optional.empty(); 
    private Optional<String> bairro = Optional.empty(); 
    private Optional<String> CPF = Optional.empty(); 
    private Optional<Double> valor= Optional.empty();   
    private Optional<Integer> numeroPar = Optional.empty();
    private Optional<String> fazend = Optional.empty();
}
