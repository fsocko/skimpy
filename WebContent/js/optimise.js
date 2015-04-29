function findOffers(tableID, shopID, refPrice, clickedId) {
	$.ajax({
        url: "FindBetterOffer.jsp",
        dataType: "json",
        data: {
          id: tableID,
          shop: shopID
        },
        success: function(data) {
        	var filtered = [];

        	for (i in data) {
        		if (data[i].price - refPrice < 0) {
        			filtered.push(data[i]);
        		}
        	}
        	fillOffers(filtered, clickedId);
        }
	});
}


function fillOffers(array, clickedId) {
	$("#" + clickedId).attr("disabled", "disabled");
	var divId = "#" + clickedId.substring(7);
	$(divId).closest('.suggestions-box').css("visibility", "visible");
	if (array.length > 0) {
		$(divId).append($('<a>').addClass('button-dismiss')
					.append($('<i>').addClass('fa fa-times'))
					.append($('<span>').addClass('button-label').text(" Dismiss")))
			.append($('<div>').addClass("descr").text("These products might help you save a bit more..."));
		for (obj in array)
			$(divId).append(
				$('<div>').addClass('prod-suggestion')
					.append($('<span>').addClass('prod-sgst-name').text(array[obj].name))
					.append($('<span>').addClass('prod-sgst-price').text(" £" + array[obj].price.toFixed(2)))
					.append($('<a>').addClass('btn btn-success button-replace')
						.append($('<i>').addClass('fa fa-level-up'))
						.append($('<span>').addClass('button-label').text(" Replace")))
			);
	}
	else {
		$(divId).append($('<div>').addClass("descr")
			.text("There are no cheaper products which could replace your choice."));
	}
}

$(document).ready(function() {
	$('.suggestions-box').on('click', '.button-dismiss',
		function() {
			$(this).closest('.container-fluid').find('.optimise').removeAttr("disabled");
			$(this).closest('.suggestions-box').css('visibility', 'hidden');
			$(this).closest('.suggestions-box').empty();	
		}
	);
	
	$('.suggestions-box').on('click', '.button-replace',
		function() {
			var replaced_product_name = $(this).closest('.container-fluid').find('.list-product-name');
			var replaced_product_price = $(this).closest('.container-fluid').find('.list-product-price');
			var new_product_name = $(this).closest('.prod-suggestion').find('.prod-sgst-name').text();
			var new_product_price = $(this).closest('.prod-suggestion').find('.prod-sgst-price').text();
			replaced_product_name.empty().text(new_product_name);
			replaced_product_price.empty().text(new_product_price);
			$(this).closest('.suggestions-box').css('visibility', 'hidden');
			$(this).closest('.suggestions-box').empty();
		}
	);
});