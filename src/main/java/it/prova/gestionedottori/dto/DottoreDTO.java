package it.prova.gestionedottori.dto;

import it.prova.gestionedottori.model.Dottore;

public class DottoreDTO {

	private Long id;
	private String nome;
	private String cognome;
	private String codiceDipendente;
	private boolean inServizio;
	private boolean inVisita;

	public DottoreDTO() {
	}

	public DottoreDTO(Long id, String nome, String cognome, String codiceDipendente, boolean inServizio,
			boolean inVisita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
		this.inServizio = inServizio;
		this.inVisita = inVisita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceDipendente() {
		return codiceDipendente;
	}

	public void setCodiceDipendente(String codiceDipendente) {
		this.codiceDipendente = codiceDipendente;
	}

	public boolean isInServizio() {
		return inServizio;
	}

	public void setInServizio(boolean inServizio) {
		this.inServizio = inServizio;
	}

	public boolean isInVisita() {
		return inVisita;
	}

	public void setInVisita(boolean inVisita) {
		this.inVisita = inVisita;
	}

	public Dottore buildDottoreModel() {
		return new Dottore(this.id, this.nome, this.cognome, this.codiceDipendente, this.inServizio, this.inVisita);
	}

	public static DottoreDTO buildDottoreDTOFromModel(Dottore input) {
		return new DottoreDTO(input.getId(), input.getNome(), input.getCognome(), input.getCodiceDipendente(),
				input.isInServizio(), input.isInVisita());
	}

}
