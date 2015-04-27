<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="javax.script.*"%>
<%@page import="java.io.IOException"%>
<% String pageTitle = "Recipe Explorer"; %>
<% String currentPage = "explorer"; %>
<%@include file="header.jsp"%>

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
		<p>You haven't created any recipes yet.</p>
		<a href="recipe.jsp" class="btn btn-block btn-success btn-lg"
			style="width: 160px">Create a Recipe</a>
	</div>
	<% 
       }else{
       readmeals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
    	for(Meal m: readmeals){%>
	<form action="viewRecipe.jsp" method="post">
		<button style="width: 40%;" class="btn btn-block btn-success btn-lg"
			type="submit"><%=m.getName()%></button>
		<input name="name" type="hidden" value="<%=m.getName()%>">
	</form>
	<% } }%>

	<br>

</div>
</body>
</html>
