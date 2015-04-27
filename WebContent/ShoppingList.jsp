<% String pageTitle = "Shopping List"; %>
<% String currentPage = "shopping_list"; %>


<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Arrays.*" %>
<%@ page language="java" contentType="text/html" %>
<%@page import="java.io.File"%>
<%@include file="header.jsp" %>
<body>
<%if(session.getAttribute("username") == null){
	response.sendRedirect("login.jsp");
}
	 %>
<div class="container-fluid">
<div class="col-sm-8">

 	 <%
 	 XMLParser writeX = new XMLParser();
 	 ArrayList<Meal> readmeals = new ArrayList<Meal>();
     
 	 if(writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml") != null){
     	readmeals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
     		for(Meal m: readmeals){
    	 		
    		     ArrayList<ArrayList<Food>> shoppingList = new ArrayList<ArrayList<Food>>();
    		     shoppingList.add(m.getIngredients()); 
    		     for(int y=0; y < m.getIngredients().size(); y++){%>
    		             <p> <%=m.getIngredients().get(y).getName() %></p>  
    			<% }%>
    	
    <%  } }else{%>
     "NO FOOD"
     <%}
       %>
       
</div>
</div>       
</body>
</html>
