package br.ifsp.granja.dto.despesas;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DespesasResponseDTO {
    private int idDespesa;
    private Date dataCompra; 
    private String endereco; 
    private String cidade; 
    private String bairro; 
    private String CPF; 
    private double valor; 
    private int numeroParcelas;
    private String fazenda;
}
