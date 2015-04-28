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
 	
 	HashMap<ArrayList<Food>, ArrayList<Double>> shoppingList = list.getShoppingList(path, userId);

 	ArrayList<Food> foodList = new ArrayList<Food>();
 	ArrayList<Double> massList = new ArrayList<Double>();

     if (shoppingList != null){   
 	 
 	for (Map.Entry<ArrayList<Food>, ArrayList<Double>> entry : shoppingList.entrySet()){
 	
 	    foodList = entry.getKey(); 
 	    massList = entry.getValue(); 
 	    
 	}
 	    
 	
 	
 	for (int i=0; i<foodList.size(); i++){%>
 		
 	 	<%=foodList.get(i).getName() %>
 	 	
 	 	<%= massList.get(i)%> <br>
 	 		
 	 	<% }	
 		
 	
 	
 	
 	    
     }else{%>
    	You haven't created a meal plan yet.
     <%}
       %>
       
</div>
</div>       
</body>
</html>
