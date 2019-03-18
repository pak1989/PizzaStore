package it.prova.pizzastore.service.utente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.repository.UtenteRepository;

@Component
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteRepository utenteRepository;

	@Transactional(readOnly = true)
	public List<Utente> listAllUtenti() {
		return (List<Utente>) utenteRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Utente caricaSingoloUtente(Long id) {
		return utenteRepository.findOne(id);

	}

	@Transactional
	public void aggiorna(Utente utenteInstance) {
		utenteRepository.save(utenteInstance);
	}

	@Transactional
	public void inserisciNuovo(Utente utenteInstance) {
		utenteRepository.save(utenteInstance);
	}

	@Transactional
	public void rimuovi(Utente utenteInstance) {
		utenteRepository.delete(utenteInstance);
	}

	@Transactional(readOnly = true)
	public List<Utente> findByExample(Utente example) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING);
		// .withIgnoreNullValues();
		// Match string containing pattern.withIgnoreCase();
		return (List<Utente>) utenteRepository.findAll(Example.of(example, matcher));
	}

	@Override
	public Utente eseguiAccesso(String username, String password) {
		return utenteRepository.findByUsernameAndPassword(username, password);
	}
	
	@Transactional(readOnly = true)
	public List<Utente> cercaByNomeILike(String term) {
		return utenteRepository.findAllByNomeContaining(term);
	}

	@Transactional(readOnly = true)
	public List<Utente> cercaByNomeLikeAndRuolo(String term, Ruolo ruolo) {
		return utenteRepository.findAllByNomeContainingAndRuoli(term, ruolo);
	}

	// @Transactional(readOnly = true)
	// public List<Utente> findByCognome(String cognomeInput) {
	// return utenteRepository.findByCognome(cognomeInput);
	// }
	//
	// @Transactional(readOnly = true)
	// public List<Automobile> cercaAutomobiliConCilindrataMaggioreDi(int
	// cilindrataInput) {
	// return automobileRepository.findByCilindrataGreaterThan(cilindrataInput);
	// }
	//
	// @Transactional(readOnly = true)
	// public List<Automobile> cercaAutomobiliByCilindrataOrdinaPerMarcaDesc(int
	// cilindrata) {
	// return automobileRepository.findByCilindrataOrderByMarcaDesc(cilindrata);
	// }
	//
	// @Transactional(readOnly = true)
	// public List<Automobile> cercaPerMarcaCheIniziaCon(String tokenIniziale) {
	// return automobileRepository.findByMarcaStartsWith(tokenIniziale);
	// }
	//
	// @Transactional(readOnly = true)
	// public List<Automobile> cercaAutomobiliPerModelloAndCilindrata(String
	// modelloInput, int cilindrataInput) {
	// return automobileRepository.findByModelloAndCilindrata(modelloInput,
	// cilindrataInput);
	// }
	//
	// @Transactional(readOnly = true)
	// public List<Automobile> cercaPerGarageId(Long garageId) {
	// return automobileRepository.findByGarageId(garageId);
	// }

}
