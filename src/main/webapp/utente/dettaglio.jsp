<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Utente</title>
</head>
<body>


	<div class="container">

		<%@ include file="../header.jsp"%>
		<hr>
		<div class="page-header">
			<h3>Ciao ${userInfo.nome}!</h3>
		</div>
		<hr>
		<c:if test="${userInfo.isAdmin() || userInfo.isPizzettaro()}">
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Gestione</dt>
					<dd class="col-sm-9">
						<c:if test="${userInfo.isAdmin()}">
					   		<a class="btn btn-warning btn-md"  href="${pageContext.request.contextPath}/admin/AdminExecuteListUtenteServlet">Utenti</a>
						</c:if>
						<c:if test="${userInfo.isPizzettaro()}">
					   		<a class="btn btn-success btn-md"  href="${pageContext.request.contextPath}/ingrediente/PrepareListIngredienteServlet">Ingredienti</a>
						</c:if>
						<c:if test="${userInfo.isPizzettaro()}">
					   		<a class="btn btn-success btn-md"  href="${pageContext.request.contextPath}/pizza/searchForm.jsp">Pizze</a>
						</c:if>
						<c:if test="${userInfo.isPizzettaro()}">
					   		<a class="btn btn-success btn-md"  href="${pageContext.request.contextPath}/cliente/PrepareSearchClienteServlet">Clienti</a>
						</c:if>
						<c:if test="${userInfo.isPizzettaro()}">
					   		<a class="btn btn-success btn-md"  href="${pageContext.request.contextPath}/ordine/PrepareSearchOrdineServlet">Ordini</a>
						</c:if>
					</dd>
			</dl>
			<hr>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${utenteAttributeName.nome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${utenteAttributeName.cognome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Username</dt>
				<dd class="col-sm-9">${utenteAttributeName.username}</dd>
			</dl>
			<c:if test="${userInfo.isAdmin()}">
				<dl class="row">
					<dt class="col-sm-3 text-right">Password</dt>
					<dd class="col-sm-9">${utenteAttributeName.username}</dd>
				</dl>
			</c:if>
			
			<hr>
			</c:if>
			<c:if test="${userInfo.isFattorino()}">
			<h3>Ordini da evaquare</h3>
			<hr>
			
				<c:forEach items="${userInfo.ordini}" var="ordine">
					<c:if test="${ordine.aperto}">
						<dl class="row">
							<dt class="col-sm-3 text-right">Codice</dt>
							<dd class="col-sm-9">${ordine.codice}</dd>
						</dl>
						<dl class="row">
							<dt class="col-sm-3 text-right">Pizze</dt>
							<dd class="col-sm-9">
							<c:forEach items="${ordine.pizze}" var="pizza">
								< ${pizza.descrizione} > 
							</c:forEach>
							</dd>
						</dl>
						<dl class="row">
							<dt class="col-sm-3 text-right">Cliente</dt>
							<dd class="col-sm-9">${ordine.cliente.nome} ${ordine.cliente.cognome} - ${ordine.cliente.indirizzo}</dd>
						</dl>
						<dl class="row">
							<dt class="col-sm-3 text-right">Azione</dt>
							<dd class="col-sm-9"><a href="${pageContext.request.contextPath}/ExecuteConsegnaOrdinePizzaServlet?idOrdine=${ordine.id}" class="btn btn-success">Consegna</a></dd>
						</dl>
						<hr style="height:1px;border:none;color:#333;background-color:#333;">
					</c:if>
				</c:forEach>
			</c:if>
			
		</div>

	</div>

</body>
</html>