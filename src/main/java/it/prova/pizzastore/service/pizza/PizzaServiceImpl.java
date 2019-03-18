package it.prova.pizzastore.service.pizza;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pizzastore.model.Pizza;
import it.prova.pizzastore.repository.PizzaRepository;

@Component
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Autowired
	private EntityManager entityManager;	
	

	@Transactional(readOnly = true)
	public List<Pizza> listAllPizze() {
		return (List<Pizza>) pizzaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Pizza caricaSingoloPizza(Long id) {
		return pizzaRepository.findOne(id);

	}

	@Transactional
	public void aggiorna(Pizza pizzaInstance) {
		pizzaRepository.save(pizzaInstance);
	}

	@Transactional
	public void inserisciNuovo(Pizza pizzaInstance) {
		pizzaRepository.save(pizzaInstance);
	}

	@Transactional
	public void rimuovi(Pizza pizzaInstance) {
		pizzaRepository.delete(pizzaInstance);
	}

//	@Transactional(readOnly = true)
//	public List<Pizza> findByExample(Pizza example) {
//		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING);
//		// .withIgnoreNullValues();
//		// Match string containing pattern.withIgnoreCase();
//		return (List<Pizza>) pizzaRepository.findAll(Example.of(example, matcher));
//	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Pizza> findByExample(Pizza pizzaInstance) {
		Query query;
		String domandaAlDb = "FROM Pizza p WHERE 1 = 1";
		if (pizzaInstance.getDescrizione() != null) {
			domandaAlDb += " AND p.descrizione like '%" + pizzaInstance.getDescrizione()+ "%'";
		}
		if (pizzaInstance.getCodice() != null) {
			domandaAlDb += " AND p.codice like '" + pizzaInstance.getCodice() + "'";
		}
		if (pizzaInstance.getPrezzoBase() != null) {
			domandaAlDb += " AND p.prezzoBase > '" + pizzaInstance.getPrezzoBase() + "'";
		}
		if (pizzaInstance.getAttivo() != null) {
			if (pizzaInstance.getAttivo() == true) {
				domandaAlDb += " AND p.attivo = '1'";
			} else {
				domandaAlDb += " AND p.attivo = '0'";
			}
		}
		System.out.println(domandaAlDb);
		query = entityManager.createQuery(domandaAlDb);
		
		return (List<Pizza>) query.getResultList();
	
	}

	// @Transactional(readOnly = true)
	// public List<Pizza> findByCognome(String cognomeInput) {
	// return pizzaRepository.findByCognome(cognomeInput);
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
