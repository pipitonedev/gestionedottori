package it.prova.gestionedottori.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestionedottori.dto.DottoreDTO;
import it.prova.gestionedottori.model.Dottore;
import it.prova.gestionedottori.service.DottoreService;

@RestController
@RequestMapping(value = "/dottore", produces = { MediaType.APPLICATION_JSON_VALUE })
public class DottoreRestController {

	@Autowired
	private DottoreService dottoreService;

	@GetMapping("/{idInput}")
	public Dottore getDottore(@PathVariable(required = true) Long idInput) {
		return dottoreService.get(idInput);
	}

	@GetMapping
	public List<Dottore> getAll() {
		return dottoreService.listAll();
	}

	@PostMapping
	public Dottore createNewDottore(@RequestBody Dottore dottoreInput) {
		return dottoreService.save(dottoreInput);
	}

	@PutMapping("/{id}")
	public Dottore updateDottore(@RequestBody Dottore dottoreInput, @PathVariable Long id) {
		Dottore dottoreToUpdate = dottoreService.get(id);
		dottoreToUpdate.setNome(dottoreInput.getNome());
		dottoreToUpdate.setCognome(dottoreInput.getCognome());
		dottoreToUpdate.setCodiceDipendente(dottoreInput.getCodiceDipendente());
		dottoreToUpdate.setInServizio(dottoreInput.isInServizio());
		dottoreToUpdate.setInVisita(dottoreInput.isInVisita());
		return dottoreService.save(dottoreToUpdate);
	}

	@DeleteMapping("/{id}")
	public void deleteDottore(@PathVariable(required = true) Long id) {
		dottoreService.delete(dottoreService.get(id));
	}
	
	@GetMapping("/verifica/{codiceDipendente}")
	public DottoreDTO verificaDipendente(@PathVariable(required = true) String codiceDipendente) {
		return DottoreDTO.buildDottoreDTOFromModel(dottoreService.cercaPerCodiceDipendente(codiceDipendente));
	}
	
	@PostMapping("/impostaInVisita")
	public DottoreDTO imposta(@RequestBody String codiceDipendente) {
		return DottoreDTO.buildDottoreDTOFromModel(dottoreService.impostaInVisita(codiceDipendente));
	}

}
