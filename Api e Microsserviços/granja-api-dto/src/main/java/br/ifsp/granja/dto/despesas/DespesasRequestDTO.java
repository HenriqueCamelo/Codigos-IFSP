package br.ifsp.granja.dto.despesas;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DespesasRequestDTO {
	
    @NotNull(message = "É necessário uma data de compra")
    private Date dataCompra; 
	
    @NotBlank(message = "Digite o endereço da loja em que foi adquirido o produto")
    private String endereco; 
	
    @NotBlank(message = "Digite o cidade em que loja se localiza")
    private String cidade; 
	
    @NotBlank(message = "Digite o endereço da loja em que foi adquirido o produto")
    private String bairro; 
	
    @NotBlank
    @Pattern(regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$",
            message = "CPF inválido. Use 000.000.000-00 ou 00000000000")
    private double CPF; 
	
    @NotNull(message = "A despesa deve conter um valor")
    private double valor; 
	
    @NotNull(message = "Digite o numero de parcelas")
    private int numeroParcelas;
	
    @NotBlank(message = "Insira a fazenda da qual esta despesa pertença")
    private String fazenda;
}
