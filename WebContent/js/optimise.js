function findOffers(tableID, shopID) {
	$.ajax({
        url: "FindBetterOffer.jsp",
        dataType: "json",
        data: {
          id: tableID,
          shop: shopID
        },
        success: function(data) {
        	for (i in data) {
        		
        	}
        }
  });
}