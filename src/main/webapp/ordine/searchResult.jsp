<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	  <h3>Ordini Risultato</h3>
	</div>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Codice</th>
				<th>Cliente</th>
				<th>Fattorino</th>
				<th>Consegnato</th>
				<th>Prezzo</th>
				<th>Azioni</th>
			</tr>
		</thead>
		
		
			
		<c:forEach var="ordine" items="${listaOrdine}">
			<tr>
				<td>${ordine.codice}</td>
				<td>${ordine.cliente.nome} ${ordine.cliente.cognome}</td>
				<td>${ordine.utente.nome} ${ordine.utente.cognome}</td>
				<td>
					<c:if test="${!ordine.aperto}">SI</c:if>
					<c:if test="${ordine.aperto}">NO</c:if>
				</td>
				<td>${ordine.costoOrdine()}</td>
				<td>
					<a href="PrepareDettaglioOrdineServlet?idOrdine=${ordine.id}" class="btn btn-info">Dettaglio</a>
					<a href="PrepareUpdateOrdineServlet?idOrdine=${ordine.id}" class="btn btn-info">Modifica</a>
<%-- 					<a href="PrepareDeleteOrdineServlet?idOrdine=${ordine.id}" class="btn btn-danger">Elimina</a> --%>
				</td>
			</tr>
				
		</c:forEach>
	
	</table>
	<a href="${pageContext.request.contextPath}/ordine/PrepareInsertOrdineServlet" class="btn btn-success">Nuovo Ordine</a>

	</div>
</body>
</html>