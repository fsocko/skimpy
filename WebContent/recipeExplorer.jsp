<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="javax.script.*"%>
<%@page import="java.io.IOException"%>
<%@include file="header.jsp" %>

<html>
<head>
<title>Recipes</title>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="css/mp.css">

</head>
<body>
<%if(session.getAttribute("username") == null){
	response.sendRedirect("login.jsp");
}
	 %>
 <div id="MP">
                 <%        
       XMLParser writeX = new XMLParser();
       ArrayList<Meal> readmeals = new ArrayList<Meal>();
       readmeals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
    	 
    	 for(Meal m: readmeals){
    	 session.setAttribute("name", m.getName());%>
    	         
    	    	<a href="viewRecipe.jsp"> <%=m.getName()%></a>
    	    	 <br>
    	   <% } %>

	<br>
   
</div>>
</body>
</html>
