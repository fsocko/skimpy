<!doctype html>

<html>
  
  <head>
    <title>Recipe</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
   <script src="//code.jquery.com/jquery-1.10.2.js"></script>
   <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <style type="text/css">
      /* Space out content a bit */
      body {
        padding-top: 20px;
        padding-bottom: 20px;
      }
      /* Everything but the jumbotron gets side spacing for mobile first views */
      .header, .marketing, .footer {
        padding-left: 15px;
        padding-right: 15px;
      }
      /* Custom page header */
      .header {
        border-bottom: 1px solid #e5e5e5;
      }
      /* Make the masthead heading the same height as the navigation */
      .header h3 {
        margin-top: 0;
        margin-bottom: 0;
        line-height: 40px;
        padding-bottom: 19px;
      }
      /* Custom page footer */
      .footer {
        padding-top: 19px;
        color: #777;
        border-top: 1px solid #e5e5e5;
      }
      /* Customize container */
      @media(min-width: 768px) {
        .container {
          max-width: 730px;
        }
      }
      .container-narrow > hr {
        margin: 30px 0;
      }
      /* Main marketing message and sign up button */
      .jumbotron {
        text-align: center;
        border-bottom: 1px solid #e5e5e5;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }
      /* Supporting marketing content */
      .marketing {
        margin: 40px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }
      /* Responsive: Portrait tablets and up */
      @media screen and(min-width: 768px) {
        /* Remove the padding we set earlier */
        .header, .marketing, .footer {
          padding-left: 0;
          padding-right: 0;
        }
        /* Space out the masthead */
        .header {
          margin-bottom: 30px;
        }
        /* Remove the bottom border on the jumbotron for visual effect */
        .jumbotron {
          border-bottom: 0;
        }
      }
    </style>
      <style>
  .ui-autocomplete-loading {
    background: white url("images/ui-anim_basic_16x16.gif") right center no-repeat;
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
    <div class="container">
      <div class="header">
        <ul class="nav nav-pills pull-right">
          <li class="active">
            <a href="#">Home</a>
          </li>
          <li>
            <a href="#">About</a>
          </li>
          <li>
            <a href="#">Contact</a>
          </li>
        </ul>
        <h3 class="text-muted">Skimpy</h3>
      </div>
      <div class="jumbotron">
        <h2 class="text-left">Create a Meal</h2>
        <p></p>
        <div class="container">
          <div class="row"></div>
          <div class="col-xs-9 col-md-4">
            <input class="form-control" value="Meal Name">
          </div>
          <div class="col-xs-1 col-md-1">
            <div class="btn-toolbar">
             <!--  <div class="btn-group">
                <a class="btn btn-default btn-xs">+</a>
              </div> -->
             <!--  <div class="btn-group"></div>
            </div> -->
          </div>
          <ul class="list-group"></ul>
        </div>
    <div class="ui-widget">
	  <input id="city" value="Ingredients">
    </div>
    <div class="ui-widget" style="margin-top:2em">
  <div id="log" style="height: 300px; width: 600px; overflow: auto;" class="ui-widget-content"></div>
</div>
        <ul class="list-group"></ul>
        <div class="container-fluid">
          <a class="btn pull-left btn-success">Save your Meal</a>
          <div class="btn-toolbar">
            <div class="btn-group"></div>
            <div class="btn-group"></div>
          </div>
        </div>
        <div class="container">
          <h3 class="text-left">Nutrition Data</h3>
          <h3 class="text-left">Price Comparison</h3>
        </div>
        <a></a>
      </div>
    </div>
    <!-- /container -->
  </body>

</html>