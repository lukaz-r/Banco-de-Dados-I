package model.domain;


import java.io.Serializable;

public class Funcionario implements Serializable  {

	private String nome;
	private String sobrenome;
	private String cref;
	private String cpf;
	

	public Funcionario(String nome, String sobrenome, String cref, String cpf) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cref = cref;
		this.cpf = cpf;
	}
        public Funcionario(){
            
        }


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getCref() {
		return cref;
	}


	public void setCref(String cref) {
		this.cref = cref;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public void mostra(){
            System.out.println("Nome: " +getNome());
            System.out.println("Sobrenome: " +getSobrenome());
            System.out.println("CPF: "+getCpf());
            System.out.println("CREF: "+getCref());
        }
}
