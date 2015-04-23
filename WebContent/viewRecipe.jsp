<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="java.io.FileWriter" %>
<%@page import="java.util.Arrays" %>
<%@ page language="java" contentType="text/html" %>
<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.io.Writer"%>
<%@page import="java.nio.charset.Charset"%>
<%@include file="header.jsp" %>

<html>
<head>
<title>Saving Meal</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <style type="text/css">
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

 <%
  XMLParser writeX = new XMLParser();
  ArrayList<Meal> readmeals = new ArrayList<Meal>();
  readmeals = writeX.readMeals(getServletContext().getRealPath("") + "/meals.xml");
  //String name= String.valueOf(session.getAttribute("name"));
  String name = "Tuna Pasta Salad";
  Meal themeal = writeX.getMeal(readmeals, name);
 %>
    	
   <div class="container-fluid">
      <div class="row">
              <div class="col-sm-7">
          <div class="well">
            <div class="row">
              <div class="col-sm-12">
                <div class="media">
               
                  <div class="media-body">
                    <div class="row">
                 
                      <div class="col-sm-8">
                        <h4><%=themeal.getName() %></h4>
                      </div>
                      <div class="col-sm-4">
                        <a href = "editRecipe.jsp" class="btn pull-right btn-primary btn-md">Edit</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-sm-8">
     <%for (int i=0; i< themeal.getIngredients().size();i++){
	                %>
	                
	                
	                 <div class="col-sm-8">
                        <span ><%=themeal.getIngredients().get(i).getName().replace(";", "")%></span>
                      </div>
                      <input name="mass" id ="mass" value="<%=themeal.getMasses().get(i)%>">
                    <% }%>
              </div>

            </div>
          </div>

        </div>
      
      
        <div class="col-sm-5">
          <div class="well">
            <div class="row">
              <div class="col-sm-12">
                <div class="row">
                  <div class="col-sm-12">
                    <h4>Meal Nutrition:</h4>
                  </div>
                  <div class="col-sm-12">
                    <div class="row">
                      <div class="col-sm-4">
                        <span class="label label-info">Calories</span>
                      </div>
                      <div class="col-sm-8">
                        <p><%=themeal.mealCal() %> kcal</p>
                      </div>
                      <div class="col-sm-4">
                        <span class="label label-info">Protein</span>
                      </div>
                      <div class="col-sm-8">
                        <p><%=themeal.mealProt() %> g</p>
                      </div>
                      <div class="col-sm-4">
                        <span class="label label-info">Carbohydrates</span>
                      </div>
                      <div class="col-sm-8">
                        <p><%=themeal.mealCarb() %> g</p>
                      </div>
                      <div class="col-sm-4">
                        <span class="label label-info">Sugar</span>
                      </div>
                      <div class="col-sm-8">
                        <p><%=themeal.mealSugar() %> g</p>
                      </div>
                      <div class="col-sm-4">
                        <span class="label label-info">Fat</span>
                      </div>
                      <div class="col-sm-8">
                        <p><%=themeal.mealFat() %> g</p>
                      </div>
                      <div class="col-sm-4">
                        <span class="label label-info">Saturates</span>
                      </div>
                      <div class="col-sm-8">
                        <p><%=themeal.mealSat() %> g</p>
                      </div>
                      <div class="col-sm-4">
                        <span class="label label-info">Fibre</span>
                      </div>
                      <div class="col-sm-8">
                        <p><%=themeal.mealFibr() %> g</p>
                      </div>
                      <div class="col-sm-4">
                        <span class="label label-info">Salt</span>
                      </div>
                      <div class="col-sm-8">
                        <p><%=themeal.mealSalt() %> g</p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-sm-12">
                <div class="row">
                  <div class="col-md-12">
                    <h4>Price Optimisation</h4>
                  </div>
                </div>
              </div>
              <div class="col-sm-12">
                <div class="row">
                  <div class="col-md-12">
                    <div class="progress">
                      <div class="progress-bar" style="width: 40%;"></div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-sm-12">
                <div class="row">
                  <div class="col-md-12">
                    <h4>Nutrition Optimisation</h4>
                  </div>
                </div>
              </div>
              <div class="col-sm-12">
                <div class="row">
                  <div class="col-md-12">
                    <div class="progress">
                      <div class="progress-bar" style="width: 40%;"></div>
                    </div>
                  </div>
                </div>
              </div>
              
            </div>
          </div>
        </div>

      </div>
    </div>   	
    	
    	
    	
    	
    	
    	




 	
</body>
</html>