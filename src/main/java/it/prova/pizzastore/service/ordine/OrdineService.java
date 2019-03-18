package it.prova.pizzastore.service.ordine;

import java.util.List;

import it.prova.pizzastore.model.Ordine;

public interface OrdineService {
	
	public List<Ordine> listAllOrdini();

	public Ordine caricaSingoloOrdine(Long id);

	public void aggiorna(Ordine ordineInstance);

	public void inserisciNuovo(Ordine ordineInstance);

	public void rimuovi(Ordine ordineInstance);

	public List<Ordine> findByExample(Ordine example);
	
	public void consegnaOrdine(Long idOrdine);
	
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
