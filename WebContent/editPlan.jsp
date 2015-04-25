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

    <div>
	<form action="savedPlan.jsp" method="POST">
	<table border="1" style="text-align:center; width:100px;">
	<tr><th>Monday</th>
	<th>Tuesday</th>
	<th>Wednesday</th>
	<th>Thursday</th>
	<th>Friday</th>
	<th>Saturday</th>
	<th>Sunday</th></tr>
        <%for (int i = 0; i < 3; i++) {%>
		<tr >
			<%for (int j = 0; j < 7; j++) {
    
    XMLParser writeX = new XMLParser();
    ArrayList<MealPlanner> readmeals = new ArrayList<MealPlanner>();
    
    ArrayList<Meal> meals = new ArrayList<Meal>();
    meals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
    
    
    if(writeX.readMealPlans(getServletContext().getRealPath("") + "/mealplans.xml") != null){
    readmeals = writeX.readMealPlans(getServletContext().getRealPath("") + "/mealplans.xml");
    
    for(MealPlanner p: readmeals){
	       if ((Integer)session.getAttribute("ID") != p.getUserId()){
	    	   
	    	   %>
	           <td align="center" width="100px">
	           <div id="cell<%=j%><%=i %>">
	           <div class="result">
	           
	           <span class="button-add-plan"><i class="fa fa-plus"></i></span>
	           <span class="product">
	        	 <select class="select" id="ing<%=j%><%=i %>"> <option selected></option> 
	        	 <%   for(Meal m: meals){%>
	        	    	<option> <%=m.getName() %></option>
	        	   <% } %></select> </span> 
	        	   
	               
	                    
	                    <input name="meal<%=j%><%=i %>" id="meal" class="meal" type="hidden">
                     </div>
                     </div>
	    			   </td>
	    			   <%}else{%>
          <%
          
          for(MealPlanner m: readmeals){
   	       if ((Integer)session.getAttribute("ID") == m.getUserId()){
   	    	   if (m.getMeal(j, i)!=null){%>
   	    	   <td align="center" width="100px">
   	    	<div id="cell<%=j%><%=i %>">
   	    	   
   	    	   <div class="result" >
   	    	   <span class="button-add-plan"><i class="fa fa-plus"></i></span>
   	    	   <span class="product">
   	    	   
	        	 <select class="select" id="ing<%=j%><%=i %>"> <option selected></option> 
	        	 <%   
	        	
	        	 for(Meal k: meals){%>
	        	    	<option> <%=k.getName() %></option>
	        	   <% } %></select> </span> 
	        	   
	               
	               </div>
   	    	   
   	    	
   	    	     <div class="result-entry">
                        <span class="product-name"><%=m.getMeal(j,i).getName()%>
                        </span>
                        
                      <span class="button-remove"><i class="fa fa-times"></i></span>
                </div>
                <input name="meal<%=j%><%=i %>" id="meal" class="meal" type="hidden" value="<%=m.getMeal(j,i).getName()%>">
   	    	</div>
             </td>
   	       
   	   <% }else{%>
       <td align="center" width="100px">
       <div id="cell<%=j%><%=i %>">
    	  <div class="result">
    	  <span class="button-add-plan"><i class="fa fa-plus"></i></span>
    	  <span class="product">
	        	 <select class="select" id="ing<%=j%><%=i %>"> <option selected></option> 
	        	 <%   for(Meal n: meals){%>
	        	    	<option> <%=n.getName() %></option>
	        	   <% } %></select> </span> 
	        	   
	               
	               </div>
                
               <input name="meal<%=j%><%=i %>" id="meal" class="meal" type="hidden">
 </div>
			   </td>
   	   <%}
   	    	   } }}}}
    else{ %>
   
<td align="center" width="100px">
<div id="cell<%=j%><%=i %>">
	  <div class="result">
	  <span class="button-add-plan"><i class="fa fa-plus"></i></span>
	  <span class="product">
	        	 <select class="select" id="ing<%=j%><%=i %>"> <option selected></option> 
	        	 <%   for(Meal l: meals){%>
	        	    	<option> <%=l.getName() %></option>
	        	   <% } %></select> </span> 
	        	   
	               
   </div>
         
        <input name="meal<%=j%><%=i %>" id="meal" class="meal" type="hidden">
         </div>
           <%} %>
		   </td>
			<%}%>
		</tr> 
		<%}%>
	</table>
	<br>
    <input type="submit" class="btn btn-block btn-success btn-lg"
							style="width: 150px" value="Save Meal Plan" /></form>
    </div>
    <div >
</div>
    </div>

</body>
</html>
