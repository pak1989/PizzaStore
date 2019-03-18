package it.prova.pizzastore.web.servlet.utente;

import java.io.IOException;
import java.util.Date;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.ruolo.RuoloService;
import it.prova.pizzastore.service.utente.UtenteService;
import it.prova.pizzastore.web.dto.UtenteDTO;

@WebServlet("/admin/ExecuteInsertUtenteServlet")
public class AdminExecuteInsertUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private RuoloService ruoloService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public AdminExecuteInsertUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String nome = request.getParameter("nomeInput");
		String cognome = request.getParameter("cognomeInput");
		String username = request.getParameter("usernameInput");
		String password = request.getParameter("passwordInput");
		
		UtenteDTO utenteDTO = new UtenteDTO(nome, cognome, username, password);
		
		Set<Ruolo> ruoliUtente = new HashSet<>();
		utenteDTO.setRuoli(ruoliUtente);
		
		String[] listaIdRuolo = request.getParameterValues("ruoliInput");

		if (listaIdRuolo != null) {
			for (String idRuolo : listaIdRuolo) {

				Long idRuoloLong = Long.parseLong(idRuolo);
				
				Ruolo ruoloTemp = ruoloService.caricaSingoloRuolo(idRuoloLong);

				utenteDTO.getRuoli().add(ruoloTemp);
			}
		}

		Set<Ruolo> ruoliInseriti = utenteDTO.getRuoli();

		List<String> validationMessageStrings = utenteDTO.validate();

		if (!validationMessageStrings.isEmpty()) {
			request.setAttribute("messaggiErrore", validationMessageStrings);
			request.setAttribute("utenteDto", utenteDTO);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/insertForm.jsp");
			rd.forward(request, response);
			return;
		}

		Utente utenteDaInserire = new Utente(nome, cognome, username, password, new Date());

		utenteDaInserire.setRuoli(ruoliInseriti);

		utenteService.inserisciNuovo(utenteDaInserire);

		request.setAttribute("utenteAttributeName", utenteService.caricaSingoloUtente(utenteDaInserire.getId()));

		RequestDispatcher rd = request.getRequestDispatcher("/utente/dettaglio.jsp");
		rd.forward(request, response);
	}
}
