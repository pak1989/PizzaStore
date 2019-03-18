package it.prova.pizzastore.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.pizzastore.model.Utente;

@WebFilter(filterName = "CheckAuthFilter", urlPatterns = { "/*" })
public class CheckAuthFilter implements Filter {

	private static final String[] EXCLUDED_URLS = { "/home.jsp", "/login.jsp", "/LoginServlet", "/LogoutServlet",
			"/css/", "/js/" };
	private static final String[] ADMIN_URLS = { "/admin/" };
	private static final String[] PIZZETTARO_URLS = { "/pizza/", "/ordine/", "/ingrediente/" };

	public CheckAuthFilter() {
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// System.out.println("Nel filtro di check user in session");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// prendo il path della request che sta passando in questo momento
		String pathAttuale = httpRequest.getServletPath();
		// System.out.println("Invocazione di: " + pathAttuale);

		// vediamo se il path risulta tra quelli 'liberi di passare'
		boolean isInWhiteList = isPathInWhiteList(pathAttuale);

		// se non lo e' bisogna controllare sia sessione che percorsi protetti
		if (!isInWhiteList) {
			Utente utenteInSession = (Utente) httpRequest.getSession().getAttribute("userInfo");
			// intanto verifico se utente in sessione
			// System.out.println(utenteInSession == null);
			if (utenteInSession == null) {
				httpResponse.sendRedirect(httpRequest.getContextPath());
				return;
			}
			// controllo che utente abbia ruolo admin se nel path risulta presente /admin/
			if (isPathForOnlyAdministrators(pathAttuale) && !utenteInSession.isAdmin()) {
				httpRequest.setAttribute("messaggio", "Non si è autorizzati alla navigazione richiesta");
				httpRequest.getRequestDispatcher("/home.jsp").forward(httpRequest, httpResponse);
				return;
			}
			// controllo che utente abbia ruolo pizzattaro se nel path risulta presente
			// /pizza/
			if (isPathForOnlyPizzettaro(pathAttuale) && !utenteInSession.isPizzettaro()) {
				httpRequest.setAttribute("messaggio", "Non si è autorizzati alla navigazione richiesta");
				httpRequest.getRequestDispatcher("/home.jsp").forward(httpRequest, httpResponse);
				return;
			}
		}

		chain.doFilter(request, response);
	}

	private boolean isPathInWhiteList(String requestPath) {
		for (String urlPatternItem : EXCLUDED_URLS) {
			if (requestPath.contains(urlPatternItem)) {
				System.out.println("url invocabile liberamente");
				return true;
			}
		}
		return false;
	}

	private boolean isPathForOnlyAdministrators(String requestPath) {
		for (String urlPatternItem : ADMIN_URLS) {
			if (requestPath.contains(urlPatternItem)) {
				System.out.println("ADMIN: url invocabile liberamente");
				return true;
			}
		}
		return false;
	}

	private boolean isPathForOnlyPizzettaro(String requestPath) {
		for (String urlPatternItem : PIZZETTARO_URLS) {
			if (requestPath.contains(urlPatternItem)) {
				System.out.println("PIZZETTARO: url invocabile liberamente");
				return true;
			}
		}
		return false;
	}

	public void destroy() {
	}

}
