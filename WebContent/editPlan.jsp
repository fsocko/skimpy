
<% String pageTitle = "Edit Meal Plan"; %>
<% String currentPage = "meal_plan"; %>

<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="BusinessLogic.*"%>
<%@page import="java.util.ArrayList"%>
<%	
if(session.getAttribute("username") == null){
	response.sendRedirect("login.jsp");
	return;
}
%>
<div class="container-fluid">
   	<div class="well">
    	<div class="row">
			<%
			XMLParser writeX = new XMLParser();
			ArrayList<Meal> meals = new ArrayList<Meal>();
			meals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
			if(meals != null){
			%>
			<form action="savedPlan.jsp" method="POST">	
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
			    			boolean flag = (boolean)session.getAttribute("hasMealPlan");
							if(!flag){
			    			%>
				           		<td style="text-align: center;">
				           			<div id="cell<%=i%><%=j %>">
				           			   	<div class="result">
											<span class = "product">
												<select class="form-control" id="ing<%=i%><%=j%>">
													<option selected></option>
														<%
															for(Meal m : meals){
																					%>
													<option><%= m.getName()%></option>
												<%
												}
												%>
												</select>
											</span>
											<input name="meal<%=i%><%=j %>" id="meal" class="meal" type="hidden">
									  	</div>
										<div id="add-item"></div>
									</div>
								</td>	
							<%
							}
							else {
								if(((MealPlanner)session.getAttribute("mealPlan")).getMeal(i,j) != null){
									String name = ((MealPlanner)session.getAttribute("mealPlan")).getMeal(i,j).getName();
							%>
								<td style="text-align: center;">
				           			<div id="cell<%=i%><%=j %>">
				           			   	<div class="result" style="display:none;">
											<span class = "product">
												<select class="form-control" id="ing<%=i%><%=j%>">
													<option selected></option>
														<%
															for(Meal m : meals){
																					%>
													<option><%= m.getName()%></option>
												<%
												}
												%>
												</select>
											</span>
											<input name="meal<%=i%><%=j %>" id="meal" class="meal" type="hidden" value="<%=name%>">
									  	</div>
										<div id="add-item">
											<div class="result-entry">
													<span class="product-name-plan"><%= name%></span>
													<span class="button-remove-plan">
															<i class="fa fa-times"></i>
													</span>
											</div>
										</div>
									</div>
								</td>	
												
											
								<%
								}
								else{
								%>
								<td style="text-align: center;">
				           			<div id="cell<%=i%><%=j %>">
				           			   	<div class="result">
											<span class = "product">
												<select class="form-control" id="ing<%=i%><%=j%>">
													<option selected></option>
														<%
															for(Meal m : meals){
																					%>
													<option><%= m.getName()%></option>
												<%
												}
												%>
												</select>
											</span>
											<input name="meal<%=i%><%=j %>" id="meal" class="meal" type="hidden">
									  	</div>
										<div id="add-item"></div>
									</div>
								</td>	
								<%
								}
								%>  	
							<%
							}
							%>
						<%
						}
						%>
					</tr>
					<%
					}
					%>          
					</tbody>
				</table>
				<br>
				<input type="submit" class="btn btn-block btn-success btn-lg" style = "width: 15%" value="Save Meal Plan"/>
			</form>
			<%
			} 
			else{
			%>
			<p>You haven't created any recipes yet.</p>
			<a href="recipe.jsp" class="btn btn-block btn-success btn-lg" style = "width: 20%">Create a Recipe</a>
			<%
			} 
			%>
		</div>
   	</div>
</div>
</body>
</html>
