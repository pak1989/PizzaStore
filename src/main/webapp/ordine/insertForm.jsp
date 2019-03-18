<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crea Ordini</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jqueryUI/jquery-ui.min.css" />
<style>
.ui-autocomplete-loading {
	background: white url("img/anim_16x16.gif") right center no-repeat;
}
</style>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Creazione Ordine</h3>
	</div>
	
		<c:forEach var="messaggioItem" items="${messaggiErrore}">
			<div class="alert alert-danger" role="alert">
			  ${messaggioItem}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		</c:forEach>

      	<form class="form-horizontal" action="${pageContext.request.contextPath}/ordine/ExecuteInsertOrdineServlet" method="post">

  			<div class="form-group">
      			<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId" name="codiceInput" value="${ordineDTO.codice}">
			 	</div>
  			</div>
			
      		<div class="form-group">
				<label class="control-label col-sm-2" for="clienteId">Cliente:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="clienteInputId"
						name="clienteInput" value="${ordineDTO.cliente.nome} ${ordineDTO.cliente.cognome}">
					<input type="hidden" name="clienteId" id="clienteId" value="${ordineDTO.cliente.id}">
				</div>
			</div>
		
      		<div class="form-group">
				<label class="control-label col-sm-2" for="utenteId">Fattorino:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="utenteInputId"
						name="utenteInput" value="${ordineDTO.utente.nome} ${ordineDTO.utente.cognome}">
					<input type="hidden" name="utenteId" id="utenteId"value="${ordineDTO.cliente.id}">
				</div>
			</div>			
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="pizzaInputId">Seleziona Pizze:</label>
				<div class="col-sm-4">
					<c:forEach var="pizza" items="${pizzaLista}">
						<c:set var="checked" value="false" />
							<c:forEach var="pizzaOrdine" items="${ordineDTO.pizze}">
								<c:if test="${pizza.id == pizzaOrdine.id && !checked}">
									<c:set var="checked" value="true" />
								</c:if>
							</c:forEach>
						<input type="checkbox" id="pizzaInputId" name="pizzaInput"
							value="${pizza.id}" ${checked?"checked='checked'":""}> ${pizza.descrizione}<br>
					</c:forEach>
				</div>
			</div>
			
			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Crea Ordine</button>
		      </div>
		    </div>
		    
		    <script>
				$( "#clienteInputId" ).autocomplete({
					 source: function(request, response) {
					        $.ajax({
					            url: "SearchUtenteClienteAjaxServlet",
					            datatype: "json",
					            data: {
					                termCliente: request.term,   
					            },
					            success: function(data) {
					                response($.map(data, function(item) {
					                    return {
						                    label: item.label,
						                    value: item.value
					                    }
					                }))
					            }
					        })
					    },
					//quando seleziono la voce nel campo deve valorizzarsi la descrizione
				    focus: function(event, ui) {
				        $("#clienteInputId").val(ui.item.label)
				        return false
				    },
				    minLength: 2,
				    //quando seleziono la voce nel campo hidden deve valorizzarsi l'id
				    select: function( event, ui ) {
				    	$('#clienteId').val(ui.item.value);
				    	console.log($('#clienteId').val())
				        return false;
				    },
				});
				</script>
								
				<script>
				$( "#utenteInputId" ).autocomplete({
					 source: function(request, response) {
					        $.ajax({
					            url: "SearchUtenteClienteAjaxServlet",
					            datatype: "json",
					            data: {
					                termUtente: request.term,   
					            },
					            success: function(data) {
					                response($.map(data, function(item) {
					                    return {
						                    label: item.label,
						                    value: item.value
					                    }
					                }))
					            }
					        })
					    },
					//quando seleziono la voce nel campo deve valorizzarsi la descrizione
				    focus: function(event, ui) {
				        $("#utenteInputId").val(ui.item.label)
				        return false
				    },
				    minLength: 2,
				    //quando seleziono la voce nel campo hidden deve valorizzarsi l'id
				    select: function( event, ui ) {
				    	$('#utenteId').val(ui.item.value);
				    	console.log($('#utenteId').val())
				        return false;
				    },
				});
			</script>
		</form>
		
    </div><!-- /.container -->



</body>
</html>