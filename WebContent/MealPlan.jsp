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

<script>
function myFunction(sender) {
	var i = sender.id.split(",")[0];
	var j = sender.id.split(",")[1];
	var searchItem = document.getElementById("ing" + i + "" + j).value;
	document.getElementById("ing" + i + "" + j).value = "";

    
    if (searchItem != "") {
        document.getElementById("ingredients" + i + "" + j).innerHTML += "<a id=" + i + "" + j + " href='#' onclick='reove(this)'>" + searchItem +  " <img src =\"images/delete.png\" height=\"15\" width=\"15\"></br></a>";
        document.getElementById("ingred" + i + "" + j).value = (document.getElementById("ingred" + i + "" + j).getAttribute("value") + searchItem +";");
  
    }
}

function reove(sender) {
	var i = sender.id[0];
	var j = sender.id[1];
	var text = sender.innerHTML;
	text = text.substring(0, text.length - 5);
	document.getElementById("ingred" + i + "" + j).value = document.getElementById("ingred" + i + "" + j).value.replace(";" + text + ";", ";");
	sender.remove();
}


</script>
</head>
<body>
<%if(session.getAttribute("username") == null){
	response.sendRedirect("login.jsp");
}
	 %>

    <div id="MP">
	<form action="savedPlan.jsp" method="POST">
	<table border="1">
	<tr><th>Monday</th>
	<th>Tuesday</th>
	<th>Wednesday</th>
	<th>Thursday</th>
	<th>Friday</th>
	<th>Saturday</th>
	<th>Sunday</th></tr>
        <%for (int i = 0; i < 3; i++) {%>
		<tr >
			<%for (int j = 0; j < 7; j++) {%>
           <td align="center" width="100px">
           
                 <%        
       XMLParser writeX = new XMLParser();
       ArrayList<Meal> readmeals = new ArrayList<Meal>();
       readmeals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");%>
    	 <select id="ing<%=j%><%=i %>"> <option selected></option> 
    	 <%   for(Meal m: readmeals){%>
    	    	<option> <%=m.getName() %></option>
    	   <% } %></select>
           <input  id="<%=j%>,<%=i %>" autocomplete = "off" value="" onclick="myFunction(this)" name = "search" style="border-style: none;
                    background: url(images/add.png) no-repeat; width: 24px; height: 20px;">
          
                
                <input  id="ingred<%=j%><%=i %>" type="hidden" name="ingred<%=j%><%=i%>" value="">
                <p id="ingredients<%=j%><%=i %>"></p> 

			   </td>
			
			<%}%>
		</tr> 
		<%}%>
	</table>
	<br>
    <input type="submit" value="Save Meal Plan" /></form>
    </div>
    <div >

    </div>
</body>
</html>
