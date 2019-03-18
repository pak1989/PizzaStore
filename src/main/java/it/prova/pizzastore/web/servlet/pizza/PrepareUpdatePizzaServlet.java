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

import it.prova.pizzastore.service.ingrediente.IngredienteService;
import it.prova.pizzastore.service.pizza.PizzaService;

@WebServlet("/pizza/PrepareUpdatePizzaServlet")
public class PrepareUpdatePizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IngredienteService ingredienteService;

	@Autowired
	private PizzaService pizzaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public PrepareUpdatePizzaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long idPizza = Long.parseLong(request.getParameter("idPizza"));

		request.setAttribute("singolaPizza", pizzaService.caricaSingoloPizza(idPizza));

		request.setAttribute("listaIngrediente", ingredienteService.listAllIngredienti());

		RequestDispatcher rd = request.getRequestDispatcher("/pizza/updateForm.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
