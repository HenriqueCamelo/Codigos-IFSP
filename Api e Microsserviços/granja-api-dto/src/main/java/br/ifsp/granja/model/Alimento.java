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
public class Alimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A data da alimentação da franga é necessária")
    private Date dataRegistroAlimento;
    
    @NotNull(message = "A quantidade de água é obrigatório")
    private float quantidadeAgua;
    
    @NotNull(message = "O quanitdade de ração é obrigatório")
    private float quantidadeRacao;
    
    @ManyToOne
	@JoinColumn(name="animal_id", nullable = false)
	@JsonBackReference
	private Animal animal;

    public Alimento()
    {
        
    }

    public Alimento(Date dataRegistroAlimento, float quantidadeAgua, float quantidadeRacao)
    {
        this.dataRegistroAlimento = dataRegistroAlimento;
        this.quantidadeAgua = quantidadeAgua;
        this.quantidadeRacao = quantidadeRacao;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }


    public void setDataRegistroAlimento(Date dataRegistroAlimento)
    {
        this.dataRegistroAlimento = dataRegistroAlimento;
    }

    public Date getDataRegistroAlimento()
    {
        return dataRegistroAlimento;
    }


    public void setQuantidadeAgua(float quantidadeAgua)
    {
        this.quantidadeAgua = quantidadeAgua;
    }

    public float getQuantidadeAgua()
    {
        return quantidadeAgua;
    }


    public void setQuantidadeRacao(float quantidadeRacao)
    {
        this.quantidadeRacao = quantidadeRacao;
    }

    public float getQuantidadeRacao()
    {
        return quantidadeRacao;
    }

    public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
