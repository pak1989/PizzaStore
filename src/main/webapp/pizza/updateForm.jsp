<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Pizza</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>
		<div class="page-header">
			<h3>Modifica Pizza ${singolaPizza.descrizione}${pizzaDTO.descrizione}</h3>
		</div>
		
		<c:forEach var="messaggioItem" items="${messaggiErrore}">
			<div class="alert alert-danger" role="alert">
			  ${messaggioItem}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		</c:forEach>

		<form class="form-horizontal" action="${pageContext.request.contextPath}/pizza/ExecuteUpdatePizzaServlet" method="post">
		
			<div class="form-group">
      			<label class="control-label col-sm-2" for="idInputId"></label>
	    		<div class="col-sm-4">
					<input class="form-control"  type="hidden" id="idInputId" name="idPizza" value="${singolaPizza.id}${pizzaDTO.id}">
			 	</div>
  			</div>
		
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput" value="${singolaPizza.descrizione}${pizzaDTO.descrizione}">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId" name="codiceInput" value="${singolaPizza.codice}${pizzaDTO.codice}">
			 	</div>
  			</div>
			
			<div class="form-group">
      			<label class="control-label col-sm-2" for="prezzoInputId">Prezzo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="number" id="prezzoInputId" name="prezzoInput" value="${singolaPizza.prezzoBase}${pizzaDTO.prezzoBase}">
			 	</div>
  			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="ingredientiInputId">Seleziona Ingredienti:</label>
				<div class="col-sm-4">
				
				<c:if test="${singolaPizza != null}">
					<c:forEach var="ingrediente" items="${listaIngrediente}">
							<c:set var="checked" value="false" />
								<c:forEach var="ingredientePizza" items="${singolaPizza.ingredienti}">
									<c:if test="${ingredientePizza.id == ingrediente.id && !checked}">
										<c:set var="checked" value="true" />
									</c:if>
								</c:forEach>
						<input type="checkbox" id="ingredientiInputId" name="ingredientiInput" 
						value="${ingrediente.id}" ${checked?"checked='checked'":""}> ${ingrediente.descrizione}<br>
					</c:forEach>
				</c:if>
				
<!-- 				DATI DEL DTO -->
				<c:if test="${pizzaDTO != null}">
					<c:forEach var="ingrediente" items="${listaIngrediente}">
							<c:set var="checked" value="false" />
								<c:forEach var="ingredientePizzaDTO" items="${pizzaDTO.ingredienti}">
									<c:if test="${ingredientePizzaDTO.descrizione == ingrediente.descrizione && !checked}">
										<c:set var="checked" value="true" />
									</c:if>
								</c:forEach>
						<input type="checkbox" id="ingredientiInputId" name="ingredientiInput" 
						value="${ingrediente.id}" ${checked?"checked='checked'":""}> ${ingrediente.descrizione}<br>
					</c:forEach>
				</c:if>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Crea</button>
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->

</body>
</html>