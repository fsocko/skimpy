<% String pageTitle = "Edit Recipe"; %>
<% String currentPage = "explorer"; %>

<%@include file="header.jsp"%>
<%@page import="java.util.ArrayList" %>

<head>
<title>Edit Recipe</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="css/search.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/search.js"></script>
</head>

<body>


 <%
  XMLParser writeX = new XMLParser();
  ArrayList<Meal> readmeals = new ArrayList<Meal>();
  readmeals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
  String name= String.valueOf(request.getParameter("name"));
  
  
  String  Shops =  (String)session.getAttribute("sup");
  String ShopIds =  (String)session.getAttribute("dbid");
  Meal themeal = writeX.getMeal(readmeals, name);
  
 %>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-6">
				<form action="savedMeal.jsp" method="POST">
					<div id="recipe">
					
						<input class="recipe-name form-control input-sm" name="mealname"
							value="<%=themeal.getName() %>">
							<div class="products-mass">
							
							<div id="products-list" class="form-control input-sm">
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
	                
	                
	                 <div class="product-list-entry">
                        <a href="<%=link%>"><span class="list-product-name"><%=themeal.getIngredients().get(i).getName().replace(";", "")%>
                        </span></a>
                      <span class="list-product-price">£ <%=themeal.getIngredients().get(i).getPrice()%>
                      </span>
                      <span class="button-remove"><i class="fa fa-times"></i></span>
                      <span class="list-product-mass">Serving size: <input class="serving size" name="mass" id="mass" value="<%=themeal.getMasses().get(i)%>g">
                      </span>
                      <span class="shopID"><%=themeal.getIngredients().get(i).getDBID()%></span>
                      <span class="shopName"><%=themeal.getIngredients().get(i).getSupermarket()%></span>
                      <div class="col-sm-4">
                        <p></p>
                      </div></div> <% }%>
            
							</div>
							<input class="list-group" id="ingred" type="hidden" name="ingred"
								value="<%=ShopIds%>"> <input class="list-group" id="supermarket"
								type="hidden" name="supermarket" value="<%=Shops %>">
						</div>
                        
						<input type="submit" class="btn btn-block btn-success btn-lg"
							style="width: 160px" value="Save Changes" />
						</div>
						</form>
						<form action="deleteRecipe.jsp" method="POST">
						<input type="hidden" name="mealname" value ="<%=themeal.getName()%>">
						<button style="width: 160px"  
						class="btn btn-block btn-success btn-lg" type="submit" >Delete This Recipe</button>
						</form>
						
				
				</div>
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
</html>