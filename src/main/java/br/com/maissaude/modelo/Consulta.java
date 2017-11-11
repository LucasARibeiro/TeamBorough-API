package br.com.maissaude.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String data;
	@OneToMany
	private Medico medico;
	@ManyToOne
	@JoinColumn(name="exame_id")
	private List<Exame> exames;
	private String descricao;
	
	public Consulta(){
		
	}

	public Long getId() {
		return id;
	}

	public String getData() {
		return data;
	}

	public Medico getMedico() {
		return medico;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public String getDescricao() {
		return descricao;
	}
}