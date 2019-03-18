package it.prova.pizzastore.web.servlet.ordine;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import it.prova.pizzastore.model.Cliente;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.cliente.ClienteService;
import it.prova.pizzastore.service.ruolo.RuoloService;
import it.prova.pizzastore.service.utente.UtenteService;

@WebServlet("/ordine/SearchUtenteClienteAjaxServlet")
public class SearchUtenteClienteAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private RuoloService ruoloService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public SearchUtenteClienteAjaxServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String termUtente = request.getParameter("termUtente");
		String termCliente = request.getParameter("termCliente");

		if (StringUtils.isNotEmpty(termUtente)) {
			List<Utente> listaUtenteByTerm = utenteService.cercaByNomeLikeAndRuolo(termUtente,
					ruoloService.caricaSingoloRuolo(3L));
			String jsonUtente = buildJsonResponseUtente(listaUtenteByTerm);
			response.getWriter().write(jsonUtente);
		}

		if (StringUtils.isNotEmpty(termCliente)) {
			List<Cliente> listaClienteByTerm = clienteService.cercaByNomeILike(termCliente);
			String jsonCliente = buildJsonResponseCliente(listaClienteByTerm);
			response.getWriter().write(jsonCliente);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	private String buildJsonResponseUtente(List<Utente> listaUtente) {
		JsonArray ja = new JsonArray();
		for (Utente utenteElement : listaUtente) {
			JsonObject jo = new JsonObject();
			jo.addProperty("value", utenteElement.getId());
			jo.addProperty("label", utenteElement.getNome() + " " + utenteElement.getCognome());
			ja.add(jo);
		}
		return new Gson().toJson(ja);
	}

	private String buildJsonResponseCliente(List<Cliente> listaCliente) {
		JsonArray ja = new JsonArray();
		for (Cliente clienteElement : listaCliente) {
			JsonObject jo = new JsonObject();
			jo.addProperty("value", clienteElement.getId());
			jo.addProperty("label", clienteElement.getNome() + " " + clienteElement.getCognome());
			ja.add(jo);
		}
		return new Gson().toJson(ja);
	}

}
