package it.prova.pizzastore.web.servlet.pizza;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.pizzastore.model.Ingrediente;
import it.prova.pizzastore.model.Pizza;
import it.prova.pizzastore.service.ingrediente.IngredienteService;
import it.prova.pizzastore.service.pizza.PizzaService;
import it.prova.pizzastore.web.dto.PizzaDTO;

@WebServlet("/pizza/ExecuteInsertPizzaServlet")
public class ExecuteInsertPizzaServlet extends HttpServlet {
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

	public ExecuteInsertPizzaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String descrizione = request.getParameter("descrizioneInput");
		String codice = request.getParameter("codiceInput");
		
		PizzaDTO pizzaDTO = new PizzaDTO(descrizione, codice);
		

		if (StringUtils.isNotEmpty(descrizione)) {
			pizzaDTO.setDescrizione(descrizione);
		}

		if (StringUtils.isNotEmpty(codice)) {
			pizzaDTO.setCodice(codice);
		}

		try {
			int prezzo = Integer.parseInt(request.getParameter("prezzoInput"));
			pizzaDTO.setPrezzoBase(prezzo);
		} catch (NumberFormatException e) {
			System.out.println(">PARSE PREZZO FALLITO<");
		}
		
		Set<Ingrediente> ingredientiPizza = new HashSet<>();
		String[] listaIdIngredienti = request.getParameterValues("ingredientiInput");

		if (listaIdIngredienti != null) {
			for (String idIngrediente : listaIdIngredienti) {

				Long idIngredienteLong = Long.parseLong(idIngrediente);

				Ingrediente ingredienteTemp = ingredienteService.caricaSingoloIngrediente(idIngredienteLong);

				ingredientiPizza.add(ingredienteTemp);
			}
		}
		
		pizzaDTO.setIngredienti(ingredientiPizza);
		
		List<String> validationMessageStrings = pizzaDTO.validate();

		if (!validationMessageStrings.isEmpty()) {			
			request.setAttribute("listaIngrediente", ingredienteService.listAllIngredienti());
			request.setAttribute("messaggiErrore", validationMessageStrings);
			request.setAttribute("pizzaDTO", pizzaDTO);
			RequestDispatcher rd = request.getRequestDispatcher("/pizza/insertForm.jsp");
			rd.forward(request, response);
			return;
		}
		
		Pizza nuovaPizza = new Pizza();
		
		try {
			PropertyUtils.copyProperties(nuovaPizza, pizzaDTO);
			nuovaPizza.setAttivo(true);
			System.out.println(nuovaPizza.toString());
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			System.out.println("COPIA PROPIETA' FALLITA");
		}

		pizzaService.inserisciNuovo(nuovaPizza);

		request.setAttribute("singolaPizza", nuovaPizza);

		RequestDispatcher rd = request.getRequestDispatcher("/pizza/dettaglio.jsp");
		rd.forward(request, response);

	}

}
