<% String pageTitle = "Meal Planner"; %>
<% String currentPage = "meal_plan"; %>

<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="javax.script.*"%>
<%@page import="java.io.IOException"%>
<%@include file="header.jsp" %>

<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="css/mp.css">
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="css/search.css">

</head>
<body>

<div class="container-fluid">

    <div class="col-sm-8">
<%if(session.getAttribute("username") == null){
	response.sendRedirect("login.jsp");
}
	 %>
<%  
    
    XMLParser writeX = new XMLParser();
    ArrayList<MealPlanner> readmeals = new ArrayList<MealPlanner>();
    
    if(writeX.readMealPlans(getServletContext().getRealPath("") + "/mealplans.xml") != null){
    readmeals = writeX.readMealPlans(getServletContext().getRealPath("") + "/mealplans.xml");
    
    for(MealPlanner p: readmeals){
	       if ((Integer)session.getAttribute("ID") != p.getUserId()){
	    	   %>
	<div id="MP">       
    <p>
     <button class="btn btn-block btn-success btn-lg" style="width: 170px" onclick="document.location.href='editPlan.jsp'">Create a Meal Plan</button>
    </p>
    	
    <% }else{%>
    

    
	<table >
	<tr><th style="text-align:center;">Monday</th>
	<th style="text-align:center;">Tuesday</th>
	<th style="text-align:center;">Wednesday</th>
	<th style="text-align:center;">Thursday</th>
	<th style="text-align:center;">Friday</th>
	<th style="text-align:center;">Saturday</th>
	<th style="text-align:center;">Sunday</th></tr>
        <%for (int i = 0; i < 3; i++) {%>
		<tr >
			<%for (int j = 0; j < 7; j++) {%>
           <td align="center" width="250px">
           <%for(MealPlanner m: readmeals){
    	       if ((Integer)session.getAttribute("ID") == m.getUserId()){
    	    	   if (m.getMeal(j, i)!=null){%>
    	    	   
    	    	   <form action="viewRecipe.jsp" method="post">
    	    	<button style="width:100%;" class="btn pull-right btn-primary btn-md"  type="submit" ><%=m.getMeal(j,i).getName()%> </button>
    	    	<input name="name" type="hidden" value="<%=m.getMeal(j,i).getName() %>">
    	    	</form>
    	       
    	   <% }else{%>
    	   <br>
    	   <%}
    	    	   } }%>
          </td>
		<%}%>
		</tr> 
		<%}%>
	</table>
	<br>
	
    <button class="btn btn-block btn-success btn-lg" style="width: 150px" onclick="document.location.href='editPlan.jsp'">Edit Meal Plan</button>
    </div>
    <%} } }
    else{ %>
    
<p>
<button class="btn btn-block btn-success btn-lg" style="width: 150px" onclick="document.location.href='editPlan.jsp'">Create a Meal Plan</button>
</p>
	
<% 
    }%>
    <div >
    </div>
    </div>
    </div>
</body>
</html>
