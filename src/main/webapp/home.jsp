<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accedi</title>
</head>
<body>

<div class="container">
 <%@ include file="header.jsp" %>

<!-- 	<div class="jumbotron"> -->
<!--       <div class="container"> -->
<!-- <!--         <h1 class="display-4">Gestione Garage</h1> -->
<%--         <p> <img alt="" style="height:200px" src="https://www.montecchio.info/5/HouseAndOffice/Immobili/498/garage-in-vendita-bolzano-2304-498.jpg"> <a class="btn btn-outline-primary btn-lg" href="${pageContext.request.contextPath}/PrepareSearchGarageServlet" role="button">Gestione Garage &raquo;</a></p> --%>
<!--       </div> -->
      
<!--     </div> -->
    <div style="background-color:#7BE0FE;" class="jumbotron">
      <div class="container">
		<h1 class="display-4">Pizza Store</h1> 
        <p> <img alt="" style="height:200px" src="https://image.freepik.com/free-vector/pizza-illustration_8319-36.jpg"> 
        	 <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/DettaglioUtenteServlet?idUtente=${userInfo.id}" role="button">Entra &raquo;</a>
        </p>
      </div>
      
    </div>



	 <%@ include file="footer.jsp" %>
</div>

</body>
</html>