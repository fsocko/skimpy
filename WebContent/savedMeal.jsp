
<% String pageTitle = "Edit Meal Plan"; %>
<% String currentPage = "explorer"; %>


<%@page import="BusinessLogic.*"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html" %>
<%@include file="header.jsp" %>

<html>
<head>
<title>Saving Meal</title>
</head>
<meta http-equiv="refresh" content="0; url=http://localhost:8080/Skimpy/recipeExplorer.jsp" />
<body>

 <%  	

		if(session.getAttribute("username") == null){
			response.sendRedirect("login.jsp");
			return;
		}

        DBConnect con = new DBConnect();
 
        XMLParser writeX = new XMLParser();
	    ArrayList<Meal> readmeals = new ArrayList<Meal>();
	    ArrayList<MealPlanner> plans = new ArrayList<MealPlanner>();
	    String path = getServletContext().getRealPath("");
	    int userID = (Integer)session.getAttribute("ID");
	    MealPlanner sessionplan = (MealPlanner)session.getAttribute("mealPlan");
 
 
 	    String MealName = request.getParameter("mealname");
	    
	    int servings = Integer.valueOf(request.getParameter("servings"));
	    
	    String  Shops =  request.getParameter("supermarket");
	    ArrayList<String> shopList = new ArrayList<String>();
	    
	    if(Shops!=""){
	    for(String s: Shops.split(";")){
	    	shopList.add(s);
	    	
	     }
	    }
	    
	    String ShopIds =  request.getParameter("ingred");
	    ArrayList<String> idList = new ArrayList<String>();
	    
	    if(ShopIds!=""){
	    for(String s: ShopIds.split(";")){
	    	idList.add(s);
	      }
	    }
	    
	    String [] Servings =  request.getParameterValues("mass");
	    ArrayList<Double> massList = new ArrayList<Double>();
	    
	    if(Servings!=null){
	    for(String s: Servings){
	    
	    try{
	    	massList.add(Double.parseDouble(s));
	    	
	    }
	  
	    catch(NumberFormatException e){
	    	
	    	
		    	if(s.replaceAll("[^.0-9]","").trim().equals("")){
		    		massList.add(Double.parseDouble("0"));
		    		}else{
	    	
	        		 massList.add(Double.parseDouble(s.replaceAll("[^.0-9]","").trim()));
	    	
	    		   }
		    	}  
	   		 }
	     }
        
       

        
    	
    		ArrayList<Food> f_ingredients = new ArrayList<Food>();
    		for (int i =0; i<shopList.size();i++){
    			
    		  		f_ingredients.add(con.pullFood(shopList.get(i), idList.get(i)));
    		  }
    		
    		
    		Meal currentMeal = new Meal(MealName, f_ingredients, massList, servings );
    		
    		
    		
    		
    		
    		if (writeX.readMeals(path + "/meals.xml")!=null){
    			readmeals = writeX.readMeals(path + "/meals.xml");
    		
    			Meal exists = null;
    			
    			if( writeX.getMeal(readmeals, MealName) != null){
    			 		exists= writeX.getMeal(readmeals, MealName);
    			 		readmeals.remove(exists);
    			 	}
    		
    		
    	    		readmeals.add(currentMeal);
    	    		writeX.writeMeals(readmeals, path + "/meals.xml");
    	    	}
    		
    		else{
    			readmeals.add(currentMeal);
    			writeX.writeMeals(readmeals, path + "/meals.xml");
    			};
    	    
    	    
    			boolean flag = (boolean)session.getAttribute("hasMealPlan");
    			if(flag){
    				 for(int i=0; i<3; i++){
    					   for(int j=0; j<7; j++){
    						   
    						   if(sessionplan.getMeal(j,i) != null){
    							   String name  = sessionplan.getMeal(j,i).getName();
    			   		           if(name.equals(currentMeal.getName())){
    			   			
    			   			       sessionplan.add(currentMeal, j, i);
    			   		
    		    		  } 
    		  		   }
    		  		} 
    	  		 }
    		  }
    	    
    	    
    	    
    	    %>

 	
</body>
</html>
