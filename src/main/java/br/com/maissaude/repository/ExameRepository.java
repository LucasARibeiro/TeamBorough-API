package br.com.maissaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maissaude.modelo.Exame;

public interface ExameRepository extends JpaRepository<Exame, Long> {

}
