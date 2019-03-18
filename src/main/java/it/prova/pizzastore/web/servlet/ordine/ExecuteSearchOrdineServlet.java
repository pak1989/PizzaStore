package it.prova.pizzastore.web.servlet.ordine;

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

import it.prova.pizzastore.model.Cliente;
import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.cliente.ClienteService;
import it.prova.pizzastore.service.ordine.OrdineService;
import it.prova.pizzastore.service.utente.UtenteService;

@WebServlet("/ordine/ExecuteSearchOrdineServlet")
public class ExecuteSearchOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private OrdineService ordineService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteSearchOrdineServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codice = request.getParameter("codiceInput");
		String aperto = request.getParameter("apertoInput");
		Ordine example = new Ordine();

		if (StringUtils.isNotEmpty(codice)) {
			example.setCodice(codice);
		}

		switch (aperto) {
		case "1":
			example.setAperto(true);
			break;
		case "2":
			example.setAperto(false);
			break;
		default:
			break;
		}

		try {
			Long utenteId = Long.parseLong(request.getParameter("utenteId"));
			Utente utenteTrovato = utenteService.caricaSingoloUtente(utenteId);
			example.setUtente(utenteTrovato);
		} catch (NumberFormatException e) {
			System.out.println("PARS UTENTE FALLITO");
		}

		try {
			Long clienteId = Long.parseLong(request.getParameter("clienteId"));
			Cliente clienteTrovato = clienteService.caricaSingoloCliente(clienteId);
			example.setCliente(clienteTrovato);
		} catch (NumberFormatException e) {
			System.out.println("PARS CLIENTE FALLITO");
		}

		request.setAttribute("listaOrdine", ordineService.findByExample(example));

		RequestDispatcher rd = request.getRequestDispatcher("/ordine/searchResult.jsp");
		rd.forward(request, response);

	}

}
