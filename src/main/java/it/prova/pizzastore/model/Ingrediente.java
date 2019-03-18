package it.prova.pizzastore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingrediente  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;
	private Integer prezzo;
	private String codice;

	public Ingrediente() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	
}
