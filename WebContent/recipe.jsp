<% String pageTitle = "New Meal"; %>
<% String currentPage = "recipe"; %>
<%@include file="header.jsp"%>

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
			<form action="savedMeal.jsp" method="POST" id="myForm">
				<div id="recipe">
					<div class="col-sm-8">
							<input class="recipe-name form-control input-sm" name="mealname" placeholder="Meal Name">
							</div>
							<div class="col-sm-4">
						    <input class="recipe-name form-control input-sm" placeholder= "Servings" name="servings" id="servings">
						    </div>
					<div class="products-mass">
						<div id="products-list" class="form-control input-sm"></div>
						<input class="list-group" id="ingred" type="hidden" name="ingred"
							value=""> <input class="list-group" id="supermarket"
							type="hidden" name="supermarket" value="">
					</div>

					<input type="submit" class="btn btn-block btn-success btn-lg"
						style="width: 150px" value="Save Your Meal" />
				</div>
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
</body>
</html>