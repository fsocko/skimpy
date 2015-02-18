<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Show Browser</title>
<script type="text/javascript">
 function dynInput(cbox) {
    var input = document.createElement("input");
    input.type = "text";
    var div = document.createElement("div");
    div.id = cbox.name;
    div.innerHTML = "Add your meal: " + cbox.name;
    div.appendChild(input);
    document.getElementById("insertinputs").appendChild(div);
    /* var newmeal = document.getElementById("input").value;
    var mealArray[];
    var messageBox  = document.getElementById("display");
    function insert ( ) {
    	 mealArray.push( newmeal.value );
    	 clearAndShow();
    	}
    function clearAndShow () {
    	 newmeal.value = "";
    	  messageBox.innerHTML = "";

    	  messageBox.innerHTML += "Meals: " + mealArray.join(", ");
    	} */
}
</script>
</head>
<body>
<% 
MealPlanner plan = CreateMealPlan.create();
/* ArrayList<Food> test = new ArrayList<Food>();
Meal meal = new Meal("Test", new ArrayList<Food>());
String mealname =  meal.getName(); */ %>

<%-- <jsp:useBean id="Meal" class="pack.Meal"/> --%>

	<table border="1">
		<%for (int i = 0; i < 3; i++) { %>
		   <tr>
             <%for (int j = 0; j < 7; j++) { %> 
                       
			  <th>
			  
			 <%=plan.getMeal(j, i).getName() %>
		<p>	
		<button onclick="dynInput(this)"> mealname </button></p>
		<p id="insertinputs"></p>
		<!-- <button onclick="insert()" type = "submit" id="btnhide" >hidden</button>
		<p  id="display" {display:none;}></p> -->
			</th>
			  <%} %>
			</tr>
				
		    <%} %> 
		
	</table>
</body>
</html>