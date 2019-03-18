package it.prova.pizzastore.web.servlet.ordine;

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

import it.prova.pizzastore.model.Cliente;
import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.model.Pizza;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.cliente.ClienteService;
import it.prova.pizzastore.service.ordine.OrdineService;
import it.prova.pizzastore.service.pizza.PizzaService;
import it.prova.pizzastore.service.utente.UtenteService;
import it.prova.pizzastore.web.dto.OrdineDTO;

@WebServlet("/ordine/ExecuteInsertOrdineServlet")
public class ExecuteInsertOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private OrdineService ordineService;

	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteInsertOrdineServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrdineDTO ordineDTO = new OrdineDTO();
		
		String codice = request.getParameter("codiceInput");

		if (StringUtils.isNotEmpty(codice)) {
			ordineDTO.setCodice(codice);
		}

		try {
			Long utenteId = Long.parseLong(request.getParameter("utenteId"));
			Utente utenteTrovato = utenteService.caricaSingoloUtente(utenteId);
			ordineDTO.setUtente(utenteTrovato);
		} catch (NumberFormatException e) {
			System.out.println("PARSE UTENTE FALLITO: " + request.getParameter("utenteId"));
		}

		try {
			Long clienteId = Long.parseLong(request.getParameter("clienteId"));
			Cliente clienteTrovato = clienteService.caricaSingoloCliente(clienteId);
			ordineDTO.setCliente(clienteTrovato);
		} catch (NumberFormatException e) {
			System.out.println("PARSE CLIENTE FALLITO: " + request.getParameter("clienteId"));
		}

		Set<Pizza> pizzeOrdine = new HashSet<>();
		String[] listaIdPizze = request.getParameterValues("pizzaInput");

		if (listaIdPizze != null) {
			for (String idPizze : listaIdPizze) {
				pizzeOrdine.add(pizzaService.caricaSingoloPizza(Long.parseLong(idPizze)));
			}
		}
		
		ordineDTO.setPizze(pizzeOrdine);

		List<String> validationMessageStrings = ordineDTO.validate();

		if (!validationMessageStrings.isEmpty()) {
			request.setAttribute("pizzaLista", pizzaService.listAllPizze());
			request.setAttribute("messaggiErrore", validationMessageStrings);
			request.setAttribute("ordineDTO", ordineDTO);
			RequestDispatcher rd = request.getRequestDispatcher("/ordine/insertForm.jsp");
			rd.forward(request, response);
			return;
		}

		Ordine ordineDaInserire = new Ordine();
		ordineDaInserire.setAperto(true);

		try {
			PropertyUtils.copyProperties(ordineDaInserire, ordineDTO);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			System.out.println("COPIA PROPIETA' FALLITA");
		}

		ordineService.inserisciNuovo(ordineDaInserire);

		request.setAttribute("singoloOrdine", ordineDaInserire);

		RequestDispatcher rd = request.getRequestDispatcher("/ordine/dettaglio.jsp");
		rd.forward(request, response);

	}

}
