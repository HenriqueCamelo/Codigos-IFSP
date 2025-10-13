package br.ifsp.granja.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Peso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "A data da pesagem da franga é necessária")
    private Date dataPesagem;
    
    @NotNull(message = "O peso da galinha é obrigatório")
    private float pesoAnimal;
	
    @ManyToOne
	@JoinColumn(name="animal_id", nullable = false)
	@JsonBackReference
	private Animal animal;

	public Peso(){

	}

	public Peso(Date dataPesagem, Float pesoAnimal){
		this.dataPesagem = dataPesagem;
		this.pesoAnimal = pesoAnimal;
	}

    public Long getIdPeso() {
		return id;
	}
	public void setIdPeso(Long idPeso) {
		this.id = idPeso;
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
	 public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}
