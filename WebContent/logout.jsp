<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Refresh" content="2;url=index.jsp">
 <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<title>Logged Out</title>
<link rel="icon" type="image/png" href="images/icon.png">
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
     

<% session.invalidate(); %>
<p> Thank you, you have successfully logged out! </p>
</div>
</body>
</html>