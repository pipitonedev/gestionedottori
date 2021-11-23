package it.prova.gestionedottori.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.prova.gestionedottori.model.Dottore;

public interface DottoreRepository
		extends PagingAndSortingRepository<Dottore, Long>, JpaSpecificationExecutor<Dottore> {

}
