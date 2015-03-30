<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "java.util.List" %>
<%@page import = "java.util.Arrays" %>
<%@page import = "java.util.Iterator" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="javax.script.*"%>
<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>  
<script type="text/javascript" src="js/jPaginate.js"></script>  
<script>  
$(document).ready(function(){  
    $("#content").jPaginate();                         
});  
</script>  
</head>
<body>

	 <% String ing =  request.getParameter("ingreds");
	    String [] ings = ing.split(";");
	 for(int i=0; i <ings.length;i++ ){
	
        DBConnect con = new DBConnect();
        ArrayList<Food> foods = new ArrayList<Food>();
        foods= con.search("tesco", ings[i] );
        String[] names= new String[foods.size()];
        Iterator<Food> iterator = foods.iterator();
        while (iterator.hasNext()) {
        	for (int j=0; j<foods.size(); j++){
  	    	names[j]= iterator.next().getName();}
  	      } %>
       <%=ings[i].toUpperCase() %>
        <div id='content'> <% 
      for(int n=0; n<names.length; n++){%>
        	<p><%=names[n] %></p>
        <%}%>
       </div>
    <%}%>
</body>
</html>