<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Pizze</title>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Ricerca</h3>
	</div>

      	<form class="form-horizontal" action="${pageContext.request.contextPath}/pizza/ExecuteSearchPizzaServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId" name="codiceInput" >
			 	</div>
  			</div>
			
			<div class="form-group">
      			<label class="control-label col-sm-2" for="prezzoInputId">Prezzo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="number" id="prezzoInputId" name="prezzoInput" >
			 	</div>
  			</div>
  			<div class="form-group col-sm-4">
				<div class="form-check">
					<input class="form-check-input" type="radio" name="attivoInput" id="attivoInputId" value="1" checked>
					<label class="form-check-label" for="attivoInputId">In vendita</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="attivoInput" id="attivoInputId" value="2">
					<label class="form-check-label" for="attivoInputId">Esaurita</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="attivoInput" id="attivoInputId" value="3" >
					<label class="form-check-label" for="attivoInputId">Indifferente</label>
				</div>
			</div>
			
			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Effetua Ricerca</button>
		        <a href="${pageContext.request.contextPath}/pizza/PrepareInsertPizzaServlet" class="btn btn-success btn-md">Crea Nuova Pizza</a>
		      </div>
		    </div>
		</form>
		
    </div><!-- /.container -->



</body>
</html>