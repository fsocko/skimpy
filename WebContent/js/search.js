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
	var mass;
	var supermarket_class;

	$('#results').append(
			$('<div>').addClass('separator').text('Search results'));
	for (x in data) {
		var link_to_page = "";
		if (data[x].supermarket == 'A') {
			supermarket_class = 'asda-price';
			link_to_page = data[x].shopID;
		}
		else if (data[x].supermarket == 'T') {
			supermarket_class = 'tesco-price';
			link_to_page = "http://www.tesco.com/groceries/product/details/?id=" + data[x].shopID;
		}
		else if (data[x].supermarket == 'S') {
			supermarket_class = 'sains-price';
			if (data[x].shopID.indexOf('ProductDisplay?') == 0) {
				link_to_page = "http://www.sainsburys.co.uk/shop/gb/groceries/" + data[x].shopID;
			}
			else {
				link_to_page = "http://www.sainsburys.co.uk/shop/gb/groceries/"
					+ data[x].shelf + '/' + data[x].shopID;
			}
		}


		if (data[x].mass == "0" || data[x].unit == "NULL") {
			mass = "-";
		}
		else {
			mass = data[x].mass + data[x].unit.toLowerCase();
		}

		$('#results').append(
				$('<div>').addClass('result-entry')
				.append($('<a>').attr('href', link_to_page)
						.append($('<span>').addClass('product-name').text(data[x].name)))
						.append(
								$('<span>').addClass('product-mass').text(mass))
								.append($('<span>').addClass('shopID').text(data[x].ID))
								.append($('<span>').addClass('shopName').text(data[x].supermarket))
								.append(
										$('<span>').addClass('product-price').addClass(supermarket_class)
										.text('£' + data[x].price.toFixed(2)))
										.append($('<span>').addClass('button-add').append(
												$('<i>').addClass('fa').addClass('fa-plus')))
		);
	}
}

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
		          url: "JSONSearch.jsp",
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
		else if ($('#search').val() == "") {
			$('#autocomplete-box').css("visibility", "hidden");
		}
	});
	
	$('#autocomplete-box').on('click', '#close',
		function() {
			$('#categories-tickboxes').empty();
			$('#results').empty();
			$('#autocomplete-box').css("visibility", "hidden");
			$('#search').val('');
			$('#search').focus();
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
			$.ajax({
	          url: "JSONSearch.jsp",
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
		    $('#ingred').val($('#ingred').val() + $(this).closest('.result-entry').find('.shopID').text() + ";");
		    $('#supermarket').val($('#supermarket').val() + $(this).closest('.result-entry').find('.shopName').text() + ";");
			$('#products-list').append(
				$('<div>').addClass('product-list-entry').append(
						$('<a>').attr('href', $(this).closest('.result-entry').find('a').attr('href')).append(
					$('<span>').addClass('list-product-name').text(
						$(this).closest('.result-entry').find('.product-name').text())))
					.append(
						$('<span>').addClass('list-product-price').text(
							$(this).closest('.result-entry').find('.product-price').text()))
					.append(
						$('<span>').addClass('button-remove')
							.append($('<i>').addClass('fa').addClass('fa-times')))
					.append(
						$('<span>').addClass('list-product-mass').text('Serving size: ')
							.append($('<input name="mass" id ="mass">').addClass('serving-size')
								.attr('placeholder', $(this).closest('.result-entry').find('.product-mass').text())))
			);
		}
	);
	
	$('#products-list').on('click', '.button-remove',
		function() {
			$(this).closest('.product-list-entry').remove();
		}
	);
});