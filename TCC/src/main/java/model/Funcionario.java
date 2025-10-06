package model;

import java.sql.Date;

public class Funcionario {
	private int idFuncionario;
	private String nomefun;
	private String sexo;
	private Date dataNascimento; 
	private Float CPF;
	private Float banco;
	private Float telefone;
	private String fazenda;
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNomefun() {
		return nomefun;
	}
	public void setNomefun(String nomefun) {
		this.nomefun = nomefun;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Float getCPF() {
		return CPF;
	}
	public void setCPF(Float cPF) {
		CPF = cPF;
	}
	public Float getBanco() {
		return banco;
	}
	public void setBanco(Float banco) {
		this.banco = banco;
	}
	public Float getTelefone() {
		return telefone;
	}
	public void setTelefone(Float telefone) {
		this.telefone = telefone;
	}
	public String getFazenda() {
		return fazenda;
	}
	public void setFazenda(String fazenda) {
		this.fazenda = fazenda;
	}
		
}
