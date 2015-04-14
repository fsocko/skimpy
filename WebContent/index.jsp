<!doctype html>

<html>
  
  <head>
    <title>Welcome!</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <style type="text/css">
      .navbar {
        padding: 5px 10px;
      }
      /* Main marketing message and sign up button */
      .jumbotron {
        background-color: transparent;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }
    </style>
  </head>
  
  <body>
    <div class="container-fluid">
      <div class="navbar navbar-default">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
          </button>
          <a href="#" class="navbar-brand"><b>Skimpy</b></a>
        </div>
        <div class="pull-right btn-group btn-group-lg">
          <a href = "http://localhost:8080/Skimpy/login.jsp" class="btn btn-primary btn-lg">Log In</a>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-8">
          <div class="jumbotron">
            <h1>Welcome!</h1>
            <p class="lead">Skimpy is an application that will help you manage your health and your wallet.<br>
              Skimpy compares the prices of foods with the three of the UK's leading supermarkets.</p>
            <p><a class="btn btn-lg btn-success" href="http://localhost:8080/Skimpy/signup.jsp">Sign Up Today!</a></p>
          </div>
        </div>
        <div class="col-sm-4">
          <div class="well">
            <h1>We Compare</h1>
            <div class="row">
              <div class="col-md-4">
                <a href = "http://www.asda.com" target = "_blank"><img src="http://www.cashforkids.uk.com/wp-content/uploads/2013/07/150a7caf80eb3a2140_xqm6b9pfp.jpg" alt="Asda" style = "width:100%;height:100px"></a>
              </div>
              <div class="col-md-4">
                <a href = "http://www.tesco.com" target = "_blank"><img src="http://2t4u21l1g1dmvlj83x5yim1ct6.wpengine.netdna-cdn.com/files/2012/06/tesco-logo.jpg" alt="Tesco" style = "width:100%;height:100px"></a>
              </div>
              <div class="col-md-4">
                <a href = "http://www.sainsburys.co.uk" target = "_blank"><img src="https://www.eurocarparks.com/wp-content/uploads/2014/03/sainsbury_s.jpg" alt="Sainsbury's" style = "width:100%;height:100px"></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>

</html>