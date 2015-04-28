<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html"%>
<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.io.Writer"%>
<%@page import="java.nio.charset.Charset"%>
<%@page import="java.text.DecimalFormat" %>
<% String pageTitle = "View Recipe"; %>
<% String currentPage = "explorer"; %>
<%@include file="header.jsp"%>

<%
  XMLParser writeX = new XMLParser();
  ArrayList<Meal> readmeals = new ArrayList<Meal>();
  readmeals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
  String name= String.valueOf(request.getParameter("name"));
  System.out.println("NAME:"+ name);
  //String name = "Tuna Pasta Salad";
  Meal themeal = writeX.getMeal(readmeals, name);
 String dbid = "";
 String  sup = "";
 
	DecimalFormat cleanDecimal = new DecimalFormat("0.0");
 
  for (int j=0; j< themeal.getIngredients().size();j++){
      
    dbid +=  themeal.getIngredients().get(j).getDBID() + ";" ;

    sup +=   themeal.getIngredients().get(j).getSupermarket() + ";";

      }

    session.setAttribute("dbid", dbid);
    session.setAttribute("sup", sup);
     
    System.out.println(themeal.getIngredients().size());
   
      %>

<form action="editRecipe.jsp" method="post">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-7">
				<div class="well">
					<div class="row">
						<div class="col-sm-12">
							<div class="media">

								<div class="media-body">
									<div class="row">

										<div class="col-sm-8">
											<h4><%=themeal.getName() %></h4>
											<input type="hidden" value="<%=themeal.getName() %>"
												name="name">
										</div>
										<div class="col-sm-4">

											<button class="btn pull-right btn-primary btn-md"
												type="submit">Edit</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-8">
							<%for (int i=0; i< themeal.getIngredients().size();i++){
    	 String link;
    	 
    	 if(themeal.getIngredients().get(i).getSupermarket().equals("T")){
    		 
    		 link=  themeal.getIngredients().get(i).getShopID();
    	 }else if (themeal.getIngredients().get(i).getSupermarket().equals("S")){
    		 
    		 link=  themeal.getIngredients().get(i).getShopID();
    	 }else{
    		 
    		 link=  themeal.getIngredients().get(i).getShopID();
    	 }
    	 
    	 
	                %>


							<div class="col-sm-8">
								<a href="<%=link%>"><span class="list-product-name"><%=themeal.getIngredients().get(i).getName().replace(";", "")%>
								</span></a>
							</div>
							<div class="col-sm-4">
								<span> <%=themeal.getMasses().get(i)%>
								</span>
							</div>
							<% }%>
						</div>

					</div>
				</div>

			</div>


			<div class="col-sm-5">
				<div class="well">
					<div class="row">
						<div class="col-sm-12">
							<div class="row">
								<div class="col-sm-12">
									<h4>Meal Nutrition:</h4>
								</div>
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-4">
											<span class="label label-info">Calories</span>
										</div>
										<div class="col-sm-8">
											<p><%=cleanDecimal.format(themeal.mealCal()) %> kcal</p>
										</div>
										<div class="col-sm-4">
											<span class="label label-info">Protein</span>
										</div>
										<div class="col-sm-8">
											<p><%=cleanDecimal.format(themeal.mealProt()) %> g</p>
										</div>
										<div class="col-sm-4">
											<span class="label label-info">Carbohydrates</span>
										</div>
										<div class="col-sm-8">
											<p><%=cleanDecimal.format(themeal.mealCarb()) %> g</p>
										</div>
										<div class="col-sm-4">
											<span class="label label-info">Sugar</span>
										</div>
										<div class="col-sm-8">
											<p><%=cleanDecimal.format(themeal.mealSugar()) %> g</p>
										</div>
										<div class="col-sm-4">
											<span class="label label-info">Fat</span>
										</div>
										<div class="col-sm-8">
											<p><%=cleanDecimal.format(themeal.mealFat()) %> g</p>
										</div>
										<div class="col-sm-4">
											<span class="label label-info">Saturates</span>
										</div>
										<div class="col-sm-8">
											<p><%=cleanDecimal.format(themeal.mealSat()) %> g</p>
										</div>
										<div class="col-sm-4">
											<span class="label label-info">Fibre</span>
										</div>
										<div class="col-sm-8">
											<p><%=cleanDecimal.format(themeal.mealFibr()) %> g</p>
										</div>
										<div class="col-sm-4">
											<span class="label label-info">Salt</span>
										</div>
										<div class="col-sm-8">
											<p><%=cleanDecimal.format(themeal.mealSalt()) %> g</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<div class="col-md-12">
									<h4>Price Optimisation</h4>
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<div class="col-md-12">
									<div class="progress">
										<div class="progress-bar" style="width: 40%;"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<div class="col-md-12">
									<h4>Nutrition Optimisation</h4>
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<div class="col-md-12">
									<div class="progress">
										<div class="progress-bar" style="width: 40%;"></div>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

		</div>
	</div>
</form>

</body>
</html>
