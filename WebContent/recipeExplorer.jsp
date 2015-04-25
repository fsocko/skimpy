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
<title>Recipes</title>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="css/mp.css">

</head>
<body>
<%if(session.getAttribute("username") == null){
	response.sendRedirect("login.jsp");
}
	 %>
 <div class="container-fluid">
                 <%        
       XMLParser writeX = new XMLParser();
       ArrayList<Meal> readmeals = new ArrayList<Meal>();
       
       if(writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml") == null){
    	   %>
    	   <div class="col-sm-4">
    	   <p>
    	   You haven't created any recipes yet.</p>
    	   <a href = "recipe.jsp" class="btn btn-block btn-success btn-lg"
							style="width: 160px">Create a Recipe</a>
    	   </div>
    	   <% 
       }else{
       readmeals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
    	for(Meal m: readmeals){%>
    	         <form action="viewRecipe.jsp" method="post">
    	    	<button style="width:40%;" class="btn btn-block btn-success btn-lg" type="submit" ><%=m.getName()%></button>
    	    	<input name="name" type="hidden" value="<%=m.getName()%>">
    	    	</form>
    	   <% } }%>

	<br>
   
</div>
</body>
</html>
