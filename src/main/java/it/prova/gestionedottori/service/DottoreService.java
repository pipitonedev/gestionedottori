package it.prova.gestionedottori.service;

import java.util.List;

import org.springframework.data.domain.Page;

import it.prova.gestionedottori.model.Dottore;

public interface DottoreService {

	List<Dottore> listAll();

	Page<Dottore> searchAndPaginate(Dottore dispositivoExample, Integer pageNo, Integer pageSize,
			String sortBy);

	Dottore get(Long idInput);

	Dottore save(Dottore input);

	void delete(Dottore input);

}
