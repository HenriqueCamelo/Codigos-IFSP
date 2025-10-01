package br.ifsp.taskmaster.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Tarefa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título não pode estar vazio")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @NotBlank(message = "A tarefa deve ter ao menos uma categoria")
    private String categoria;

    @NotNull(message = "A tarefa deve ter uma data limite")
    private LocalDate dataLimite;

    public Tarefa(){

    }

    public Tarefa(String titulo, String descricao, String categoria, LocalDate dataLimite){
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataLimite = dataLimite;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public LocalDate getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(LocalDate dataLimite) {
		this.dataLimite = dataLimite;
	}


}
