<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Ordini</title>
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
    
    <hr>
      
    <div class="page-header">
	  <h3>Modifica Ordine (COD: ${singoloOrdine.codice}${ordineDTO.codice})</h3>
	</div>
	
		<c:forEach var="messaggioItem" items="${messaggiErrore}">
			<div class="alert alert-danger" role="alert">
			  ${messaggioItem}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		</c:forEach>
		
		<hr>
		
		<c:if test="${singoloOrdine.aperto}">
			<dl class="row">
				<dt class="col-sm-2 text-right">Consegna</dt>
				<dd class="col-sm-9"><a href="${pageContext.request.contextPath}/ExecuteConsegnaOrdinePizzaServlet?idOrdine=${singoloOrdine.id}" class="btn btn-success">Consegna</a></dd>
			</dl>
       	<hr>
		</c:if>
      	<form class="form-horizontal" action="${pageContext.request.contextPath}/ordine/ExecuteUpdateOrdineServlet" method="post">
      	
			<div class="form-group">
      			<label class="control-label col-sm-2" for="idInputId"></label>
	    		<div class="col-sm-4">
					<input class="form-control"  type="hidden" id="idInputId" name="idOrdine" value="${singoloOrdine.id}${ordineDTO.id}">
			 	</div>
  			</div>

  			<div class="form-group">
      			<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId" name="codiceInput" value="${singoloOrdine.codice}${ordineDTO.codice}">
			 	</div>
  			</div>
			
      		<div class="form-group">
				<label class="control-label col-sm-2" for="clienteId">Cliente:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="clienteInputId"
						name="clienteInput" value="${singoloOrdine.cliente.nome}${singoloOrdine.cliente.cognome}${ordineDTO.cliente.nome} ${ordineDTO.cliente.cognome}">
					<input type="hidden" name="clienteId" id="clienteId" value="${singoloOrdine.cliente.id}${ordineDTO.cliente.id}">
				</div>
			</div>
		
      		<div class="form-group">
				<label class="control-label col-sm-2" for="utenteId">Fattorino:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="utenteInputId"
						name="utenteInput" value="${singoloOrdine.utente.nome} ${singoloOrdine.utente.cognome}${ordineDTO.utente.nome} ${ordineDTO.utente.cognome}">
					<input type="hidden" name="utenteId" id="utenteId" value="${singoloOrdine.utente.id}${ordineDTO.utente.id}">
				</div>
			</div>
			
			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Modifica</button>
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