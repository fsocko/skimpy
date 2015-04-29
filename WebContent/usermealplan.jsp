
<% String pageTitle = "Meal Planner"; %>
<% String currentPage = "meal_plan"; %>
<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="BusinessLogic.*"%>
<%	
if(request.getSession(false) == null){
	response.sendRedirect("login.jsp");
}
%>
<div class="container-fluid">
   	<div class="well">
     <div class="row">
       <%
       boolean flag = (boolean)session.getAttribute("hasMeal");
       if(flag){
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
		<a href = "editPlan.jsp" class="btn btn-success btn-lg">Create a Meal Plan</a>
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
	        	    <div class="panel-body"></div>
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
					        <li class="active"><a href="#monday">Monday</a></li>
					        <li><a href="#tuesday">Tuesday</a></li>
					        <li><a href="#wednesday">Wednesday</a></li>
					        <li><a href="#thursday">Thursday</a></li>
					        <li><a href="#friday">Friday</a></li>
					        <li><a href="#saturday">Saturday</a></li>
					        <li><a href="#sunday">Sunday</a></li>
					    </ul>
					    <div class="tab-content">
					        <div id="monday" class="tab-pane fade in active">
						        <h3>Monday</h3>
					            <div class="panel-body">
				                	<div class="row">
				                  <div class="col-sm-2">
				                    <span class="label label-default">Calories</span>
				                  </div>
				                  <div class="col-sm-4">
				                    <div class="progress progress-info active">
				                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).calorieInfo(0))%>%;"></div>
				                    </div>
				                  </div>
				                  <div class="col-sm-6">
				                    <p><%=NutritionOptimisation.messageCal(((NutritionOptimisation)session.getAttribute("sessionNutrition")).calorieInfo(0))%></p>
				                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Protein</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).proteinInfo(0))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageProtein(((NutritionOptimisation)session.getAttribute("sessionNutrition")).proteinInfo(0))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Carbohydrates</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).carbInfo(0))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageCarb(((NutritionOptimisation)session.getAttribute("sessionNutrition")).carbInfo(0))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Sugar</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).sugarInfo(0))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSugar(((NutritionOptimisation)session.getAttribute("sessionNutrition")).sugarInfo(0))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Fat</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fatInfo(0))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageFat(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fatInfo(0))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Saturates</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saturateInfo(0))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSaturates(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saturateInfo(0))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Fibre</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fibreInfo(0))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageFibre(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fibreInfo(0))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Salt</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saltInfo(0))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSalt(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saltInfo(0))%></p>
					                  </div>
					                </div>
				              </div>
				            </div>
				            <div id="tuesday" class="tab-pane fade">
						        <h3>Tuesday</h3>
					            <div class="panel-body">
				                	<div class="row">
						                <div class="col-sm-2">
						                	<span class="label label-default">Calories</span>
						                </div>
						                <div class="col-sm-4">
						                	<div class="progress progress-info active">
						                    	<div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).calorieInfo(1))%>%;"></div>
						                    </div>
						                </div>
						                <div class="col-sm-6">
						                    <p><%=NutritionOptimisation.messageCal(((NutritionOptimisation)session.getAttribute("sessionNutrition")).calorieInfo(1))%></p>
						                </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Protein</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).proteinInfo(1))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageProtein(((NutritionOptimisation)session.getAttribute("sessionNutrition")).proteinInfo(1))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Carbohydrates</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).carbInfo(1))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageCarb(((NutritionOptimisation)session.getAttribute("sessionNutrition")).carbInfo(1))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Sugar</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).sugarInfo(1))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSugar(((NutritionOptimisation)session.getAttribute("sessionNutrition")).sugarInfo(1))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Fat</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fatInfo(1))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageFat(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fatInfo(1))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Saturates</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saturateInfo(1))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSaturates(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saturateInfo(1))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Fibre</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fibreInfo(1))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageFibre(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fibreInfo(1))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Salt</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saltInfo(1))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSalt(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saltInfo(1))%></p>
					                  </div>
					                </div>
				            	</div>
				            </div>
				            <div id="wednesday" class="tab-pane fade">
						        <h3>Wednesday</h3>
					            <div class="panel-body">
				                	<div class="row">
				                  <div class="col-sm-2">
				                    <span class="label label-default">Calories</span>
				                  </div>
				                  <div class="col-sm-4">
				                    <div class="progress progress-info active">
				                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).calorieInfo(2))%>%;"></div>
				                    </div>
				                  </div>
				                  <div class="col-sm-6">
				                    <p><%=NutritionOptimisation.messageCal(((NutritionOptimisation)session.getAttribute("sessionNutrition")).calorieInfo(2))%></p>
				                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Protein</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).proteinInfo(2))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageProtein(((NutritionOptimisation)session.getAttribute("sessionNutrition")).proteinInfo(2))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Carbohydrates</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).carbInfo(2))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageCarb(((NutritionOptimisation)session.getAttribute("sessionNutrition")).carbInfo(2))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Sugar</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).sugarInfo(2))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSugar(((NutritionOptimisation)session.getAttribute("sessionNutrition")).sugarInfo(2))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Fat</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fatInfo(2))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageFat(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fatInfo(2))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Saturates</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saturateInfo(2))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSaturates(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saturateInfo(2))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Fibre</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fibreInfo(2))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageFibre(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fibreInfo(2))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Salt</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saltInfo(2))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSalt(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saltInfo(2))%></p>
					                  </div>
					                </div>
				              	</div>
				            </div>
				            <div id="thursday" class="tab-pane fade">
						        <h3>Thursday</h3>
					            <div class="panel-body">
				                	<div class="row">
						                <div class="col-sm-2">
						                	<span class="label label-default">Calories</span>
						                </div>
						                <div class="col-sm-4">
						                	<div class="progress progress-info active">
						                    	<div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).calorieInfo(3))%>%;"></div>
						                    </div>
						                </div>
						                <div class="col-sm-6">
						                    <p><%=NutritionOptimisation.messageCal(((NutritionOptimisation)session.getAttribute("sessionNutrition")).calorieInfo(3))%></p>
						                </div>
						            </div>
					                <div class="row">
					                  	<div class="col-sm-2">
					                    	<span class="label label-default">Protein</span>
					                  	</div>
					                  	<div class="col-sm-4">
					                    	<div class="progress">
					                      		<div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).proteinInfo(3))%>%;"></div>
					                    	</div>
					                  	</div>
					                  	<div class="col-sm-6">
					                    	<p><%=NutritionOptimisation.messageProtein(((NutritionOptimisation)session.getAttribute("sessionNutrition")).proteinInfo(3))%></p>
					                  	</div>
					                </div>
					                <div class="row">
					                  	<div class="col-sm-2">
					                    	<span class="label label-default">Carbohydrates</span>
					                  	</div>
					                  	<div class="col-sm-4">
					                    	<div class="progress">
					                      		<div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).carbInfo(3))%>%;"></div>
					                    	</div>
					                  	</div>
					                 	<div class="col-sm-6">
					                    	<p><%=NutritionOptimisation.messageCarb(((NutritionOptimisation)session.getAttribute("sessionNutrition")).carbInfo(3))%></p>
					                  	</div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Sugar</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).sugarInfo(3))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSugar(((NutritionOptimisation)session.getAttribute("sessionNutrition")).sugarInfo(3))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Fat</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fatInfo(3))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageFat(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fatInfo(3))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Saturates</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saturateInfo(3))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSaturates(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saturateInfo(3))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Fibre</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fibreInfo(3))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageFibre(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fibreInfo(3))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Salt</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saltInfo(3))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSalt(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saltInfo(3))%></p>
					                  </div>
					                </div>
				              	</div>
				            </div>
				            <div id="friday" class="tab-pane fade">
						        <h3>Friday</h3>
					            <div class="panel-body">
				                	<div class="row">
					                	<div class="col-sm-2">
					                    	<span class="label label-default">Calories</span>
					                  	</div>
					                  	<div class="col-sm-4">
					                    	<div class="progress progress-info active">
					                      		<div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).calorieInfo(4))%>%;"></div>
					                    	</div>
					                	</div>
					                  	<div class="col-sm-6">
					                    	<p><%=NutritionOptimisation.messageCal(((NutritionOptimisation)session.getAttribute("sessionNutrition")).calorieInfo(4))%></p>
					                  	</div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Protein</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).proteinInfo(4))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageProtein(((NutritionOptimisation)session.getAttribute("sessionNutrition")).proteinInfo(4))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Carbohydrates</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).carbInfo(4))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageCarb(((NutritionOptimisation)session.getAttribute("sessionNutrition")).carbInfo(4))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Sugar</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).sugarInfo(4))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSugar(((NutritionOptimisation)session.getAttribute("sessionNutrition")).sugarInfo(4))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Fat</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fatInfo(4))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageFat(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fatInfo(4))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Saturates</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saturateInfo(4))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSaturates(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saturateInfo(4))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Fibre</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fibreInfo(4))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageFibre(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fibreInfo(4))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Salt</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saltInfo(4))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSalt(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saltInfo(4))%></p>
					                  </div>
					                </div>
				              	</div>
				            </div>
				            <div id="saturday" class="tab-pane fade">
						        <h3>Saturday</h3>
					            <div class="panel-body">
				                	<div class="row">
					                	<div class="col-sm-2">
					                    	<span class="label label-default">Calories</span>
					                	</div>
					                  	<div class="col-sm-4">
					                    	<div class="progress progress-info active">
					                      		<div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).calorieInfo(5))%>%;"></div>
					                    	</div>
					                  	</div>
					                  	<div class="col-sm-6">
					                    	<p><%=NutritionOptimisation.messageCal(((NutritionOptimisation)session.getAttribute("sessionNutrition")).calorieInfo(5))%></p>
					                  	</div>
						            </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Protein</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).proteinInfo(5))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageProtein(((NutritionOptimisation)session.getAttribute("sessionNutrition")).proteinInfo(5))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Carbohydrates</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).carbInfo(5))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageCarb(((NutritionOptimisation)session.getAttribute("sessionNutrition")).carbInfo(5))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Sugar</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).sugarInfo(5))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSugar(((NutritionOptimisation)session.getAttribute("sessionNutrition")).sugarInfo(5))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Fat</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fatInfo(5))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageFat(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fatInfo(5))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Saturates</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saturateInfo(5))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSaturates(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saturateInfo(5))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Fibre</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fibreInfo(5))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageFibre(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fibreInfo(5))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Salt</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saltInfo(5))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSalt(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saltInfo(5))%></p>
					                  </div>
					                </div>
				              </div>
				            </div>
				            <div id="sunday" class="tab-pane fade">
						        <h3>Sunday</h3>
					            <div class="panel-body">
				                	<div class="row">
					                	<div class="col-sm-2">
					                    	<span class="label label-default">Calories</span>
					                	</div>
					                  	<div class="col-sm-4">
					                    	<div class="progress progress-info active">
					                     		<div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).calorieInfo(6))%>%;"></div>
					                    </div>
					                  	</div>
					                  	<div class="col-sm-6">
					                    	<p><%=NutritionOptimisation.messageCal(((NutritionOptimisation)session.getAttribute("sessionNutrition")).calorieInfo(6))%></p>
					                  	</div>
						            </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Protein</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).proteinInfo(6))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageProtein(((NutritionOptimisation)session.getAttribute("sessionNutrition")).proteinInfo(6))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Carbohydrates</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).carbInfo(6))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageCarb(((NutritionOptimisation)session.getAttribute("sessionNutrition")).carbInfo(6))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Sugar</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).sugarInfo(6))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSugar(((NutritionOptimisation)session.getAttribute("sessionNutrition")).sugarInfo(6))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Fat</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fatInfo(6))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageFat(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fatInfo(6))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Saturates</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saturateInfo(6))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSaturates(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saturateInfo(6))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Fibre</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fibreInfo(6))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageFibre(((NutritionOptimisation)session.getAttribute("sessionNutrition")).fibreInfo(6))%></p>
					                  </div>
					                </div>
					                <div class="row">
					                  <div class="col-sm-2">
					                    <span class="label label-default">Salt</span>
					                  </div>
					                  <div class="col-sm-4">
					                    <div class="progress">
					                      <div class="progress-bar" style = "width: <%=String.valueOf(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saltInfo(6))%>%;"></div>
					                    </div>
					                  </div>
					                  <div class="col-sm-6">
					                    <p><%=NutritionOptimisation.messageSalt(((NutritionOptimisation)session.getAttribute("sessionNutrition")).saltInfo(6))%></p>
					                  </div>
					                </div>
				              </div>
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
