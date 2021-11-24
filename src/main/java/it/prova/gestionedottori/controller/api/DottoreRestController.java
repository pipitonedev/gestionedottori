package it.prova.gestionedottori.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestionedottori.dto.DottoreDTO;
import it.prova.gestionedottori.exceptions.DottoreNotFoundException;
import it.prova.gestionedottori.model.Dottore;
import it.prova.gestionedottori.service.DottoreService;

@RestController
@RequestMapping(value = "api/dottore", produces = { MediaType.APPLICATION_JSON_VALUE })
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
	@ResponseStatus(HttpStatus.CREATED)
	public DottoreDTO createNew(@RequestBody DottoreDTO input) {

		if (input.getId() != null)
			throw new RuntimeException("Non è ammesso fornire un id per la creazione");

		Dottore newEntry = input.buildDottoreModel();

		DottoreDTO result = DottoreDTO.buildDottoreDTOFromModel(dottoreService.save(newEntry));
		return result;
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Dottore updateDottore(@RequestBody Dottore dottoreInput, @PathVariable Long id) {

		Dottore aggiorna = dottoreService.get(id);

		if (aggiorna == null)
			throw new DottoreNotFoundException("Dottore non presente");

		aggiorna.setCodiceDipendente(dottoreInput.getCodiceDipendente());
		aggiorna.setNome(dottoreInput.getNome());
		aggiorna.setCognome(dottoreInput.getCognome());
		return dottoreService.save(aggiorna);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteDottore(@PathVariable(required = true) Long id) {
		dottoreService.delete(dottoreService.get(id));
	}

	@GetMapping("/verifica/{codiceDipendente}")
	public DottoreDTO verificaDipendente(@PathVariable(required = true) String codiceDipendente) {

		Dottore dottore = dottoreService.cercaPerCodiceDipendente(codiceDipendente);

		if (dottore == null || dottore.getId() == null)
			throw new DottoreNotFoundException("Dottore non trovato!");

		return DottoreDTO.buildDottoreDTOFromModel(dottore);

	}

	@PostMapping("/impostaInVisita")
	@ResponseStatus(HttpStatus.OK)
	public DottoreDTO imposta(@RequestBody Dottore dottoreInput) {

		Dottore dottore = dottoreService.impostaInVisita(dottoreInput.getCodiceDipendente());

		if (dottore == null || dottore.getId() == null)
			throw new DottoreNotFoundException("Dottore non trovato!");

		return DottoreDTO.buildDottoreDTOFromModel(dottore);
	}

}
