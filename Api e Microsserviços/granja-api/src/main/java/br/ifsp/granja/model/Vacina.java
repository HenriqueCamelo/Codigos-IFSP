package br.ifsp.granja.model;

import java.sql.Date;

import jakarta.persistence.Entity;

@Entity
public class Vacina {
    private int idVacinaAnimal;
	private int idAnimal;
    private Date dataVacina;
	private int idVacina;
	
	public int getIdVacinaAnimal() {
		return idVacinaAnimal;
	}
	public void setIdVacinaAnimal(int idVacinaAnimal) {
		this.idVacinaAnimal = idVacinaAnimal;
	}
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public Date getDataVacina() {
		return dataVacina;
	}
	public void setDataVacina(Date dataVacina) {
		this.dataVacina = dataVacina;
	}
	public int getIdVacina() {
		return idVacina;
	}
	public void setIdVacina(int idVacina) {
		this.idVacina = idVacina;
	}
}
