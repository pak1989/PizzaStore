package it.prova.pizzastore.web.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import it.prova.pizzastore.model.Cliente;
import it.prova.pizzastore.model.Pizza;
import it.prova.pizzastore.model.Utente;

public class OrdineDTO {
	private Long id;
	private String codice;

	private Set<Pizza> pizze = new HashSet<>(0);

	private Cliente cliente;

	private Utente utente;

	public OrdineDTO() {
	}

	public OrdineDTO(Long id, String codice) {
		super();
		this.id = id;
		this.codice = codice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Set<Pizza> getPizze() {
		return pizze;
	}

	public void setPizze(Set<Pizza> pizze) {
		this.pizze = pizze;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<String> validate() {

		List<String> messagesList = new ArrayList<String>();

		if (StringUtils.isEmpty(codice) || utente == null || cliente == null) {
			messagesList.add("E' necessario riempire tutti i campi!");
		}

		if (id == null) {
			if (pizze.isEmpty() || pizze == null) {
				messagesList.add("Seleziona almeno una pizza!");
			}
		}

		return messagesList;
	}

	@Override
	public String toString() {
		return "OrdineDTO [id=" + id + ", codice=" + codice + ", cliente=" + cliente.getNome() + ", utente="
				+ utente.getCognome() + "]";
	}

}
