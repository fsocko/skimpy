
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
       boolean flag = (boolean)session.getAttribute("hasMeal");
       if(!flag){
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
		           <%
	           	   String name = ((MealPlanner)session.getAttribute("mealPlan")).getMeal(i,j).getName();
	           	   boolean mealExists = (name != null);
	           	   if(mealExists){
	           	   %>
	           	 <form action="viewRecipe.jsp" method="post">
				   <button style="width: 100%; height: 100%;" class="btn pull-right btn-success btn-md" type="submit"><%= name %></button>
				   <input name="name" type="hidden" value="<%= name%>">
				 </form>
			   	   <%
				   }
	           	   else {
	           	   %>
	           	  <form action="editRecipe.jsp" method="post">
	           	   <button style="width: 100%; height: 100%;" class="btn pull-right btn-default btn-md" type="submit"></button>
				 </form>
	           	   <%
	           	   }
           	   	   %>
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
				    <ul class="nav nav-tabs" id="myTab">
				        <li class="active"><a href="#sectionA">Section A</a></li>
				        <li><a href="#sectionB">Section B</a></li>
				    </ul>
				    <div class="tab-content">
				        <div id="sectionA" class="tab-pane fade in active">
				            <h3>Monday</h3>
				            <p>Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui. Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
				        </div>
				        <div id="sectionB" class="tab-pane fade">
				            <h3>Tuesday</h3>
				            <p>Vestibulum nec erat eu nulla rhoncus fringilla ut non neque. Vivamus nibh urna, ornare id gravida ut, mollis a magna. Aliquam porttitor condimentum nisi, eu viverra ipsum porta ut. Nam hendrerit bibendum turpis, sed molestie mi fermentum id. Aenean volutpat velit sem. Sed consequat ante in rutrum convallis. Nunc facilisis leo at faucibus adipiscing.</p>
				        </div>
				        
				    </div>
				</div>
            </div>
         </div>
     </div>
 	</div>
   </div>
 </div>
 </body>
</html>
