package model.domain;


import java.io.Serializable;

public class Pacote implements Serializable {
	
	
	private float preco;
	private String nome;
	private String validade;
	
	public Pacote() {
		
	}

	public Pacote(float preco, String nome, String validade) {
		super();
		this.preco = preco;
		this.nome = nome;
		this.validade = validade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}
        
	
	
	
	

}
