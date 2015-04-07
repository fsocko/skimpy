<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>AJAX Test</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <style>
  .ui-autocomplete-loading {
    background: white url("images/ui-anim_basic_16x16.gif") right center no-repeat;
  }
  .ui-autocomplete {
    max-height: 480px;
    overflow-y: auto;
    /* prevent horizontal scrollbar */
    overflow-x: hidden;
  }
  * html .ui-autocomplete {
    height: 480px;
  }
  
  #city { width: 600px; }
  </style>
  <script>
  $(function() {
    function log( message ) {
      $( "<div>" ).text( message ).prependTo( "#log" );
      $( "#log" ).scrollTop( 0 );
    }
 
    $( "#city" ).autocomplete({
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
          "Nothing selected, input was " + this.value);
      },
      open: function() {
        $( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
      },
      close: function() {
        $( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
        $( "#city" ).val('');
      }
    });
  });
  </script>
</head>
<body>
 
<div class="ui-widget">
	  <input id="city">
</div>
 
<div class="ui-widget" style="margin-top:2em">
  <div id="log" style="height: 300px; width: 600px; overflow: auto;" class="ui-widget-content"></div>
</div>
 
 
</body>
</html>