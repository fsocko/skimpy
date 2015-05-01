<%@page import="BusinessLogic.*"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Arrays.*" %>
<%@ page language="java" contentType="text/html" %>


<html>
<head>
<title>Shopping List</title>
</head>
<meta http-equiv="refresh" content="0; url=http://localhost:8080/Skimpy/usermealplan.jsp" />
<body>

 	 <% 
   	if(session.getAttribute("username") == null){
 		response.sendRedirect("login.jsp");
 		return;
 	}

 	int userID = (Integer)session.getAttribute("ID");
 	XMLParser writeX = new XMLParser();
 	MealPlanner plan = new MealPlanner(userID);
 	ArrayList<Meal> readmeals = new ArrayList<Meal>();
 	ArrayList<MealPlanner> plans = new ArrayList<MealPlanner>();
 	NutritionOptimisation nutritionUpdate = (NutritionOptimisation)session.getAttribute("sessionNutrition");
    
     if (writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml") != null){
    	readmeals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
    } 

 	 
 	 for (int i = 0; i < 3;  i++){
 		 for (int j = 0; j < 7; j++){
 		   Meal themeal = null;
 		   String s = request.getParameter("meal"+j+""+i).replace(";","");
 		   themeal = writeX.getMeal(readmeals, s);
 	       if (themeal!= null){
	 	       plan.add(themeal, j, i);
 	       }
 		 }
 	 }
 	 
 	 
 	 plans.add(plan);
 	 writeX.writeMealPlans(plans, getServletContext().getRealPath("") + "/mealplans.xml");
 	 
 	 
 	 
 	 nutritionUpdate.setMealPlan(plan);
 	 session.setAttribute("sessionNutrition", nutritionUpdate);
 	 session.setAttribute("mealPlan", plan);
 	 session.setAttribute("hasMealPlan", new Boolean(true));
 	 
 	 %>	
    
    
    
</body>
</html>
