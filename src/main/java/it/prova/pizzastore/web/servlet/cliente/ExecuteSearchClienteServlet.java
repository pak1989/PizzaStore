package it.prova.pizzastore.web.servlet.cliente;

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
import it.prova.pizzastore.service.cliente.ClienteService;

@WebServlet("/cliente/ExecuteSearchClienteServlet")
public class ExecuteSearchClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ClienteService clienteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteSearchClienteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cliente example = new Cliente();

		String nome = request.getParameter("nomeInput");
		String cognome = request.getParameter("cognomeInput");
		String indirizzo = request.getParameter("indirizzoInput");
		String attivo = request.getParameter("attivoInput");

		if (StringUtils.isNotEmpty(nome)) {
			example.setNome(nome);
		}

		if (StringUtils.isNotEmpty(cognome)) {
			example.setCognome(cognome);
		}

		if (StringUtils.isNotEmpty(indirizzo)) {
			example.setIndirizzo(indirizzo);
		}

		try {
			Integer telefono = Integer.parseInt(request.getParameter("telefonoInput"));
			example.setTelefono(telefono);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		switch (attivo) {
		case "1":
			example.setAttivo(true);
			break;
		case "2":
			example.setAttivo(false);
			break;
		case "3":
			example.setAttivo(null);
			break;
		}

		request.setAttribute("listaCliente", clienteService.findByExample(example));

		RequestDispatcher rd = request.getRequestDispatcher("/cliente/searchResult.jsp");
		rd.forward(request, response);

	}

}
