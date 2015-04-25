<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="javax.script.*"%>
<%@page import="java.io.IOException"%>
<%@include file="header.jsp" %>

<html>
<head>
<title>Meal Planner</title>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="css/mp.css">
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="css/search.css">
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<script type="text/javascript" src="js/mealplan.js"></script>
</head>
<body>
<%if(session.getAttribute("username") == null){
	response.sendRedirect("login.jsp");
}
	 %>
 
<div class="container-fluid">

    <div class="col-sm-8">
	<form action="savedPlan.jsp" method="POST">

<%
    
    XMLParser writeX = new XMLParser();
    ArrayList<MealPlanner> readmeals = new ArrayList<MealPlanner>();
    
    if(writeX.readMealPlans(getServletContext().getRealPath("") + "/mealplans.xml") != null){
    readmeals = writeX.readMealPlans(getServletContext().getRealPath("") + "/mealplans.xml");
    
    for(MealPlanner p: readmeals){
	       if ((Integer)session.getAttribute("ID") != p.getUserId()){
	    	   
	    	   ArrayList<Meal> meals = new ArrayList<Meal>();
	          meals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");%>
	          
	           <div id="add">
	           <div class="result-entry"><span class="product-name">
	        	 <select id="ing"> <option selected></option> 
	        	 <%   for(Meal m: meals){%>
	        	    	<option> <%=m.getName() %></option>
	        	   <% } %></select> </span> 
	        	   
	               <span class="button-add"><i class="fa fa-plus"></i></span>
	                    
	                    <input  id="ingred" type="hidden" name="ingred" value="">
	                </div>    
	                    <p id="ingredients"></p> 
                     </div>
	    			  
	    			   <%}else{%>
          <%
          
          for(MealPlanner m: readmeals){
   	       if ((Integer)session.getAttribute("ID") == m.getUserId()){
   	    	   if (m.getMeal(0, 0)!=null){%>
   	    	   
   	    	<div id="remove">
   	    	
   	    	   <div class="result-entry">
                        <span class="product-name"><%=m.getMeal(0,0).getName()%>
                        </span>
                      <span class="button-remove"><i class="fa fa-times"></i></span>
                </div>
   	    	</div>
         
   	       
   	   <% }else{
   	   ArrayList<Meal> meals = new ArrayList<Meal>();
       meals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");%>
   
       <div id="add">
    	  <div class="result-entry"><span class="product-name">
	        	 <select id="ing"> <option selected></option> 
	        	 <%   for(Meal n: meals){%>
	        	    	<option> <%=n.getName() %></option>
	        	   <% } %></select> </span> 
	        	   
	               <span class="button-add"><i class="fa fa-plus"></i></span>
	               </div>
                
                <input  id="ingred" type="hidden" name="ingred" value="">
                <p id="ingredients"></p> 
 </div>
			 
   	   <%}
   	    	   } }}}}
    else{ %>
    

<%  ArrayList<Meal> meals = new ArrayList<Meal>();
meals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");%>

<div id="add">
	  <div class="result-entry"><span class="product-name">
	        	 <select id="ing"> <option selected></option> 
	        	 <%   for(Meal l: meals){%>
	        	    	<option> <%=l.getName() %></option>
	        	   <% } %></select> </span> 
	        	   
	               <span class="button-add"><i class="fa fa-plus"></i></span>
   </div>
         
         </div>
           <%} %>
		
	

	<br>
    <input type="submit" class="btn btn-block btn-success btn-lg"
							style="width: 150px" value="Save Meal Plan" /></form>
    </div>
    <div >
</div>
    </div>

</body>
</html>
