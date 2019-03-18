package it.prova.pizzastore.service.ordine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.repository.OrdineRepository;

@Component
public class OrdineServiceImpl implements OrdineService {

	@Autowired
	private OrdineRepository ordineRepository;

	@Transactional(readOnly = true)
	public List<Ordine> listAllOrdini(){
		return (List<Ordine>) ordineRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Ordine caricaSingoloOrdine(Long id) {
		return ordineRepository.findOne(id);

	}

	@Transactional
	public void aggiorna(Ordine ordineInstance) {
		ordineRepository.save(ordineInstance);
	}

	@Transactional
	public void inserisciNuovo(Ordine ordineInstance) {
		ordineRepository.save(ordineInstance);
	}

	@Transactional
	public void rimuovi(Ordine ordineInstance) {
		ordineRepository.delete(ordineInstance);
	}

	@Transactional(readOnly = true)
	public List<Ordine> findByExample(Ordine example) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING);
		//.withIgnoreNullValues();
		// Match string containing pattern.withIgnoreCase();
		return (List<Ordine>) ordineRepository.findAll(Example.of(example, matcher));
	}

	@Transactional
	public void consegnaOrdine(Long idOrdine) {
		ordineRepository.findOne(idOrdine).setAperto(false);;
	}

//	@Transactional(readOnly = true)
//	public List<Ordine> findByCognome(String cognomeInput) {
//		return ordineRepository.findByCognome(cognomeInput);
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
