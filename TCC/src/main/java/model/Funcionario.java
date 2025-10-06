package model;

import java.sql.Date;

public class Funcionario {
	private int idFuncionario;
	private String nomefun;
	private String sexo;
	private Date dataNascimento; 
	private int CPF;
	private int banco;
	private int telefone;
	
	
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
	public int getCPF() {
		return CPF;
	}
	public void setCPF(int cPF) {
		CPF = cPF;
	}
	public int getBanco() {
		return banco;
	}
	public void setBanco(int banco) {
		this.banco = banco;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
}
