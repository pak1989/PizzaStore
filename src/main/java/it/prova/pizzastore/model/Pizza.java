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

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;
	private String codice;
	private Integer prezzoBase;
	private Boolean attivo;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "pizza_ingrediente", joinColumns = {
			@JoinColumn(name = "pizza_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "ingrediente_id", referencedColumnName = "id") })
	private Set<Ingrediente> ingredienti = new HashSet<>(0);

	public Pizza() {
	}

	public Pizza(String descrizione, String codice) {
		this.descrizione = descrizione;
		this.codice = codice;
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

	public Set<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(Set<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	public Integer prezzoFinito() {

		Integer prezzoFinale = 0;
		for (Ingrediente ingredienteItem : ingredienti) {
			prezzoFinale += ingredienteItem.getPrezzo();
		}
		return prezzoFinale += prezzoBase;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", descrizione=" + descrizione + ", codice=" + codice + ", prezzoBase=" + prezzoBase
				+ ", attivo=" + attivo + "]";
	}

	
}
