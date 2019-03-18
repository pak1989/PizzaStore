package it.prova.pizzastore.service.ruolo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.repository.RuoloRepository;

@Component
public class RuoloServiceImpl implements RuoloService {

	@Autowired
	private RuoloRepository ruoloRepository;

	@Transactional(readOnly = true)
	public List<Ruolo> listAllRuoli(){
		return (List<Ruolo>) ruoloRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Ruolo caricaSingoloRuolo(Long id) {
		return ruoloRepository.findOne(id);

	}

	@Transactional
	public void aggiorna(Ruolo ruoloInstance) {
		ruoloRepository.save(ruoloInstance);
	}

	@Transactional
	public void inserisciNuovo(Ruolo ruoloInstance) {
		ruoloRepository.save(ruoloInstance);
	}

	@Transactional
	public void rimuovi(Ruolo ruoloInstance) {
		ruoloRepository.delete(ruoloInstance);
	}

	@Transactional(readOnly = true)
	public List<Ruolo> findByExample(Ruolo example) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING);
		//.withIgnoreNullValues();
		// Match string containing pattern.withIgnoreCase();
		return (List<Ruolo>) ruoloRepository.findAll(Example.of(example, matcher));
	}



//	@Transactional(readOnly = true)
//	public List<Ruolo> findByCognome(String cognomeInput) {
//		return ruoloRepository.findByCognome(cognomeInput);
//	}
//
//	@Transactional(readOnly = true)
//	public List<Automobile> cercaAutomobiliConCilindrataMaggioreDi(int cilindrataInput) {
//		return automobileRepository.findByCilindrataGreaterThan(cilindrataInput);
//	}
//
//	@Transactional(readOnly = true)
//	public List<Automobile> cercaAutomobiliByCilindrataOrdinaPerMarcaDesc(int cilindrata) {
//		return automobileRepository.findByCilindrataOrderByMarcaDesc(cilindrata);
//	}
//
//	@Transactional(readOnly = true)
//	public List<Automobile> cercaPerMarcaCheIniziaCon(String tokenIniziale) {
//		return automobileRepository.findByMarcaStartsWith(tokenIniziale);
//	}
//
//	@Transactional(readOnly = true)
//	public List<Automobile> cercaAutomobiliPerModelloAndCilindrata(String modelloInput, int cilindrataInput) {
//		return automobileRepository.findByModelloAndCilindrata(modelloInput, cilindrataInput);
//	}
//
//	@Transactional(readOnly = true)
//	public List<Automobile> cercaPerGarageId(Long garageId) {
//		return automobileRepository.findByGarageId(garageId);
//	}

}
