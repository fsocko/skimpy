
<% String pageTitle = "Edit Meal Plan"; %>
<% String currentPage = "explorer"; %>


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
<meta http-equiv="refresh" content="0; url=http://localhost:8080/Skimpy/recipeExplorer.jsp" />
<body>

 <%  
 	    String MealName = request.getParameter("mealname");
	    String  Shops =  request.getParameter("supermarket");
	    int servings = Integer.valueOf(request.getParameter("servings"));
	    ArrayList<String> shopList = new ArrayList<String>();
	    for(String s: Shops.split(";")){
	    	shopList.add(s);
	    	
	    }
	    String ShopIds =  request.getParameter("ingred");
	    ArrayList<String> idList = new ArrayList<String>();
	    for(String s: ShopIds.split(";")){
	    	idList.add(s);
	    	
	    }
	    
	    String [] Servings =  request.getParameterValues("mass");
	    ArrayList<Double> massList = new ArrayList<Double>();
	    
	   
	    for(String s: Servings){
	    
	    try{
	    	massList.add(Double.parseDouble(s));
	    	
	    }
	  
	    catch(NumberFormatException e){
	    	
	    	
		    	if(s.replaceAll("[^.0-9]","").trim().equals("")){
		    		massList.add(Double.parseDouble("0"));
		    		}else{
	    	
	        		 massList.add(Double.parseDouble(s.replaceAll("[^.0-9]","").trim()));
	    	
	    }}  }
        
        String masses = java.util.Arrays.deepToString(Servings);

        DBConnect con = new DBConnect();
    	
    		ArrayList<Food> f_ingredients = new ArrayList<Food>();
    		for (int i =0; i<shopList.size();i++){
    			
    		  f_ingredients.add(con.pullFood(shopList.get(i), idList.get(i)));
    		  }
    		
    		
    		Meal currentMeal = new Meal(MealName, f_ingredients, massList, servings );
    		ArrayList<Meal> meals = new ArrayList<Meal>();
    		meals.add(currentMeal);
    		
    		XMLParser writeX = new XMLParser();
    		ArrayList<Meal> readmeals = new ArrayList<Meal>();
    		
    		if (writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml")!=null){
    		readmeals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
    		
    		Meal exists = null;
    		 if( writeX.getMeal(readmeals, MealName) != null){
    			 exists= writeX.getMeal(readmeals, MealName);
    			 readmeals.remove(exists);
    		 }
    		
    		
    	    readmeals.add(currentMeal);
    	    writeX.writeMeals(readmeals, getServletContext().getRealPath("") + "/meals.xml");
    	    }
    		else{
    		writeX.writeMeals(meals, getServletContext().getRealPath("") + "/meals.xml");
    		};
    	    
    	    
    	    
    	    String path = getServletContext().getRealPath("");
    	    
    	    
    	    
    	    String currentname= currentMeal.getName(); 
    	    %>

 	
</body>
</html>
