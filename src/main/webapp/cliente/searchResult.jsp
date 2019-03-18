<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clienti Risultato</title>
</head>
<body>
<div class="container">

  	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Clienti Risultato</h3>
	</div>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Indirizzo</th>
				<th>Telefono</th>
				<th>Azioni</th>
			</tr>
		</thead>

		<c:forEach var="cliente" items="${listaCliente}">
			<tr>
				<td>${cliente.nome}</td>
				<td>${cliente.cognome}</td>
				<td>${cliente.indirizzo}</td>
				<td>${cliente.telefono}</td>
				<td>
					<a href="${pageContext.request.contextPath}/cliente/PrepareDettaglioClienteServlet?idCliente=${cliente.id}" class="btn btn-warning">Dettaglio</a>
					<a href="${pageContext.request.contextPath}/cliente/PrepareUpdateClienteServlet?idCliente=${cliente.id}" class="btn btn-info">Modifica</a>
					<c:if test="${cliente.attivo}">
						<a href="${pageContext.request.contextPath}/cliente/ExecuteAttivaDisattivaClienteServlet?idCliente=${cliente.id}" class="btn btn-danger">Uccidi</a>
					</c:if>
					<c:if test="${!cliente.attivo}">
						<a href="${pageContext.request.contextPath}/cliente/ExecuteAttivaDisattivaClienteServlet?idCliente=${cliente.id}" class="btn btn-success">Resuscita</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	
	</table>
</div>
	<a href="PrepareInsertClienteServlet" class="btn btn-info">Inserisci un nuovo Cliente</a>
<%@ include file="../footer.jsp" %>
</body>
</html>