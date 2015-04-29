function findOffers(tableID, shopID, refPrice) {
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
        	fillOffers(filtered);
        }
	});
}

function fillOffers(array) {
	for (obj in array)
	console.log(array[obj])
}