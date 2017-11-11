package br.com.maissaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maissaude.modelo.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
