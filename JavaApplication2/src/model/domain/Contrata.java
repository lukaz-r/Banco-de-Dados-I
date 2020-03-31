
package model.domain;

import java.io.Serializable;


public class Contrata implements Serializable {

	private String matricula;
	private String nomePacote;
	private String dataFim;
	
	public Contrata(String matricula, String nomePacote, String dataInicio, String dataFim) {
		super();
		this.matricula = matricula;
		this.nomePacote = nomePacote;
		this.dataFim = dataFim;
	}
	public Contrata(){
            
        }
	
	public String getNomePacote() {
		return nomePacote;
	}
	public void setNomePacote(String nome) {
		this.nomePacote = nome;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	
	
	
	
	
}


