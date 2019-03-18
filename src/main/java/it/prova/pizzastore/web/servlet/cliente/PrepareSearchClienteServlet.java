package it.prova.pizzastore.web.servlet.cliente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cliente/PrepareSearchClienteServlet")
public class PrepareSearchClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrepareSearchClienteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		RequestDispatcher rd = request.getRequestDispatcher("/cliente/searchForm.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
