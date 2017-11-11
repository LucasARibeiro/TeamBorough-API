package br.com.maissaude.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medico {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String crm;
	private String cidade;
	private String estado;
	
	public Medico() {
		
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCrm() {
		return crm;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}
}
