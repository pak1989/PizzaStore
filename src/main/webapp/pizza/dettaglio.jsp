<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Pizza</title>
</head>
<body>


	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio Pizza ${singolaPizza.descrizione}</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Gestione</dt>
					<dd class="col-sm-9">
					   	<a class="btn btn-warning btn-md"  href="${pageContext.request.contextPath}/pizza/PrepareUpdatePizzaServlet?idPizza=${singolaPizza.id}">Modifica</a>
					   	<a class="btn btn-danger btn-md"  href="${pageContext.request.contextPath}/pizza/PrepareDeletePizzaServlet?idPizza=${singolaPizza.id}">Elimina</a>
					</dd>
			</dl>
			<hr>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrzione</dt>
				<dd class="col-sm-9">${singolaPizza.descrizione}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice</dt>
				<dd class="col-sm-9">${singolaPizza.codice}</dd>
			</dl>			
			<dl class="row">
				<dt class="col-sm-3 text-right">Disponibile</dt>
					<c:if test="${singolaPizza.attivo}"><dd class="col-sm-9">SI</dd></c:if>
					<c:if test="${!singolaPizza.attivo}"><dd class="col-sm-9">NO</dd></c:if>
			</dl>
			
			<hr>
			
			<dl class="row">
				<dt class="col-sm-3 text-right">Ingredienti</dt>
					<dd class="col-sm-9">
						<c:forEach var="ingrediente" items="${singolaPizza.ingredienti}">
							${ingrediente.descrizione}
   		 				</c:forEach>
					</dd>
			</dl>
			
		</div>

	</div>

</body>
</html>