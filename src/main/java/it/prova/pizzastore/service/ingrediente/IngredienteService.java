package it.prova.pizzastore.service.ingrediente;

import java.util.List;

import it.prova.pizzastore.model.Ingrediente;

public interface IngredienteService {
	
	public List<Ingrediente> listAllIngredienti();

	public Ingrediente caricaSingoloIngrediente(Long id);

	public void aggiorna(Ingrediente ingredienteInstance);

	public void inserisciNuovo(Ingrediente ingredienteInstance);

	public void rimuovi(Ingrediente ingredienteInstance);

	public List<Ingrediente> findByExample(Ingrediente example);
	
//	public List<Ingrediente> findByCognome(String cognomeInput);
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
