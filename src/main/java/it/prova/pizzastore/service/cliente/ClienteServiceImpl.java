package it.prova.pizzastore.service.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pizzastore.model.Cliente;
import it.prova.pizzastore.repository.ClienteRepository;

@Component
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional(readOnly = true)
	public List<Cliente> listAllClienti() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Cliente caricaSingoloCliente(Long id) {
		return clienteRepository.findOne(id);

	}

	@Transactional
	public void aggiorna(Cliente clienteInstance) {
		clienteRepository.save(clienteInstance);
	}

	@Transactional
	public void inserisciNuovo(Cliente clienteInstance) {
		clienteRepository.save(clienteInstance);
	}

	@Transactional
	public void rimuovi(Cliente clienteInstance) {
		clienteRepository.delete(clienteInstance);
	}

	@Transactional(readOnly = true)
	public List<Cliente> findByExample(Cliente example) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING);
		return (List<Cliente>) clienteRepository.findAll(Example.of(example, matcher));
	}

	@Transactional(readOnly = true)
	public List<Cliente> cercaByNomeILike(String term) {
		return clienteRepository.findAllByNomeContaining(term);
	}

	@Transactional
	public void cambiaStatoAttivo(Long idCliente) {
		Cliente clienteDaModificare = clienteRepository.findOne(idCliente);
		clienteDaModificare.setAttivo(clienteDaModificare.getAttivo() ? false : true);
	}

}
