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

import br.com.maissaude.modelo.Consulta;
import br.com.maissaude.repository.ConsultaRepository;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	ConsultaRepository repo;

	@GetMapping
	public ResponseEntity<List<Consulta>> listarConsultas() {
		return ResponseEntity.ok().body(repo.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Consulta> listarConsulta(@PathVariable Long id) {
		Consulta consulta = repo.findOne(id);
		if (consulta == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(consulta);
	}

	@PostMapping
	public ResponseEntity<Long> novaConsulta(@RequestBody Consulta consulta) {
		repo.save(consulta);
		return ResponseEntity.ok().body(consulta.getId());
	}

	@PutMapping
	public ResponseEntity<Long> alterarConsulta(@RequestBody Consulta consulta) {
		repo.save(consulta);
		return ResponseEntity.ok().body(consulta.getId());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirConsulta(@PathVariable Long id) {
		if (!repo.exists(id)) {
			return ResponseEntity.notFound().build();
		}
		repo.delete(id);
		return ResponseEntity.ok().build();
	}

}
