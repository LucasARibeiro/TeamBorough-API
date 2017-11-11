package br.com.maissaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maissaude.modelo.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
