package it.prova.pizzastore.service.pizza;

import java.util.List;

import it.prova.pizzastore.model.Pizza;

public interface PizzaService {
	
	public List<Pizza> listAllPizze();

	public Pizza caricaSingoloPizza(Long id);

	public void aggiorna(Pizza pizzaInstance);

	public void inserisciNuovo(Pizza pizzaInstance);

	public void rimuovi(Pizza pizzaInstance);

	public List<Pizza> findByExample(Pizza example);
	
//	public List<Pizza> findByCognome(String cognomeInput);
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
