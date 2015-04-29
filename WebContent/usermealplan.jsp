
<% String pageTitle = "Meal Planner"; %>
<% String currentPage = "meal_plan"; %>
<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="BusinessLogic.*"%>
<%	
  	if(session.getAttribute("username") == null){
		response.sendRedirect("login.jsp");
	}
%>
<div class="container-fluid">
   <div class="well">
     <div class="row">
       <%
       if(false){
       %>
       <a href = "editPlan.jsp" class="btn btn-success btn-lg">Create a Meal Plan</a>
       <%
       }
       else{
       %>
       <table class="table">
         <thead>
           <tr>
             <th style="text-align: center;">Monday</th>
             <th style="text-align: center;">Tuesday</th>
             <th style="text-align: center;">Wednesday</th>
             <th style="text-align: center;">Thursday</th>
             <th style="text-align: center;">Friday</th>
             <th style="text-align: center;">Saturday</th>
             <th style="text-align: center;">Sunday</th>
           </tr>
         </thead>
         <tbody>
  		   <%
  		   for(int j = 0; j < 3; j++){
  		   %>
           <tr>
	           <%
	           for(int i = 0; i < 7; i++){
	           %>
	           <td style="text-align: center;">
	           	 <form action="viewRecipe.jsp" method="post">
	           	   <%String name = ((MealPlanner)session.getAttribute("mealPlan")).getMeal(i,j).getName();%>
				   <button style="width: 100%; height: 100%;" class="btn pull-right btn-default btn-md" type="submit"><%= name %></button>
				   <input name="name" type="hidden" value="<%= name%>">
				 </form>
	           </td>
	           <%
	           }
	           %>
           </tr>
           <%
  		   }
  		   %>
           
         </tbody>
       </table>
       <%
       }
       %>
     </div>
   </div>
   <div class="well">
     <div class="panel-group" id="accordion">
     <div class="panel panel-default">
         <div class="panel-heading">
             <h4 class="panel-title">
                 <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Price Optimisation</a>
             </h4>
         </div>
         <div id="collapseOne" class="panel-collapse collapse in">
             <div class="panel-body">
                 
             </div>
         </div>
     </div>
     <div class="panel panel-default">
         <div class="panel-heading">
             <h4 class="panel-title">
                 <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">Nutrition Optimiser</a>
             </h4>
         </div>
         <div id="collapseThree" class="panel-collapse collapse">
             <div class="panel-body">
                 <div class="bs-example">
		    <ul class="nav nav-tabs">
		        <li class="active"><a href="#">Monday</a></li>
		        <li><a href="#">Tuesday</a></li>
		        <li><a href="#">Wednesday</a></li>
		        <li><a href="#">Thursday</a></li>
		        <li><a href="#">Friday</a></li>
		        <li><a href="#">Saturday</a></li>
		        <li><a href="#">Sunday</a></li>
		    </ul>
		</div>
             </div>
         </div>
     </div>
 	</div>
   </div>
 </div>
 </body>
</html>
