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
import br.com.maissaude.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Medico>> obterTodas() {
		return ResponseEntity.ok().body(  repo.findAll() );
	}
	
	@PutMapping
	public ResponseEntity<Long> alterar(@RequestBody Medico novo) {
		repo.save(novo);
		return ResponseEntity.ok().body( novo.getId() );
	}
	
	@PostMapping
	public ResponseEntity<Long> incluir(@RequestBody Medico novo) {
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
	public ResponseEntity<Medico> recuperarPeloId(@PathVariable Long id) {
		Medico medico= repo.findOne(id);
		if (medico == null ) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(medico);
	}
}