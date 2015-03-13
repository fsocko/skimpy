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
 	<% MealPlanner plan = CreateMealPlan.create();	
    	ArrayList<ArrayList<Food>> list = plan.getShoppingList();
     	for (int i=0; i < list.size(); i++){
     		 for(Food f : list.get(i)){
			   String item = f.getName() + "<br>"; %>
 	         <%= item  %>
 	<%} %>
 	<%} %>
  	<%  String [][] MealIngredients = new String[21][2];
 	    String [] MealName = request.getParameterValues("mealname");
	    String [] Ingredients =  request.getParameterValues("ingredients");
 	       for (int j=0; j<21; j++){
 	    	  
 		    MealIngredients[j][0]= MealName[j]; 
 		    MealIngredients[j][1]=Ingredients[j];}
 		    
 		String mealIngredients = java.util.Arrays.deepToString(MealIngredients);
    	String mealName = java.util.Arrays.deepToString(MealName);
        String ingredients = java.util.Arrays.deepToString(Ingredients); %>
 	<%--  <% String ingrList = "";
 	    for (int i=0; i<Ingredients.length;i++){
 		    ingrList = Ingredients[i] ; 
 	  %>
 	  <%=ingrList %> <%}%> --%>
 	<%
 	Person user = new Person("Skimpy", "skimpy@skimpy.com", "password",18, 30, 70, 'M', 0);
 	String sRootPath = new File("").getAbsolutePath();
 	String content = mealIngredients;
 	String userID = user.getID() + ".txt";
	File file = new File(userID);

	// if file doesnt exists, then create it
	if (!file.exists()) {
		file.createNewFile();
	}

	FileWriter fw = new FileWriter(file.getAbsoluteFile());
	BufferedWriter bw = new BufferedWriter(fw);
	bw.write(content);
	
	bw.close();%>
 	<p>Go back if you want to make some changes or click 
 	"Get Prices" button to get prices comparison and the best deal!
 	</p><input type="button" name="MealPlan" 
 	value="Go Back" onclick="document.location.href='showBrowser.jsp'">
 	<input type="button" name="PComp" value="Get Prices" onclick="document.location.href='Price.jsp'">
 	<br>
 	<a href="Log out">Log Out </a>
</body>
</html>