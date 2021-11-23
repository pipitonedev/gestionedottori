package it.prova.gestionedottori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.gestionedottori.model.Dottore;
import it.prova.gestionedottori.repository.DottoreRepository;

@SpringBootApplication
public class GestionedottoriApplication implements CommandLineRunner {

	@Autowired
	private DottoreRepository dottoreRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestionedottoriApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dottoreRepository.save(new Dottore("Mario", "Rossi", "MARROSS78P13H501F", false, true));
		dottoreRepository.save(new Dottore("Peppe", "Bianchi", "PPPBBB58P13H501F", true, false));
		dottoreRepository.save(new Dottore("Antonio", "Marrone", "ANTMAR88P13H501F", false, false));
		dottoreRepository.save(new Dottore("Vincenzo", "Pipitone", "PPTVCN97P13H501F", true, true));
		dottoreRepository.save(new Dottore("Antonio", "Giallo", "GHIUMP13H501F", true, false));

	}

}
