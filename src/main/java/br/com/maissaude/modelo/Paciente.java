package br.com.maissaude.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cadastroSus;
	private String cpf;
	@OneToMany
	private List<Consulta> consultas;
	
	public Paciente(){
		
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCadastroSus() {
		return cadastroSus;
	}

	public String getCpf() {
		return cpf;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}
}
