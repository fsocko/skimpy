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
		$(divId).append($('<div>').addClass("descr").text("These products might help you save a bit more..."));
		for (obj in array)
			$(divId).append(
				$('<div>').addClass('prod-suggestion')
					.append($('<span>').addClass('prod-sgst-name').text(array[obj].name))
				.append($('<span>').addClass('prod-sgst-price').text("£" + array[obj].price.toFixed(2)))
			);
	}
	else {
		$(divId).append($('<div>').addClass("descr").text("There were no cheaper products which could replace your choice."));
	}
}