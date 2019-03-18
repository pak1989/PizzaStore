package it.prova.pizzastore.web.servlet.utente;

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

import it.prova.pizzastore.service.utente.UtenteService;


@WebServlet("/DettaglioUtenteServlet")
public class DettaglioUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public DettaglioUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long idUtente = Long.parseLong(request.getParameter("idUtente"));

		request.setAttribute("utenteAttributeName",
				utenteService.caricaSingoloUtente(idUtente));

		RequestDispatcher rd = request.getRequestDispatcher("/utente/dettaglio.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
