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
<html>
<head>
<title>Shopping List</title>
</head>
<body>
<p>Here's the list of ingredients you need for this week:</p>
 	 <% 
 	 int userID = (Integer)session.getAttribute("ID"); 
 	 MealPlanner plan = new MealPlanner(userID);
 	 
 	XMLParser writeX = new XMLParser();
    ArrayList<Meal> readmeals = new ArrayList<Meal>();
    readmeals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
    String name= request.getParameter("ingred00").replace(";","");
    //Meal themeal = writeX.getMeal(readmeals, name);
    //System.out.println(name);
    //String s = themeal.toString();
    //System.out.println(s);
    
 	 
 	 for (int i = 0; i < 3;  i++){
 		 for (int j = 0; j < 7; j++){
 		   Meal themeal = null;
 		   String s = request.getParameter("ingred"+j+""+i).replace(";","");
 		   System.out.println(s);
 	       themeal = writeX.getMeal(readmeals, s);
 	       if (themeal!= null){
 	       String m = themeal.toString();
 	       System.out.println(m);
 			plan.add(themeal, j, i);}
 		 }
 	 }
 	 ArrayList<MealPlanner> plans = new ArrayList<MealPlanner>();
 	 
 	 plans.add(plan);
 	 
 	 System.out.println(plan.toString());
 	 writeX.writeMealPlans(plans, getServletContext().getRealPath("") + "/mealplans.xml");
 	 
 	System.out.println(getServletContext().getRealPath("") + "/mealplans.xml");
 	 
 	 
 	 %>	
    
    
    
</body>
</html>
