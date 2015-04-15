<!doctype html>

<html>
  
  <head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <style type="text/css">
      .navbar {
        margin-bottom: 0px;
        padding-bottom: -1px;
      }
      .nav{
        margin-bottom: 0px;
        padding-bottom: -1px;
      }
      /* Main marketing message and sign up button */
      .jumbotron {
        background-color: transparent;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }
      .media {
        margin: 5px;
        padding: 0px; 
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
          <a href="index.jsp" class="navbar-brand"><b>Skimpy</b></a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active">
              <a href="welcome.jsp">Home</a>
            </li>
            <li>
              <a href="enterdetails.jsp">Profile</a>
            </li>
            <li>
              <a href="MealPlan.jsp">Meal Planner</a>
            </li>
            <li>
              <a href="recipe.jsp">Recipe Creator</a>
            </li>
            <li>
              <a href="#">Recipe Explorer</a>
            </li>
          </ul>
          <div class="media">
              <a class="pull-right" href="#"><img class="media-object pull-right" src="https://builder.divshot.com/img/placeholder-64x64.gif" style="width:44px;height:44px;"></a>
              <div class="media-body pull-right">
                <h4 class="media-heading"><%=session.getAttribute("username") %></h4>
                <a href="index.jsp">log out</a>
              </div>
            </div>
        </div>
        <div class="pull-right btn-group btn-group-lg"></div>
      </div>
    </div>
  </body>

</html>