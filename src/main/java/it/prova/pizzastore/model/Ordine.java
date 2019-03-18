package it.prova.pizzastore.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String codice;
	private Boolean aperto;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "ordine_pizza", joinColumns = {
			@JoinColumn(name = "ordine_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "pizza_id", referencedColumnName = "id") })
	private Set<Pizza> pizze = new HashSet<>(0);
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id", nullable = true)
	private Cliente cliente;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "utente_id", nullable = true)
	private Utente utente;

	public Ordine() {
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

	public Boolean getAperto() {
		return aperto;
	}

	public void setAperto(Boolean aperto) {
		this.aperto = aperto;
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
	
	public Integer costoOrdine() {
		Integer costoFinale = 0;
		for (Pizza pizzaItem : pizze) {
			costoFinale += pizzaItem.prezzoFinito();
		}
		return costoFinale;
	}

}
