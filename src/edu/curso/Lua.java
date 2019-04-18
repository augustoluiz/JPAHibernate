package edu.curso;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lua implements Serializable{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private long id;
	private String nome;
	
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
	@Override
	public String toString() {
		return "Nome da Lua = " + nome;
	}
	
	
}
