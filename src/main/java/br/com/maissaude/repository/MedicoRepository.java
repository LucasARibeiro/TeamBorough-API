package br.com.maissaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maissaude.modelo.Medico;


public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
