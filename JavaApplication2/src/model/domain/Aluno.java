
package model.domain;

import java.io.Serializable;

public class Aluno implements Serializable {

	private String nome;
	private String sobrenome;
	private String matricula;
	private String telefone;
	
	public Aluno(String nome, String sobrenome, String matricula, String telefone) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.matricula = matricula;
		this.telefone = telefone;
	}
	public Aluno(){
            
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
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void mostra(){
            System.out.println("Nome: " +getNome());
            System.out.println("Sobrenome: " +getSobrenome());
            System.out.println("Telefone: "+getTelefone());
            System.out.println("Matricula: "+getMatricula());
        }
	
	
}