package it.prova.pizzastore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.pizzastore.model.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long>, QueryByExampleExecutor<Ingrediente> {

	
}
