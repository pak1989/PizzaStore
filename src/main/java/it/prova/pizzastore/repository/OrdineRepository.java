package it.prova.pizzastore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.pizzastore.model.Ordine;

public interface OrdineRepository extends CrudRepository<Ordine, Long>, QueryByExampleExecutor<Ordine> {

	
}
