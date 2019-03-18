package it.prova.pizzastore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.pizzastore.model.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, Long>, QueryByExampleExecutor<Pizza> {
}
