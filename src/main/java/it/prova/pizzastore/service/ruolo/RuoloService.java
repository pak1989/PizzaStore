package it.prova.pizzastore.service.ruolo;

import java.util.List;

import it.prova.pizzastore.model.Ruolo;

public interface RuoloService {
	
	public List<Ruolo> listAllRuoli();

	public Ruolo caricaSingoloRuolo(Long id);

	public void aggiorna(Ruolo ruoloInstance);

	public void inserisciNuovo(Ruolo ruoloInstance);

	public void rimuovi(Ruolo ruoloInstance);

	public List<Ruolo> findByExample(Ruolo example);
	
//	public List<Ordine> findByCognome(String cognomeInput);
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
