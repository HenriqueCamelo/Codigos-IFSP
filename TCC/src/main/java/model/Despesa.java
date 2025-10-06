package model;


import java.sql.Date;

public class Despesa {
	
	private int idDespesa;
	private Date dataCompra; 
	private int idFornecedor; 
	private String endereco; 
	private String cidade; 
	private String bairro; 
	private double CNPJCPF; 
	private double valor; 
	private int numeroParcelas;
	
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
	public int getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
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
		return CNPJCPF;
	}
	public void setCNPJCPF(double cNPJCPF) {
		CNPJCPF = cNPJCPF;
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
	
	
}
