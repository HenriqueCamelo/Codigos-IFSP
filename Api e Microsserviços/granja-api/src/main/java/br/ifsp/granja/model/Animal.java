package br.ifsp.granja.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnimal;
	
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
