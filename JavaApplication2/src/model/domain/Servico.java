package model.domain;



import java.io.Serializable;

public class Servico implements Serializable {
	
	private String nome;
	private int id;
	
	
	public Servico() {
		
	}


	public Servico(String nome, int id) {
		super();
		this.nome = nome;
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	

}

