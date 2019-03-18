<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- StringUtils -->
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- Static navbar -->
<nav class="navbar sticky-top bg-dark navbar-expand-lg navbar-dark " style="background-color: #e3f2fd;">
	<img alt="" style="height:50px;border-radius: 50px;" src="https://image.freepik.com/free-vector/pizza-illustration_8319-36.jpg"> °
	<a class="navbar-brand" href="${pageContext.request.contextPath}/home.jsp">Pizza Store</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<%-- <li class="nav-item active"><a class="nav-link" href="<%= request.getContextPath()%>/home.jsp">Home --%>
			<!-- <span class="sr-only">(current)</span> -->
			<!-- </a></li> -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Quick links </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="${pageContext.request.contextPath}/PrepareListClientiServlet">Lista Clienti</a> <a
						class="dropdown-item" href="${pageContext.request.contextPath}/pizza/PrepareListPizzaServlet">Lista Pizze</a>
			<!-- <div class="dropdown-divider"></div> -->
			<!-- <a class="dropdown-item" href="#">Something else here</a> -->
				</div></li>
		</ul>
		 <ul class="nav navbar-nav navbar-right">
		 <li>
		 		<c:if test="${userInfo.isAdmin()}">
				   	<a class="btn btn-outline-warning btn-md"  href="${pageContext.request.contextPath}/admin/PrepareSearchUtenteServlet">Area Admin</a>
				</c:if>
				
<%-- 			    <c:forEach items="${userInfo.ruoli}" var="ruolo"> --%>
<%-- 			    	<c:if test="${ruolo.codice == 'ADMIN_ROLE'}"> --%>
<%-- 				    		<a class="btn btn-outline-warning btn-md"  href="${pageContext.request.contextPath}/admin/PrepareSearchUtenteServlet">Area Admin</a></p> --%>
<%-- 					</c:if> --%>
<%-- 				</c:forEach> --%>
	            
	            <c:if test="${userInfo != null}">
	            	<a class="btn btn-outline-success btn-md" href="${pageContext.request.contextPath}/DettaglioUtenteServlet?idUtente=${userInfo.id}">Area personale</a>
					<a class="btn btn-danger btn-md" href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
				</c:if>
				
				<c:if test="${userInfo == null}">
		            <a class="btn btn-success btn-md" href="${pageContext.request.contextPath}/login.jsp">Login</a> 
	            </c:if>
            </li>
          </ul>
	</div>
</nav>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<%= request.getContextPath() %>/js/jquery-1.10.2.min.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.bundle.js"></script>
<script	src="<%=request.getContextPath()%>/js/jqueryUI/jquery-ui.min.js"></script>
<script	src="<%=request.getContextPath()%>/js/jquery.validate.js"></script>
