
<% String pageTitle = "New Meal"; %>
<% String currentPage = "recipe"; %>
<%@include file="header.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-6">
			<form action="savedMeal.jsp" method="POST">
				<div id="recipe">
					<div class="col-sm-10">
							<input class="recipe-name form-control input-sm" name="mealname" placeholder="Meal Name">
							</div>
							<div class="col-sm-2">
						    <input class="recipe-name form-control input-sm" placeholder= "Servings" name="servings">
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
</body>
</html>