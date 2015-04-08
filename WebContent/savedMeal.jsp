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
 	    String MealName = request.getParameter("mealname");
	    String [] Ingredients =  request.getParameterValues("ingred");
        String ingredients = java.util.Arrays.deepToString(Ingredients);
        DBConnect con = new DBConnect();
    	
    		ArrayList<Food> f_ingredients = new ArrayList<Food>();
    		for (int i =1; i<7;i++){
    		f_ingredients.add(con.pullFood("tesco", Integer.toString(i))); }
    		
    		Meal currentMeal = new Meal(MealName, f_ingredients); 
    		ArrayList<Meal> meals = new ArrayList<Meal>();
    		meals.add(currentMeal);
    		XMLParser writeX = new XMLParser();
    	    writeX.writeMeals(meals, getServletContext().getRealPath("") + "/meals.xml");
   %>
        <%=ingredients %>
        <%=currentMeal.toString() %>
        <%=MealName %>
        
 
 	<p>Go back if you want to make some changes or click 
 	"Get Prices" button to get prices comparison and the best deal!
 	</p><input type="button" name="MealPlan" 
 	value="Go Back" onclick="javascript:history.go(-1)">
 	<input type="button" name="PComp" value="Get Prices" onclick="document.location.href='Price.jsp'">
 	<input type="button" name="PComp" value="Go to MealPlanner" onclick="document.location.href='MealPlan.jsp'">
 	<input type="button" value="Log Out" onclick="document.location.href='logout.jsp'">
</body>
</html>
