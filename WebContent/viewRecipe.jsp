
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
<% String pageTitle = "View Recipe"; %>
<% String currentPage = "explorer"; %>
<%@include file="header.jsp"%>

<%
  XMLParser writeX = new XMLParser();
  ArrayList<Meal> readmeals = new ArrayList<Meal>();
  readmeals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
  String name= String.valueOf(request.getParameter("name"));
  Meal themeal = writeX.getMeal(readmeals, name);
  
  if(themeal==null){%>
  <div class="container-fluid">
	  <p>It seems that the meal you are looking for was deleted.</p>
	  <p>Go to Meal Planner and change this recipe for a new one:</p>
	  <p>
			<button class="btn btn-block btn-success btn-lg" style="width: 200px"
				onclick="document.location.href='editPlan.jsp'">Change
				Meal Plan</button>
		</p>
	</div>  
  <%}else{
  
  
  
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
   
    
    String pps;
    
    if(themeal.getServings()<2){
   	 pps= "person";
    }else{
   	 
   	 pps= "people";
    }
    
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
                        Serves <%=themeal.getServings() %> <%=pps %>
                        <input type="hidden" value="<%=themeal.getName() %>" name="name">
                      </div>
                      <div class="col-sm-4">
                        
                      <button  class="btn pull-right btn-primary btn-md" type="submit" >Edit</button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-sm-8">
              
          
    
     
     <% for (int i=0; i< themeal.getIngredients().size();i++){

    	 String link;
    	 
    	 if(themeal.getIngredients().get(i).getSupermarket().equals("T")){
    		 
    		 link= "http://www.tesco.com/groceries/product/details/?id=" +  themeal.getIngredients().get(i).getShopID();
    	 }else if (themeal.getIngredients().get(i).getSupermarket().equals("S")){
    		 
    		 link= themeal.getIngredients().get(i).getShopID();
    	 }else{
    		 
    		 link=  themeal.getIngredients().get(i).getShopID();
    	 }
    	 
    	 
    	 String unit;
			if (themeal.getIngredients().get(i).getUnit().toLowerCase().equals("null")){
				unit = "g/ml";
			}else{
				unit = themeal.getIngredients().get(i).getUnit();
				
			}  %>


							<div class="col-sm-8">
								<a href="#" onclick="window.open('<%=link%>')"><span class="list-product-name"><%=themeal.getIngredients().get(i).getName().replace(";", "")%>
								</span></a>
							</div>
							<div class="col-sm-4"> <%
							
							
							%>						
								<span> <%=themeal.getMasses().get(i)%> <%=unit.toLowerCase()%>
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
<%} %>
</body>
</html>
