<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>AJAX Test</title>
  <link rel="stylesheet" href="css/ajax.css" />
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="js/jquery-ui-1.11.4/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="js/jquery-ui-1.11.4/jquery-ui.js"></script>
  <script>
  	function updateCategories(phrase) {
  		$.getJSON("CategorySearch.jsp", { q: phrase }, function(data) {
  		    $("#categories-list option").remove(); // Remove all <option> child tags.
  		    $.each(data, function(index, item) { // Iterates through a collection
  		        $("#categories-list").append( // Append an object to the inside of the select box
  		            $("<option></option>") // Yes you can do this.
  		            	.text(item)
  		                /* .text(item.Description)
  		                .val(item.Id) */
  		        );
  		    });
  		});
	}
  
  $(function() {
    function log( productName, productPrice, shop_code ) {
    	/* var shop_class = "generic";
    	if (shop_code == "t") {
    		shop_class = "tesco-price";
    	}
    	else if (shop_code == "s") {
    		shop_class = "sains-price";
    	}
    	else if (shop_code == "a") {
    		shop_class = "asda-price";
    	} */
    	
   	  $( '#log' ).append(
   		$('<div>').addClass('list-entry')
   		  .append($('<span>').addClass('product-name').text(productName))
   		  .append($('<span>').addClass('product-price')/* .addClass(shop_class) */.text(productPrice))
   		  .append($('<span>').addClass('action-remove').append(
   			 $("<i class='fa fa-times button-remove'>"))
   		 ));
      $( "#log" ).scrollTop( 0 );
    }
 
    $( "#search" ).autocomplete({
      source: function( request, response ) {
        $.ajax({
          url: "ProductSearch.jsp",
          dataType: "json",
          data: {
            q: request.term
          },
          success: function( data ) {
            response( data );
          }
        });
      },
      minLength: 3,
      select: function( event, ui ) {
        log( ui.item ?
          ui.item.label :
          "Nothing selected, input was " + this.value,
          "£0.00", "t");
      },
      open: function() {
        $( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
        updateCategories($('#search').val());
      },
      close: function() {
        $( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
        
      }
    });
  });
  </script>
</head>
<body>
	<script>
		
		$(document).ready(function() {
			$('#log').on( 'click', '.button-remove', function() {
				$(this).closest('.list-entry').remove();
			});
		});
	</script>
 
<div>
	<select id="categories-list">
		<option value="bread">Bread</option>
		<option value="in-store_bakery">In-Store Bakery</option>
	</select>
</div>
<div class="ui-widget">
	  <input id="search" placeholder="Search for products across many supermarkets">
</div>
 
<div class="ui-widget" style="margin-top:2em">
  <div id="log" class="ui-widget-content"></div>
</div>
 
 
</body>
</html>