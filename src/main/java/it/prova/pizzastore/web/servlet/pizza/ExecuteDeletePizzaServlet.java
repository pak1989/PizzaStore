package it.prova.pizzastore.web.servlet.pizza;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.pizzastore.service.pizza.PizzaService;

@WebServlet("/pizza/ExecuteDeletePizzaServlet")
public class ExecuteDeletePizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@Autowired
//	private IngredienteService ingredienteService;

	@Autowired
	private PizzaService pizzaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteDeletePizzaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long idPizza = Long.parseLong(request.getParameter("idPizza"));

		pizzaService.rimuovi(pizzaService.caricaSingoloPizza(idPizza));

		RequestDispatcher rd = request.getRequestDispatcher("/pizza/PrepareListPizzaServlet");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
