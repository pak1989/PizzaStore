package it.prova.pizzastore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ruolo")
public class Ruolo implements Serializable {

	private static final long serialVersionUID = 4000618329909480037L;

	public static final String ADMIN_ROLE = "ADMIN_ROLE";
	public static final String PIZZETTARO_ROLE = "PIZZETTARO_ROLE";
	public static final String FATTORINO_ROLE = "FATTORINO_ROLE";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String descrizione;
	private String codice;

	public Ruolo() {
	}

	public Ruolo(long id, String descrizione, String codice) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public Ruolo(String descrizione, String codice) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public Ruolo(String codice) {
		super();
		this.codice = codice;
	}

	public Ruolo(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	@Override
	public String toString() {
		return "Ruolo [id=" + id + ", descrizione=" + descrizione + ", codice=" + codice + "]";
	}

}
