package it.prova.pizzastore.web.servlet.pizza;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.pizzastore.model.Pizza;
import it.prova.pizzastore.service.pizza.PizzaService;

@WebServlet("/pizza/ExecuteSearchPizzaServlet")
public class ExecuteSearchPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// @Autowired
	// private UtenteService utenteService;

	@Autowired
	private PizzaService pizzaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteSearchPizzaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String descrizione = request.getParameter("nomeInput");
		String codice = request.getParameter("cognomeInput");
		String attivo = request.getParameter("attivoInput");
		Pizza example = new Pizza();

		if (StringUtils.isNotEmpty(descrizione)) {
			example.setDescrizione(descrizione);
		}

		if (StringUtils.isNotEmpty(codice)) {
			example.setCodice(codice);
		}

		try {
			int prezzo = Integer.parseInt(request.getParameter("prezzoInput"));
			example.setPrezzoBase(prezzo);
		} catch (NumberFormatException e) {
			System.out.println(">PARSE PREZZO FALLITO<");
		}

		switch (attivo) {
		case "1":
			example.setAttivo(true);
			break;
		case "2":
			example.setAttivo(false);
			break;
		default:
			break;
		}

		request.setAttribute("listaPizza", pizzaService.findByExample(example));

		RequestDispatcher rd = request.getRequestDispatcher("/pizza/searchResult.jsp");
		rd.forward(request, response);

	}

}
