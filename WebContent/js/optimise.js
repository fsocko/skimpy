function findOffers(tableID, shopID, refPrice) {
	var filtered = [];
	$.ajax({
        url: "FindBetterOffer.jsp",
        dataType: "json",
        data: {
          id: tableID,
          shop: shopID
        },
        success: function(data) {
        	for (i in data) {
        		if (data[i].price - refPrice < 0) {
        			filtered.push(data[i]);
        		}
        	}
        }
	});
	
	if (filtered.length > 0) {
		// With better price
		console.log(filtered);
	}
	else {
		console.log("Empty");
	}
}