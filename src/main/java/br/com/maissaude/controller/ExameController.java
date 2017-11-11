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


import br.com.maissaude.modelo.Exame;
import br.com.maissaude.repository.ExameRepository;

@RestController
@RequestMapping("/exames")
public class ExameController {
	
	@Autowired
	private ExameRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Exame>> listarExames(){
		return ResponseEntity.ok().body(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Exame> listarExame(@PathVariable Long id) {
		Exame exame = repo.findOne(id);
		if (exame == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(exame);
	}

	@PostMapping
	public ResponseEntity<Long> novoExame(@RequestBody Exame exame) {
		repo.save(exame);
		return ResponseEntity.ok().body(exame.getId());
	}

	@PutMapping
	public ResponseEntity<Long> alterarExame(@RequestBody Exame exame) {
		repo.save(exame);
		return ResponseEntity.ok().body(exame.getId());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirExame(@PathVariable Long id) {
		if (!repo.exists(id)) {
			return ResponseEntity.notFound().build();
		}
		repo.delete(id);
		return ResponseEntity.ok().build();
	}

}