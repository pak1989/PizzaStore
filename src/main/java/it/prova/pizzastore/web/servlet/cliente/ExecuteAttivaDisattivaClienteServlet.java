package it.prova.pizzastore.web.servlet.cliente;

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

import it.prova.pizzastore.service.cliente.ClienteService;

@WebServlet("/cliente/ExecuteAttivaDisattivaClienteServlet")
public class ExecuteAttivaDisattivaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ClienteService clienteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteAttivaDisattivaClienteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long idCliente = Long.parseLong(request.getParameter("idCliente"));
		
		clienteService.cambiaStatoAttivo(idCliente);
		
//		request.setAttribute("clienteSingolo", clienteService.caricaSingoloCliente(idCliente));
	
//		RequestDispatcher rd = request.getRequestDispatcher("/cliente/dettaglio.jsp");
		
		request.setAttribute("listaCliente", clienteService.listAllClienti());
		
		RequestDispatcher rd = request.getRequestDispatcher("/cliente/searchResult.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
