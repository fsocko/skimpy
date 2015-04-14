<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="javax.script.*"%>
<%@page import="java.io.IOException"%>

<html>
<head>
<title>Meal Planner</title>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#accordion").accordion({
			active : false,
			collapsible : true
		});
	});
</script>

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

 

/* DBConnect connect = new DBConnect("food_db");
connect.search(searchItem); */
</script>
</head>
<body>
<%  //MealPlanner plan = CreateMealPlan.create();
    //Person user = new Person("Skimpy", "skimpy@skimpy.com", "password", 18, 30, 70, 'M', 0);
    //String userID = user.getID(); %>
    
	<p> Hey <%=session.getAttribute("username") %>, here's a default meal plan for you. Feel free to
		change everything in it or keep it if you like it. Just click on the
		cells you want to alter and enter ingredients so we can create an
		optimised shopping list for you.</p>
    
	<form action="ShoppingList.jsp" method="POST">
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
           <td align="center">
				<%-- <%   String mealname = plan.getMeal(j, i).getName();%> --%>
				<%-- <input type="text" id="mealname<%=j%><%=i %>" size="21" name="mealname" value=" Meal Name " /> --%>
                <input id="ing<%=j%><%=i %>" autocomplete = "on" name="ing" type="text" name="ingredients" style="width:150px;"> 
                <input  id="<%=j%>,<%=i %>" autocomplete = "off" value="" onclick="myFunction(this)" name = "search" style="border-style: none;
                    background: url(images/add.png) no-repeat; width: 24px; height: 20px;">
                <input  id="ingred<%=j%><%=i %>" type="hidden" name="ingred" value=";">
                <p id="ingredients<%=j%><%=i %>"></p>
			   </td>
			
			<%}%>
		</tr> 
		<%}%>
	</table>
	
<div id="accordion">
  <h3>Your daily calories intake:</h3>
  <div>
    <p>
<%--     <%String dayResult = NutritionOptimisation.compareCalories(user, plan);%>
     <%= dayResult %> --%>
    </p>
  </div>
  <h3>Your weekly calories intake:</h3>
  <div>
    <p>
<%-- <%String weekResult = NutritionOptimisation.compareToGDAWeek(user, plan);%>
 	<%= weekResult %> --%>
    </p>
  </div>
  <h3>Items Recommended to you:</h3>
  <div>
    <p>
    Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis.
    Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero
    ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis
    lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
    </p>
    <ul>
      <li>List item one</li>
      <li>List item two</li>
      <li>List item three</li>
    </ul>
  </div>
  <h3>Items you should be careful about:</h3>
  <div>
    <p>
    Cras dictum. Pellentesque habitant morbi tristique senectus et netus
    et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in
    faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia
    mauris vel est.
    </p>
    </div>
    </div>
    <input type="submit" value="View Your Shopping List" /></form>
</body>
</html>
