<% String pageTitle = "Meal Plan"; %>
<% String currentPage = "meal_plan"; %>
<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="javax.script.*"%>
<%@page import="java.io.IOException"%>
<%@include file="header.jsp" %>

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

XMLParser writeX = new XMLParser();
ArrayList<MealPlanner> readmeals = new ArrayList<MealPlanner>();

ArrayList<Meal> meals = new ArrayList<Meal>();
meals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");

if (meals != null){
	 %>
 
<div class="container-fluid">
<div class="col-sm-8">
    <div>
	<form action="savedPlan.jsp" method="POST">
	<table>
	<tr><th style="text-align:center;">Monday</th>
	<th style="text-align:center;">Tuesday</th>
	<th style="text-align:center;">Wednesday</th>
	<th style="text-align:center;">Thursday</th>
	<th style="text-align:center;">Friday</th>
	<th style="text-align:center;">Saturday</th>
	<th style="text-align:center;">Sunday</th></tr>
        <%for (int i = 0; i < 3; i++) {%>
		<tr >
			<%for (int j = 0; j < 7; j++) {
    
    if(writeX.readMealPlans(getServletContext().getRealPath("") + "/mealplans.xml") != null){
    	readmeals = writeX.readMealPlans(getServletContext().getRealPath("") + "/mealplans.xml");
    
    	for(MealPlanner p: readmeals){
	       if ((Integer)session.getAttribute("ID") != p.getUserId()){
	    	   
	    	   %>
	           <td align="center" width="250px">
	           <div id="cell<%=j%><%=i %>">
	           <div class="result">
	           <span class="product">
	           <select class="select" id="ing<%=j%><%=i %>"> <option selected></option> 
	        	<%   for(Meal m: meals){%>
	        	    	<option> <%=m.getName() %></option>
	        	   <% } %></select> </span> 
	           <span class="button-add-plan"><i class="fa fa-plus"></i></span>
	           <input name="meal<%=j%><%=i %>" id="meal" class="meal" type="hidden">
                     </div>
                     <div id="add-item"></div>
                     </div>
	    			   </td>
	    			   <%}else{%>
          <%
          
          for(MealPlanner m: readmeals){
   	       if ((Integer)session.getAttribute("ID") == m.getUserId()){
   	    	   if (m.getMeal(j, i)!=null){%>
   	    	   <td align="center" width="250px">
   	    	<div id="cell<%=j%><%=i %>">
   	    	   
   	    	   <div class="result" style="display:none;">
   	    	   <span class="product">
   	    	   
	        	 <select class="select" id="ing<%=j%><%=i %>"> <option selected></option> 
	        	 <%   
	        	
	        	 for(Meal k: meals){%>
	        	    	<option> <%=k.getName() %></option>
	        	   <% } %></select> </span> 
   	    	   <span class="button-add-plan"><i class="fa fa-plus"></i></span>
   	    	    <input name="meal<%=j%><%=i %>" id="meal" class="meal" type="hidden" value="<%=m.getMeal(j,i).getName()%>">
	        	   </div>
   	    	   
   	    	 <div id="add-item">
   	    	     <div class="result-entry">
                        <span class="product-name-plan"><%=m.getMeal(j,i).getName()%>
                        </span>
                       <span class="button-remove-plan"><i class="fa fa-times"></i></span>
                </div>
                </div>
               </div>
             </td>
   	       
   	   <% }else{%>
       <td align="center" width="250px">
       <div id="cell<%=j%><%=i %>">
    	  <div class="result">
    	   <span class="product">
	        	 <select class="select" id="ing<%=j%><%=i %>"> <option selected></option> 
	        	 <%   for(Meal n: meals){%>
	        	    	<option> <%=n.getName() %></option>
	        	   <% } %></select> </span> 
    	  <span class="button-add-plan"><i class="fa fa-plus"></i></span>
    	  <input name="meal<%=j%><%=i %>" id="meal" class="meal" type="hidden">
	        	   </div>
	        	   <div id="add-item"></div>
                 </div>
			   </td>
   	   <%}
   	    	   } }}}}
    else{ %>
   
<td align="center" width="250px">
<div id="cell<%=j%><%=i %>">
	  <div class="result">
	  <span class="product">
	        	<select class="select" id="ing<%=j%><%=i %>"> <option selected></option> 
	        	 <%   for(Meal n: meals){%>
	        	    	<option> <%=n.getName() %></option>
	        	   <% } %></select> </span> 
	  <span class="button-add-plan"><i class="fa fa-plus"></i></span>
	  <input name="meal<%=j%><%=i %>" id="meal" class="meal" type="hidden">
	               
   </div>
         <div id="add-item"></div>
        
         </div>
           <% %>
		   </td>
			<%}}%>
		</tr> 
		<%}%>
	</table>
	<br>
    <input type="submit" class="btn btn-block btn-success btn-lg"
							style="width: 150px" value="Save Meal Plan" /></form>
							
	<%}else{%>
	
	<div class="col-sm-4">
    	   <p>
    	   You haven't created any recipes yet.</p>
    	   <a href = "recipe.jsp" class="btn btn-block btn-success btn-lg"
							style="width: 160px">Create a Recipe</a>
    	   </div>						
	<%} %>
							
    				</div>
    			<div >
			</div>
    	</div>
    </div>

</body>
</html>
