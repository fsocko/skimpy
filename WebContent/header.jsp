<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="BusinessLogic.*" %>
<html>
  
  <head>
    <title><%= pageTitle %></title>
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
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="css/search.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/search.js"></script>
    
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
            <li <% if (currentPage.equals("home") && currentPage != null ) { out.print("class=\"active\""); } %>>
              <a href="home.jsp">Home</a>
            </li>
            <li <% if (currentPage.equals("shopping_list") && currentPage != null ) { out.print("class=\"active\""); } %>>
              <a href="ShoppingList.jsp">My Shopping List</a>
            </li>
            <li <% if (currentPage.equals("meal_plan") && currentPage != null) { out.print("class=\"active\""); } %>>
              <a href="usermealplan.jsp">Meal Planner</a>
            </li>
            <li <% if (currentPage.equals("recipe") && currentPage != null) { out.print("class=\"active\""); } %>>
              <a href="recipe.jsp">Recipe Creator</a>
            </li>
            <li <% if (currentPage.equals("explorer") && currentPage != null) { out.print("class=\"active\""); } %>>
              <a href="recipeExplorer.jsp">Recipe Explorer</a>
            </li>
          </ul>
          <div class="media">
            <a class="pull-right" href="#"><img class="media-object pull-right" src="https://builder.divshot.com/img/placeholder-64x64.gif" style="width:45px;height45px;"></a>
            <div class="media-body pull-right">
              <h4 class="media-heading"><%=session.getAttribute("username") %></h4>
              <a href="logout.jsp">log out</a>
            </div>
          </div>
        </div>
        <div class="pull-right btn-group btn-group-lg"></div>
      </div>
     </div>

     