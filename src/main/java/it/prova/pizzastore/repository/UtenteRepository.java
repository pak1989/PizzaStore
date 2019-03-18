package it.prova.pizzastore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long>, QueryByExampleExecutor<Utente> {
	
	Utente findByUsernameAndPassword(String username,String password);
	
	List<Utente> findAllByNomeContaining(String term);

	List<Utente> findAllByNomeContainingAndRuoli(String term, Ruolo ruolo);

	
}
