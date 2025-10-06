package model;

import java.sql.Date;

public class Animal {
	private int idAnimal;
	private String nomeAnimal;
	private String sexoAnimal; 
	private Date dataNascimentoAnimal; 
	private String foto;
	private String fazenda;
	private String paiAnimal; 
	private String maeAnimal;
	private String vendedor;
	private double precoAnimal;
	private Date dataCompra;
	private String dadosExtra;
	private String granja;
	
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public String getNomeAnimal() {
		return nomeAnimal;
	}
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
	public String getSexoAnimal() {
		return sexoAnimal;
	}
	public void setSexoAnimal(String sexoAnimal) {
		this.sexoAnimal = sexoAnimal;
	}
	public Date getDataNascimentoAnimal() {
		return dataNascimentoAnimal;
	}
	public void setDataNascimentoAnimal(Date dataNascimentoAnimal) {
		this.dataNascimentoAnimal = dataNascimentoAnimal;
	}
	public String getFazenda() {
		return fazenda;
	}
	public void setFazenda(String fazenda) {
		this.fazenda = fazenda;
	}
	public String getGranja() {
		return granja;
	}
	public void setGranja(String granja) {
		this.granja = granja;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getPaiAnimal() {
		return paiAnimal;
	}
	public void setPaiAnimal(String paiAnimal) {
		this.paiAnimal = paiAnimal;
	}
	public String getMaeAnimal() {
		return maeAnimal;
	}
	public void setMaeAnimal(String maeAnimal) {
		this.maeAnimal = maeAnimal;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public double getPrecoAnimal() {
		return precoAnimal;
	}
	public void setPrecoAnimal(double precoAnimal) {
		this.precoAnimal = precoAnimal;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public String getDadosExtra() {
		return dadosExtra;
	}
	public void setDadosExtra(String dadosExtra) {
		this.dadosExtra = dadosExtra;
	}
}
