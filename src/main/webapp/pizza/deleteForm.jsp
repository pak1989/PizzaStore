<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elimina Pizza</title>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Eliminazione Pizza</h3>
	</div>
	<div class="container-fluid">
		<dl class="row">
				<dt class="col-sm-3 text-right">Eliminare Pizza: ${singolaPizza.descrizione} (${singolaPizza.codice})?</dt>
		</dl>
		<dl class="row">
				<dd class="col-sm-9"><a href="${pageContext.request.contextPath}/pizza/ExecuteDeletePizzaServlet?idPizza=${singolaPizza.id}" class="btn btn-danger">Si</a></dd>
				<dd class="col-sm-9"><a href="PrepareSearchUtenteServlet" class="btn btn-info">No</a></dd>
		</dl>
	</div>
    </div><!-- /.container -->



</body>
</html>