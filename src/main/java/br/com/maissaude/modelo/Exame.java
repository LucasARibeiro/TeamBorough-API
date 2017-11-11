package br.com.maissaude.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private Calendar dataSolicitacao = Calendar.getInstance();
	private String status;
	private String resultado;
	
	public Exame(){
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public Calendar getDataSolicitacao() {
		return dataSolicitacao;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getResultado() {
		return resultado;
	}
}