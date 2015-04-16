<%@include file="header.jsp" %>
<!doctype html>

<html>
  
  <head>
    <title>New Meal</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    	<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css">
	<link rel="stylesheet" href="css/search.css">
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/search.js"></script>
  </head>
  
  <body>
    <div class="container">
    	<h2 class="text-left">Create a Meal</h2>
    
    	<div id ="search-container">
    		<input id="search" name="q" type="text" placeholder="Search for products across many supermarkets" autocomplete="off" />
    		<div id="autocomplete-box">
				<span id="close">Close&nbsp;<i class="fa fa-times"></i></span>
				<div id="categories-tickboxes"></div>
				<div id="results"></div>
			</div>
		</div> 
	
		<div id="recipe">
			<input class="recipe-name" name="mealname" placeholder="Meal Name">
			<div class="products-mass">
				<div id="products-list"></div>
			</div>
		</div>
    </div>
  </body>

</html>