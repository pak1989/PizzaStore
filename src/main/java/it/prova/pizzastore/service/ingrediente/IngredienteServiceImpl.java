package it.prova.pizzastore.service.ingrediente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pizzastore.model.Ingrediente;
import it.prova.pizzastore.repository.IngredienteRepository;

@Component
public class IngredienteServiceImpl implements IngredienteService {

	@Autowired
	private IngredienteRepository ingredienteRepository;

	@Transactional(readOnly = true)
	public List<Ingrediente> listAllIngredienti() {
		return (List<Ingrediente>) ingredienteRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Ingrediente caricaSingoloIngrediente(Long id) {
		return ingredienteRepository.findOne(id);

	}

	@Transactional
	public void aggiorna(Ingrediente ingredienteInstance) {
		ingredienteRepository.save(ingredienteInstance);
	}

	@Transactional
	public void inserisciNuovo(Ingrediente ingredienteInstance) {
		ingredienteRepository.save(ingredienteInstance);
	}

	@Transactional
	public void rimuovi(Ingrediente ingredienteInstance) {
		ingredienteRepository.delete(ingredienteInstance);
	}

	@Transactional(readOnly = true)
	public List<Ingrediente> findByExample(Ingrediente example) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING);
		// .withIgnoreNullValues();
		// Match string containing pattern.withIgnoreCase();
		return (List<Ingrediente>) ingredienteRepository.findAll(Example.of(example, matcher));
	}

	// @Transactional(readOnly = true)
	// public List<Ingrediente> findByCognome(String cognomeInput) {
	// return ingredienteRepository.findByCognome(cognomeInput);
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
