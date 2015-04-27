<% String pageTitle = "Shopping List"; %>

<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.io.FileWriter" %>
<%@page import="java.util.Arrays.*" %>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.io.Writer"%>
<%@page import="java.nio.charset.Charset"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.File"%>
<%@include file="header.jsp" %>
<body>
<%if(session.getAttribute("username") == null){
	response.sendRedirect("login.jsp");
}
	 %>

<p>Here's the list of ingredients you need for this week:</p>
 	 <%
 	 
 	 
 	 
 	 XMLParser writeX = new XMLParser();
 	 
     ArrayList<MealPlanner> readmeals = new ArrayList<MealPlanner>();
     if(writeX.readMealPlans(getServletContext().getRealPath("") + "/mealplans.xml") != null){
     readmeals = writeX.readMealPlans(getServletContext().getRealPath("") + "/mealplans.xml");
     for(MealPlanner m: readmeals){
    	 if ((Integer)session.getAttribute("ID") == m.getUserId()){
     
    		     MealPlanner plan = m;
    		     ArrayList<ArrayList<Food>> shoppingList = plan.getShoppingList();
    		   
    	 
    	 }else{
    	 %>"NO FOOD"<%
    	
        }
     }
     
			
     
     }else{%>
     
     
     "NO FOOD"
     <%}
     
     
     %>
</body>
</html>
