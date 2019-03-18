package it.prova.pizzastore.service.utente;

import java.util.List;

import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.Utente;

public interface UtenteService {
	
	public List<Utente> listAllUtenti();

	public Utente caricaSingoloUtente(Long id);

	public void aggiorna(Utente utenteInstance);

	public void inserisciNuovo(Utente utenteInstance);

	public void rimuovi(Utente utenteInstance);

	public List<Utente> findByExample(Utente example);
	
	public Utente eseguiAccesso(String username, String password);
	
	public List<Utente> cercaByNomeILike(String term);
	
	public List<Utente> cercaByNomeLikeAndRuolo(String term, Ruolo ruolo);
	
//	public List<Utente> findByCognome(String cognomeInput);
//	
//	public List<Automobile> cercaAutomobiliConCilindrataMaggioreDi(int cilindrataInput);
//	
//	public List<Automobile> cercaAutomobiliPerModelloAndCilindrata(String modelloInput, int etaInput);
//	
//	public List<Automobile> cercaAutomobiliByCilindrataOrdinaPerMarcaDesc(int cilindrata);
//	
//	public List<Automobile> cercaPerMarcaCheIniziaCon(String tokenIniziale);
//	
//	public List<Automobile> cercaPerGarageId(Long garageId);	
	
}
