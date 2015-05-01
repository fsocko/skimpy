<% String pageTitle = "Edit Recipe"; %>
<% String currentPage = "explorer"; %>

<%@page import="BusinessLogic.*"%>
<%@page import="java.util.ArrayList" %>>
<%@ page language="java" contentType="text/html" %>
<%@include file="header.jsp" %>
<%@page import="java.io.IOException" %>
<%@page import="java.nio.file.Files" %>
<%@page import="java.nio.file.Path" %>
<%@page import="java.nio.file.Paths" %>
<%@page import="java.nio.file.NoSuchFileException" %>
<%@page import="java.nio.file.DirectoryNotEmptyException" %>

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
	
 	        String MealName = request.getParameter("mealname");
    		XMLParser writeX = new XMLParser();
    		ArrayList<Meal> readmeals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
    		Meal exists= writeX.getMeal(readmeals, MealName);
    		readmeals.remove(exists);
    		MealPlanner sessionplan = (MealPlanner)session.getAttribute("mealPlan");
    		
    		if (readmeals.size()<1){
    			Path p = Paths.get(getServletContext().getRealPath("") + "/meals.xml");
    			try {
    			    Files.delete(p);
    			} catch (NoSuchFileException x) {
    			    System.err.format("%s: no such" + " file or directory%n", getServletContext().getRealPath("") + "/meals.xml");
    			} catch (DirectoryNotEmptyException x) {
    			    System.err.format("%s not empty%n",getServletContext().getRealPath("") + "/meals.xml");
    			} catch (IOException x) {
    			    // File permission problems are caught here.
    			    System.err.println(x);
    			}
    			
    			
    		}else{
    		
    	    writeX.writeMeals(readmeals, getServletContext().getRealPath("") + "/meals.xml");}
    		
    		
    		
    		boolean flag = (boolean)session.getAttribute("hasMealPlan");
			if(flag){
				 for(int i=0; i<3; i++){
					   for(int j=0; j<7; j++){
						   
						   if(sessionplan.getMeal(j,i) != null){
							   String name  = sessionplan.getMeal(j,i).getName();
			   		           if(name.equals(exists.getName())){
			   			
			   			       sessionplan.add(null, j, i);
			   		
		    			} 
		  			}
		  		} 
	  		 }
		}
    	    
    	
    	    %>

 	
</body>
</html>
