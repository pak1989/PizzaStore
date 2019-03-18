<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Ordine</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Ricerca Cliente</h3>
		</div>

		<form class="form-horizontal" action="${pageContext.request.contextPath}/cliente/ExecuteSearchClienteServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="indirizzoInputId">Indirizzo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="indirizzoInputId"
						name="indirizzoInput">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="telefonoInputId">Telefono:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="telefonoInputId"
						name="telefonoInput">
				</div>
			</div>
			
			 <div class="form-group col-sm-4">
				<div class="form-check">
					<input class="form-check-input" type="radio" name="attivoInput" id="attivoInputId" value="1">
					<label class="form-check-label" for="attivoInputId">Vivo</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="attivoInput" id="attivoInputId" value="2">
					<label class="form-check-label" for="attivoInputId">Morto</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="attivoInput" id="attivoInputId" value="3" checked>
					<label class="form-check-label" for="attivoInputId">Ics</label>
				</div>
			</div>



			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Effetua
						Ricerca</button>
					<a href="${pageContext.request.contextPath}/cliente/PrepareInsertClienteServlet" class="btn btn-primary btn-md">Inserisci
						Nuovo Cliente</a>
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->



</body>
</html>