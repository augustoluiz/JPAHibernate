package edu.curso;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//sempre importar do javax.persistence
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Planeta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nome;
	private float distanciaSol;
	private double tamanho;
	private int qtdLuas;
	private Date descoberto;
	
	//criando relações com as entidades
	private List<Lua> luas;
	
	@OneToMany(targetEntity = Lua.class)
	public List<Lua> getLuas() {
		return luas;
	}
	public void setLuas(List<Lua> luas) {
		this.luas = luas;
	}
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getDistanciaSol() {
		return distanciaSol;
	}
	public void setDistanciaSol(float distanciaSol) {
		this.distanciaSol = distanciaSol;
	}
	public double getTamanho() {
		return tamanho;
	}
	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
	public int getQtdLuas() {
		return qtdLuas;
	}
	public void setQtdLuas(int qtdLuas) {
		this.qtdLuas = qtdLuas;
	}
	public Date getDescoberto() {
		return descoberto;
	}
	public void setDescoberto(Date descoberto) {
		this.descoberto = descoberto;
	}
	
	@Override
	public String toString() {
		return "Distância do Sol = " + distanciaSol +
				"\nTamanho = " + tamanho + 
				"\nLuas = " + luas ;
	}
	
	
}
