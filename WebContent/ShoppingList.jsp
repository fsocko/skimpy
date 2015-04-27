<% String pageTitle = "Shopping List"; %>
<% String currentPage = "shopping_list"; %>

<%@page import="java.util.*" %>
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
 	 int userId = (Integer)session.getAttribute("ID");
 	 ShoppingList list = new ShoppingList();
 	 String path = getServletContext().getRealPath("");
 	
 	 HashMap <Food, Double> shoppingList = list.getShoppingList(path, userId);
 	 

     if (shoppingList != null){   
 	 
 	for (Map.Entry<Food, Double> entry : shoppingList.entrySet())
 	{%>
 	    <%=entry.getKey().getName() %> <%=entry.getValue()%> <br>
 	<% }
     }else{
    	 System.out.println("S L EMPTY");
     }
     
 	 
 	 
 	 
 	 
       %>
       
</div>
</div>       
</body>
</html>
