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
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
function thisFunction(sender) {
	 
	var item = document.getElementById("ingred").value;
	document.getElementById("ingred").value = "";

    if (item != "") {
        document.getElementById("ingredients").innerHTML += "<a href='#' onclick='reove(this)'>" + item +  " <img src =\"images/delete.png\" height=\"15\" width=\"15\"></br></a>";
        document.getElementById("ingreds").value = (document.getElementById("ingreds").getAttribute("value") + item +";");
  
    }
}

function reove(sender) {
	var text = sender.innerHTML;
	text = text.substring(0, text.length - 5);
	document.getElementById("ingred").value = document.getElementById("ingred").value.replace(";" + text + ";", ";");
	sender.remove();
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>

 
<h3> Welcome, <%=session.getAttribute("username")%> </h3>
<form action="searchRes.jsp" method="post" name="ingred">
	<input id="ingred" type="text" value="Enter a product" name="ingred" >
	<input autocomplete = "off" value="" onclick="thisFunction(this)" name = "search" style="border-style: none;
                    background: url(images/add.png) no-repeat; width: 24px; height: 20px;">
                <input id="ingreds" type="hidden" name="ingreds" value="">
                <p id="ingredients"></p>
	<input type="submit" value="Search">
</form> 

</body>
</html>