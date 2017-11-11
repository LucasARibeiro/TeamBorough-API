package br.com.maissaude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maissaude.modelo.Medico;
import br.com.maissaude.modelo.Paciente;
import br.com.maissaude.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Paciente>> obterTodos() {
		return ResponseEntity.ok().body(  repo.findAll() );
	}
	
	@PutMapping
	public ResponseEntity<Long> alterar(@RequestBody Paciente novo) {
		repo.save(novo);
		return ResponseEntity.ok().body( novo.getId() );
	}
	
	@PostMapping
	public ResponseEntity<Long> incluir(@RequestBody Paciente novo) {
		repo.save(novo);
		return ResponseEntity.ok().body( novo.getId() );
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!repo.exists(id)) {
			return ResponseEntity.notFound().build();
		}
		repo.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> recuperarPeloId(@PathVariable Long id) {
		Paciente paciente= repo.findOne(id);
		if (paciente == null ) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(paciente);
	}

}
