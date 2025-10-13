package br.ifsp.granja.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Despesas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDespesa;
	
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
	
	public Despesas(){

	}
	
	public Despesas(Date dataCompra, String endereco, String cidade, String bairro, double cPF, double valor,
			int numeroParcelas, String fazenda) {
		
		this.dataCompra = dataCompra;
		this.endereco = endereco;
		this.cidade = cidade;
		this.bairro = bairro;
		this.CPF = cPF;
		this.valor = valor;
		this.numeroParcelas = numeroParcelas;
		this.fazenda = fazenda;
	}

	public int getIdDespesa() {
		return idDespesa;
	}
	public void setIdDespesa(int idDespesa) {
		this.idDespesa = idDespesa;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public double getCNPJCPF() {
		return CPF;
	}
	public void setCNPJCPF(double CPF) {
		this.CPF = CPF;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getNumeroParcelas() {
		return numeroParcelas;
	}
	public void setNumeroParcelas(int numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
	public String getFazenda() {
		return fazenda;
	}
	public void setFazenda(String fazenda) {
		this.fazenda = fazenda;
	}
}
