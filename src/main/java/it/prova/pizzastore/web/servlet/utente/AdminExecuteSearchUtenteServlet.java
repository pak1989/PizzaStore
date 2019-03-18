package it.prova.pizzastore.web.servlet.utente;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

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

import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.ruolo.RuoloService;
import it.prova.pizzastore.service.utente.UtenteService;

@WebServlet("/admin/ExecuteSearchUtenteServlet")
public class AdminExecuteSearchUtenteServlet extends HttpServlet {
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

	public AdminExecuteSearchUtenteServlet() {
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

		Utente example = new Utente();
		
//	    Date data = null;
		
		if (StringUtils.isNotEmpty(nome)){
			example.setNome(nome);
		}

		if (StringUtils.isNotEmpty(cognome)){
			example.setCognome(cognome);
		}	

		if (StringUtils.isNotEmpty(username)){
			example.setUsername(username);
		}	
		
		try {
			String dataString = request.getParameter("dataInput");		
			example.setDataRegistrazione(new SimpleDateFormat("yyyy-MM-dd").parse(dataString));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		
		Set<Ruolo> ruoliUtente = new HashSet<>();

		System.out.println(example.toString());
		example.setRuoli(ruoliUtente);
		
		String[] listaIdRuolo = request.getParameterValues("ruoliInput");
		
		if (listaIdRuolo != null) {
			for (String idRuolo : listaIdRuolo) {

				Long idRuoloLong = Long.parseLong(idRuolo);
				
				Ruolo ruoloTemp = ruoloService.caricaSingoloRuolo(idRuoloLong);

				example.getRuoli().add(ruoloTemp);
			}
		}

		request.setAttribute("listaUtentiAttributeName", utenteService.findByExample(example));

		RequestDispatcher rd = request.getRequestDispatcher("/admin/searchResult.jsp");
		rd.forward(request, response);

	}

}
