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

<html>
<head>
<title>Saving Meal</title>
</head>
<body>

 <%  
 	    String MealName = request.getParameter("mealname");
	    String  Shops =  request.getParameter("supermarket");
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
	    ArrayList<Integer> massList = new ArrayList<Integer>();
	    for(String s: Servings){
	    	massList.add(Integer.parseInt(s));
	    	
	    }
       
        
        String masses = java.util.Arrays.deepToString(Servings);
        int len = shopList.size();
        int lenid = idList.size();
        int lenm = massList.size();
        DBConnect con = new DBConnect();
    	
    		ArrayList<Food> f_ingredients = new ArrayList<Food>();
    		for (int i =0; i<shopList.size();i++){
    			
    		  f_ingredients.add(con.pullFood(shopList.get(i), idList.get(i)));
    		  }
    		
    		
    		Meal currentMeal = new Meal(MealName, f_ingredients, massList ); 
    		System.out.println(currentMeal.toString());
    		//ArrayList<Meal> meals = new ArrayList<Meal>();
    		//meals.add(currentMeal);
    		//XMLParser writeX = new XMLParser();
    	    //writeX.writeMeals(meals, getServletContext().getRealPath("") + "/meals.xml");
    	    //String path = getServletContext().getRealPath("");
    	    //writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
    	    
   %>

 	<p>Go back if you want to make some changes or click 
 	"Get Prices" button to get prices comparison and the best deal!
 	</p><input type="button" name="MealPlan" 
 	value="Go Back" onclick="javascript:history.go(-1)">
 	<input type="button" name="PComp" value="Get Prices" onclick="document.location.href='Price.jsp'">
 	<input type="button" name="PComp" value="Go to MealPlanner" onclick="document.location.href='MealPlan.jsp'">
 	<input type="button" value="Log Out" onclick="document.location.href='logout.jsp'">
</body>
</html>
