<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingredienti</title>
</head>
<body>

	<div class="container">

  	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Lista Ingredienti</h3>
	</div>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Descrizione</th>
				<th>Prezzo</th>
				<th>Codice</th>
			</tr>
		</thead>
		
		<c:forEach var="ingrediente" items="${listaIngrediente}">
			<tr>
				<td>${ingrediente.descrizione}</td>
				<td>${ingrediente.prezzo}</td>
				<td>${ingrediente.codice}</td>
			</tr>
		</c:forEach>
	
	</table>

	</div>
</body>
</html>