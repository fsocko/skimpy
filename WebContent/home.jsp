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
        margin-bottom: 5px;
        padding-bottom: -1px;
      }
      .nav {
        margin-bottom: 0px;
        padding-bottom: -1px;
      }
      .media {
        margin: 2px;
        padding: 0px;
      }
      .col-sm-12 .media {
        margin-bottom: 10px;
        margin-left: 0;
        padding-left: 0;
      }
      .row h4 {
        margin: 0px;
        padding-bottom: 5px;
      }
      .media-body p {
        margin: 0px;
        padding-bottom: 0px;
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
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active">
              <a href="#">Home</a>
            </li>
            <li>
              <a href="#">My Shopping List</a>
            </li>
            <li>
              <a href="MealPlan.jsp">Meal Planner</a>
            </li>
            <li>
              <a href="recipe.jsp">Recipe Creator</a>
            </li>
          </ul>
          <div class="media">
            <a class="pull-right" href="#"><img class="media-object pull-right" src="https://builder.divshot.com/img/placeholder-64x64.gif" style="width:45px;height45px;"></a>
            <div class="media-body pull-right">
              <h4 class="media-heading">Username</h4>
              <a href="logout.jsp">log out</a>
            </div>
          </div>
        </div>
        <div class="pull-right btn-group btn-group-lg"></div>
      </div>
      <div class="row">
        <div class="col-sm-5">
          <div class="well">
            <div class="row">
              <div class="col-sm-12">
                <div class="row">
                  <div class="col-sm-12">
                    <h4>Your GDA:</h4>
                  </div>
                  <div class="col-sm-12">
                    <div class="row">
                      <div class="col-sm-4">
                        <span class="label label-info">Calories</span>
                      </div>
                      <div class="col-sm-8">
                        <p>0</p>
                      </div>
                      <div class="col-sm-4">
                        <span class="label label-info">Protein</span>
                      </div>
                      <div class="col-sm-8">
                        <p>0</p>
                      </div>
                      <div class="col-sm-4">
                        <span class="label label-info">Sugar</span>
                      </div>
                      <div class="col-sm-8">
                        <p>0</p>
                      </div>
                      <div class="col-sm-4">
                        <span class="label label-info">Fat</span>
                      </div>
                      <div class="col-sm-8">
                        <p>0</p>
                      </div>
                      <div class="col-sm-4">
                        <span class="label label-info">Saturates</span>
                      </div>
                      <div class="col-sm-8">
                        <p>0</p>
                      </div>
                      <div class="col-sm-4">
                        <span class="label label-info">Fibre</span>
                      </div>
                      <div class="col-sm-8">
                        <p>0</p>
                      </div>
                      <div class="col-sm-4">
                        <span class="label label-info">Salt</span>
                      </div>
                      <div class="col-sm-8">
                        <p>0</p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-sm-12">
                <div class="row">
                  <div class="col-md-4">
                    <h4>Price Optimisation</h4>
                  </div>
                  <div class="col-md-4">
                    <div class="progress">
                      <div class="progress-bar" style="width: 40%;"></div>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <h4>Nutrition Optimisation</h4>
                  </div>
                  <div class="col-md-4">
                    <div class="progress">
                      <div class="progress-bar" style="width: 40%;"></div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-sm-7">
          <div class="well">
            <div class="row">
              <div class="col-sm-12">
                <div class="media">
                  <a class="pull-left" href="#">    <img class="media-object" src="https://builder.divshot.com/img/placeholder-64x64.gif">  </a>
                  <div class="media-body">
                    <div class="row">
                      <div class="col-sm-8">
                        <h4>Username</h4>
                      </div>
                      <div class="col-sm-4">
                        <a href = "edit.jsp" class="btn pull-right btn-primary btn-xs">Edit</a>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-sm-12">
                        <p>Name surname</p>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-sm-12">
                        <p>email</p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-sm-8">
                <div class="row">
                  <div class="col-sm-4">
                    <span class="label label-info">Height</span>
                  </div>
                  <div class="col-sm-8">
                    <p>0</p>
                  </div>
                  <div class="col-sm-4">
                    <span class="label label-info">Weight</span>
                  </div>
                  <div class="col-sm-8">
                    <p>0</p>
                  </div>
                  <div class="col-sm-4">
                    <span class="label label-info">Exercise Level</span>
                  </div>
                  <div class="col-sm-8">
                    <p>0</p>
                  </div>
                  <div class="col-sm-4">
                    <span class="label label-info">Age</span>
                  </div>
                  <div class="col-sm-8">
                    <p>0</p>
                  </div>
                </div>
              </div>
              <div class="col-sm-4">
                <div class="row">
                  <div class="col-sm-4">
                    <span class="label label-info">BMI</span>
                  </div>
                  <div class="col-sm-8">
                    <p>0</p>
                  </div>
                  <div class="col-sm-4">
                    <span class="label label-info">TDEE</span>
                  </div>
                  <div class="col-sm-8">
                    <p style>0</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="well">
            <img src="https://builder.divshot.com/img/placeholder-100x100.gif">
            <a> Something should go here</a>
          </div>
        </div>
      </div>
    </div>
  </body>

</html>