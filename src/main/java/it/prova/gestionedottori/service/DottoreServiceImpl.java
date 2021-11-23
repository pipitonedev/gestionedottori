package it.prova.gestionedottori.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import it.prova.gestionedottori.exceptions.DottoreNotFoundException;
import it.prova.gestionedottori.model.Dottore;
import it.prova.gestionedottori.repository.DottoreRepository;

@Service
public class DottoreServiceImpl implements DottoreService {

	@Autowired
	private DottoreRepository dottoreRepository;

	@Override
	public List<Dottore> listAll() {
		return (List<Dottore>) dottoreRepository.findAll();
	}

	@Override
	public Page<Dottore> searchAndPaginate(Dottore dottoreExample, Integer pageNo, Integer pageSize, String sortBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dottore get(Long idInput) {
		return dottoreRepository.findById(idInput)
				.orElseThrow(() -> new DottoreNotFoundException("Element with id " + idInput + " not found."));
	}

	@Override
	public Dottore save(Dottore input) {
		return dottoreRepository.save(input);
	}

	@Override
	public void delete(Dottore input) {
		dottoreRepository.delete(input);

	}

	@Override
	public Dottore cercaPerCodiceDipendente(String codice) {
		return dottoreRepository.findByCodice(codice);
	}

	@Override
	public Dottore impostaInVisita(String codice) {
		
		Dottore dottore = dottoreRepository.findByCodice(codice);
		dottore.setInVisita(true);
		dottoreRepository.save(dottore);
		return dottore;
	}

}
