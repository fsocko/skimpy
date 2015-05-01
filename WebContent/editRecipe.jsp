
<% String pageTitle = "Edit Recipe"; %>
<% String currentPage = "explorer"; %>
<%@include file="header.jsp"%><%@page import="java.util.ArrayList" %>



 <%

	if(session.getAttribute("username") == null){
		response.sendRedirect("login.jsp");
		return;
	}
	XMLParser writeX = new XMLParser();
	ArrayList<Meal> readmeals = new ArrayList<Meal>();
	readmeals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
	String name= String.valueOf(request.getParameter("name"));
	
	
	String  Shops =  (String)session.getAttribute("sup");
	String ShopIds =  (String)session.getAttribute("dbid");
	Meal themeal = writeX.getMeal(readmeals, name);
  
 %>
 
 <head>
<style type="text/css">

label.error {
  			font-weight: bold;
  			color: red;
  			padding: 2px 8px;
  			margin-top: 2px;
		}
</style>
 </head>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-6">
		<div id="recipe">
			<form action="savedMeal.jsp" method="POST" id="myForm">
				
					<div class="col-sm-8">
							<input class="recipe-name form-control input-sm" name="mealname" placeholder="Meal Name"
							value="<%=themeal.getName()%>" readonly>
							</div>
							<div class="col-sm-4">
						    <input class="recipe-name form-control input-sm" placeholder= "Servings" name="servings" id="servings"
						    value="<%=themeal.getServings() %>">
						    </div>
					<div class="products-mass">
						<div id="products-list" class="form-control input-sm">
						<%for (int i=0; i< themeal.getIngredients().size();i++){
								 
								 
								 String link;
						    	 
						    	 if(themeal.getIngredients().get(i).getSupermarket().equals("T")){
						    		 
						    		 link= "http://www.tesco.com/groceries/product/details/?id=" +  themeal.getIngredients().get(i).getShopID();
						    	 }else if (themeal.getIngredients().get(i).getSupermarket().equals("S")){
						    		 
						    		 link=  themeal.getIngredients().get(i).getShopID();
						    	 }else{
						    		 
						    		 link=  themeal.getIngredients().get(i).getShopID();
						    	 }
						    	 
						    	 
						    	 String unit;
									if (themeal.getIngredients().get(i).getUnit().toLowerCase().equals("null")){
										unit = "g/ml";
									}else{
										unit = themeal.getIngredients().get(i).getUnit();
										
									}  %>
									     
			
							<div class="product-list-entry">
                        			<a href="#" onclick="window.open('<%=link%>')"><span class="list-product-name"><%=themeal.getIngredients().get(i).getName().replace(";", "")%>
                       			 	</span></a>
                     				<span class="list-product-price">£ <%=themeal.getIngredients().get(i).getPrice()%>
                      				</span>
                      				<span class="button-remove"><i class="fa fa-times"></i></span>
                      				<span class="list-product-mass">Mass: <input class="serving size" name="mass"
                       		id="mass" value="<%=themeal.getMasses().get(i)%>"> <%=unit.toLowerCase() %>
                       				</span>
                     				<span class="shopID"><%=themeal.getIngredients().get(i).getDBID()%></span>
                      				<span class="shopName"><%=themeal.getIngredients().get(i).getSupermarket()%></span>
                      				<div class="col-sm-4">
                        				<p></p>
                      				</div>
                     		</div> <% }%>
						</div>
								<input class="list-group" id="ingred" type="hidden" name="ingred"
							  		 value="<%=ShopIds%>"> <input class="list-group" id="supermarket"
							  			 type="hidden" name="supermarket" value="<%=Shops %>">
					</div>

					   		 <input type="submit" class="btn btn-block btn-success btn-lg" id="change-button"
						      		 style="width: 150px" value="Save Changes" />
				
			</form>
		
		
		   <form action="deleteRecipe.jsp" method="POST">
						<input type="hidden" name="mealname" value ="<%=themeal.getName()%>">
						<button style="width: 160px"  
						class="btn btn-block btn-success btn-lg" id="delete-button" type="submit" >Delete This Recipe</button>
		  </form>
		</div></div>
		<div class="col-sm-6">
			<div id="search-container">
				<input id="search" class="form-control input-sm" name="q"
					type="text"
					placeholder="Search for products across many supermarkets"
					autocomplete="off" />
				<div id="autocomplete-box">
					<span id="close">Close&nbsp;<i class="fa fa-times"></i></span>
					<div id="categories-tickboxes"></div>
					<div id="results"></div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#myForm').validate({
	    rules:{
	    	servings:{
	    		required: true
	    	},
	    }
	});
	$("#servings").keydown(function(event) {
		// Allow only backspace and delete
		if ( event.keyCode == 46 || event.keyCode == 8 ) {
			// let it happen, don't do anything
		}
		else {
			// Ensure that it is a number and stop the keypress
			if (event.keyCode < 48 || event.keyCode > 57 ) {
				event.preventDefault();	
			}	
		}
	});
});
</script>
</html>
