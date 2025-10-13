package br.ifsp.granja.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class VacinaAnimal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "A data da vacinação é necessária")
    private Date dataVacina;
	
    @NotBlank(message = "É preciso um nome para a vacina")
    private String nomeVacina;

    @ManyToOne
    @JoinColumn(name="animal_id",nullable = false)
	@JsonBackReference
	private Animal animal;

	public VacinaAnimal(){

	}
	
	public VacinaAnimal(Date dataVacina, String nomeVacina){
		this.dataVacina = dataVacina;
		this.nomeVacina = nomeVacina;
	}

	public Long getIdVacinaAnimal() {
		return id;
	}
	public void setIdVacinaAnimal(Long idVacinaAnimal) {
		this.id = idVacinaAnimal;
	}
	public Date getDataVacina() {
		return dataVacina;
	}
	public void setDataVacina(Date dataVacina) {
		this.dataVacina = dataVacina;
	}
	public String getNomeVacina() {
		return nomeVacina;
	}
	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}
    public Animal getAnimal(){
        return animal;
    }
    public void setAnimal(Animal animal){
        this.animal = animal;
    }
}
