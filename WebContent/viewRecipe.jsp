<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="java.io.FileWriter" %>
<%@page import="java.util.Arrays" %>
<%@ page language="java" contentType="text/html" %>
<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.io.Writer"%>
<%@page import="java.nio.charset.Charset"%>
<%@include file="header.jsp" %>

<html>
<head>
<title>Saving Meal</title>
</head>

<body>

 <%
 
 
  XMLParser writeX = new XMLParser();
  ArrayList<Meal> readmeals = new ArrayList<Meal>();
  String name= request.getParameter("currentmeal");
  Meal themeal = writeX.getMeal(readmeals, name);
  System.out.println(name);
  String s = themeal.toString();
  System.out.println(s); 
 
	
 
 %>
    	
<%-- Ingredients:
<br><%for (int i=0; i< currentMeal.getIngredients().size();i++){
	                %>
	                <%=currentMeal.getIngredients().get(i).getName()%>
	                <%=currentMeal.getMasses().get(i)%>
	                <br>
	                <% }%> --%>


 	
</body>
</html>
