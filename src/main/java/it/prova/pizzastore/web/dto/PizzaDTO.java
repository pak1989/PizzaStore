package it.prova.pizzastore.web.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import it.prova.pizzastore.model.Ingrediente;

public class PizzaDTO {
	private Long id;
	private String descrizione;
	private String codice;
	private Integer prezzoBase;
	private Boolean attivo;

	private Set<Ingrediente> ingredienti = new HashSet<>(0);

	public PizzaDTO() {
	}
	
	public PizzaDTO(String descrizione, String codice) {
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public PizzaDTO(Long id, String descrizione, String codice) {
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public PizzaDTO(String descrizione, String codice,Boolean attivo) {
		this.descrizione = descrizione;
		this.codice = codice;
		this.attivo = attivo;
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

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Integer getPrezzoBase() {
		return prezzoBase;
	}

	public void setPrezzoBase(Integer prezzoBase) {
		this.prezzoBase = prezzoBase;
	}

	public Boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	public Set<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(Set<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}
	
	
	
	@Override
	public String toString() {
		String ingredientiRis = "";
		for (Ingrediente ingrediente : ingredienti) {
			ingredientiRis += ingrediente.getDescrizione() + " ";
		}
		return "PizzaDTO [id=" + id + ", descrizione=" + descrizione + ", codice=" + codice + ", prezzoBase="
				+ prezzoBase + ", attivo=" + attivo + ", ingredienti=" + ingredientiRis + "]";
	}

	public List<String> validate() {

		List<String> messagesList = new ArrayList<String>();

		if (StringUtils.isEmpty(descrizione) || StringUtils.isEmpty(codice) || StringUtils.isEmpty(prezzoBase + "")) {
			messagesList.add("E' necessario riempire tutti i campi!");
		}

		if (prezzoBase == null || prezzoBase < 0 || !StringUtils.isNumeric(prezzoBase + "")) {
			messagesList.add("Prezzo non valido!");
		}

		if (ingredienti.size() <= 0) {
			messagesList.add("Selezionare ingredienti!");
		}

		return messagesList;
	}

}
