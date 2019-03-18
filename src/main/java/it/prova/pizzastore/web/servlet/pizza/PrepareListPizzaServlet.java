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

@WebServlet("/pizza/PrepareListPizzaServlet")
public class PrepareListPizzaServlet extends HttpServlet {
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

	public PrepareListPizzaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		request.setAttribute("listaPizza", pizzaService.listAllPizze());

		RequestDispatcher rd = request.getRequestDispatcher("/pizza/searchResult.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
