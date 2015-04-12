<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search</title>
	<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css">
	<link rel="stylesheet" href="css/search.css">
	<script src="js/jquery-1.11.2.min.js"></script>
	<script>
		function fillSearchCategories(categories) {
			$('#categories-tickboxes').append(
				$('<div>').addClass('separator').text('Refine by category'));
			for (c in categories) {
				$('#categories-tickboxes').append(
					$('<span>').addClass('category-tick')
						.append($('<input>').addClass('category-checkbox').attr('type', 'checkbox').attr('value', categories[c]))
						.append($('<span>').addClass('category-name').text(categories[c]))
					);
			}
		}
		
		function fillResults(data) {
			$('#results').append(
					$('<div>').addClass('separator').text('Search results'));
			for (x in data) {
				$('#results').append(
				  $('<div>').addClass('result-entry')
					.append($('<span>').addClass('product-name').text(data[x].name))
					.append($('<span>').addClass('product-price').text(data[x].price))
					.append($('<span>').addClass('button-add').append(
						$('<i>').addClass('fa').addClass('fa-plus')))
				);
			}
		}
	</script>
</head>
<body>
	<script>
		var prevQuery = "";
		var categoriesSearch = [];
		$(document).ready(function(){
			$('#search').keyup(function(){
				$('#autocomplete-box').css("visibility", "visible");
				if ($('#search').val() != prevQuery && $('#search').val().length > 2) {
					prevQuery = $('#search').val();
					$.ajax({
				          url: "CategorySearch.jsp",
				          dataType: "json",
				          data: {
				            q: $('#search').val()
				          },
				          success: function( data ) {
				        	  $('#categories-tickboxes').empty();
				        	  fillSearchCategories(data);
				          }
				    });
					$.ajax({
				          url: "FullSearch.jsp",
				          dataType: "json",
				          data: {
				            q: $('#search').val()
				          },
				          success: function( data ) {
				        	  $('#results').empty();
				        	  fillResults(data);
				          }
				    });
				}
			});
			
			$('#autocomplete-box').on('click', '#close',
				function() {
					$('#categories-tickboxes').empty();
					$('#results').empty();
					$('#autocomplete-box').css("visibility", "hidden");
				}
			);
			
			function pushCategories() {
				$(".category-checkbox:checked").each(function()
				{
					categoriesSearch.push($(this).val());
				});
			}
			
			$('#categories-tickboxes').on('change', '.category-checkbox',
				function() {
					categoriesSearch = [];
					pushCategories();
					alert(categoriesSearch);
					$.ajax({
			          url: "RefinedSearch.jsp",
			          dataType: "json",
			          data: {
			            q: $('#search').val(),
			            cat: categoriesSearch
			          },
			          success: function( data ) {
			        	  $('#results').empty();
			        	  fillResults(data);
			          }
			    	});
				}
			);
			
			$('#results').on('click', '.button-add',
				function (event) {
					$('#products-list').append(
						$('<div>').addClass('product-list-entry').text(	
							$(this).closest('.result-entry').text()));
				}
			);
		});
	</script>
	<form method="get" action="ProductSearch.jsp">
		<input id="search" name="q" type="text" placeholder="Search for products across many supermarkets" autocomplete="off" />
	</form>
	<div id="autocomplete-box">
		<span id="close">Close&nbsp;<i class="fa fa-times"></i></span>
		<div id="categories-tickboxes"></div>
		<div id="results"></div>
	</div>
	
	<div id="products-list">
	</div>
</body>
</html>