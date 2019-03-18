package it.prova.pizzastore.service.cliente;

import java.util.List;

import it.prova.pizzastore.model.Cliente;

public interface ClienteService {
	
	public List<Cliente> listAllClienti();

	public Cliente caricaSingoloCliente(Long id);

	public void aggiorna(Cliente clienteInstance);

	public void inserisciNuovo(Cliente clienteInstance);

	public void rimuovi(Cliente clienteInstance);

	public List<Cliente> findByExample(Cliente example);
	
	public List<Cliente> cercaByNomeILike(String term);
	
	public void cambiaStatoAttivo(Long idCliente);
	
//	public List<Cliente> findByCognome(String cognomeInput);
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
