package it.prova.pizzastore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.pizzastore.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>, QueryByExampleExecutor<Cliente> {

	List<Cliente> findAllByNomeContaining(String term);
}
