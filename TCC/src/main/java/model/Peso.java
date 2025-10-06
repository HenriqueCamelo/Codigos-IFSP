package model;

import java.sql.Date;

public class Peso {

	private int idPeso;
    private int idAnimal;
    private Date dataPesagem;
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
