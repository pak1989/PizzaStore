<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risultati</title>
</head>
<body>

	<div class="container">

  	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Pizze Risultato</h3>
	</div>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Descrizione</th>
				<th>Codice</th>
				<th>Prezzo</th>
				<th>Disp.</th>
				<th>Ingredienti</th>
				<th>Azioni</th>
			</tr>
		</thead>
		
		
			
		<c:forEach var="pizza" items="${listaPizza}">
			<tr>
				<td>${pizza.descrizione}</td>
				<td>${pizza.codice}</td>
				<td>${pizza.prezzoBase}</td>
				<td>
					<c:if test="${pizza.attivo}">SI</c:if>
					<c:if test="${!pizza.attivo}">NO</c:if>
				</td>
				<td>
					<c:forEach var="ingrediente" items="${pizza.ingredienti}">
						${ingrediente.descrizione}
   		 			</c:forEach>
				</td>
				<td>
					<a href="PrepareDettaglioPizzaServlet?idPizza=${pizza.id}" class="btn btn-info">Dettaglio</a>
					<a href="PrepareUpdatePizzaServlet?idPizza=${pizza.id}" class="btn btn-info">Modifica</a>
					<a href="PrepareDeletePizzaServlet?idPizza=${pizza.id}" class="btn btn-danger">Elimina</a>
				</td>
			</tr>
				
		</c:forEach>
	
	</table>
	<a href="${pageContext.request.contextPath}/pizza/PrepareInsertPizzaServlet" class="btn btn-success">Crea Nuova Pizza</a>

	</div>
</body>
</html>