<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${clienteSingolo.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${clienteSingolo.nome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${clienteSingolo.cognome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Indirizzo</dt>
				<dd class="col-sm-9">${clienteSingolo.indirizzo}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Telefono</dt>
				<dd class="col-sm-9">${clienteSingolo.telefono}</dd>
			</dl>
			
			
			
	 		<a href="PrepareUpdateClienteServlet?idCliente=${clienteSingolo.id}" class="btn btn-info">Modifica</a>
			<a href="PrepareDeleteClienteServlet?idCliente=${clienteSingolo.id}" class="btn btn-danger">Elimina</a>
			

		</div>

	</div>
</body>
</html>