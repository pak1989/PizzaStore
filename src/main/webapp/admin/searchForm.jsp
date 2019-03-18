<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Utente</title>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Ricerca Utente</h3>
	</div>

      	<form id="form" class="form-horizontal" action="${pageContext.request.contextPath}/admin/ExecuteSearchUtenteServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput" >
			 	</div>
  			</div>
  			
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId" name="cognomeInput" >
			 	</div>
  			</div>
  			
			<div class="form-group">
      			<label class="control-label col-sm-2" for="usernameInputId">Username:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="usernameInputId" name="usernameInput" >
			 	</div>
  			</div>  	
  					
			<div class="form-group">
      			<label class="control-label col-sm-2" for="dataInputId">Data:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="date" id="dataInputId" name="dataInput" >
			 	</div>
  			</div>

			<div class="form-group">
				<div class="col-sm-4">
				    <label for="ruoliInputID">Seleziona ruoli:</label>
				    <select multiple class="form-control" id="ruoliInputID" name="ruoliInput" >
				      <option value="1">Admin</option>
				      <option value="2">User</option>
				      <option value="3">Guest</option>
				    </select>
				  </div>
			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Effetua Ricerca</button>
		        <a href="PrepareInsertUtenteServlet" class="btn btn-success btn-md">Inserisci Nuovo Utente</a>
		      </div>
		    </div>
		</form>
		
    </div>

</body>
</html>