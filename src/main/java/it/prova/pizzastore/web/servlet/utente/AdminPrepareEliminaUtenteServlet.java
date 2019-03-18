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

import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.utente.UtenteService;

@WebServlet("/admin/PrepareEliminaUtenteServlet")
public class AdminPrepareEliminaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public AdminPrepareEliminaUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long idUtente = Long.parseLong(request.getParameter("idUtente"));

		Utente utenteDaEliminare = utenteService
				.caricaSingoloUtente(idUtente);

		request.setAttribute("utenteAttributeName", utenteDaEliminare);

		RequestDispatcher rd = request.getRequestDispatcher("/admin/eliminaForm.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
