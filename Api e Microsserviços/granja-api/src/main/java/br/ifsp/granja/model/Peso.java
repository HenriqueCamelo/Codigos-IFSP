package br.ifsp.granja.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Peso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPeso;
    
    
    //private int idAnimal;
    
    @NotNull(message = "A data da pesagem da franga é necessária")
    private Date dataPesagem;
    
    @NotNull(message = "O peso da galinha é obrigatório")
    private float pesoAnimal;
	
    
    public int getIdPeso() {
		return idPeso;
	}
	public void setIdPeso(int idPeso) {
		this.idPeso = idPeso;
	}
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public Date getDataPesagem() {
		return dataPesagem;
	}
	public void setDataPesagem(Date dataPesagem) {
		this.dataPesagem = dataPesagem;
	}
	public float getPesoAnimal() {
		return pesoAnimal;
	}
	public void setPesoAnimal(float pesoAnimal) {
		this.pesoAnimal = pesoAnimal;
	} 
}
