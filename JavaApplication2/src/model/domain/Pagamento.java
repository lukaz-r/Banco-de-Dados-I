
package model.domain;



import java.io.Serializable;

public class Pagamento implements Serializable {
	
	private String data;
	private String forma;
	private float valor;
	private String matricula;
	
	

	public Pagamento() {
		
	}
	
	public Pagamento(String data, String forma, float valor, String matricula) {
		super();
		this.data = data;
		this.forma = forma;
		this.valor = valor;
		this.matricula = matricula;
	}

	public String getData() {
		return data;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	

}

