package it.prova.pizzastore.web.servlet.ordine;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ordine/PrepareSearchOrdineServlet")
public class PrepareSearchOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// @Autowired
	// private UtenteService utenteService;
	//
	// @Autowired
	// private ClienteService clienteService;

	public PrepareSearchOrdineServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.setAttribute("utenteLista", utenteService.listAllUtenti());
		//
		// request.setAttribute("clienteLista", clienteService.listAllClienti());

		RequestDispatcher rd = request.getRequestDispatcher("/ordine/searchForm.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
