<!doctype html>
<%@include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="BusinessLogic.*" %>
<html>
  
  <head>
    <title>Change Password</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script type="text/javascript">
	function showValue(newValue)
	{
		if(newValue == 1){
			document.getElementById("range").innerHTML= "Desk job with little exercise"
		}
		if(newValue == 2){
			document.getElementById("range").innerHTML=	"1-3hrs/week of light exercise"	
		}
		if(newValue == 3){
			document.getElementById("range").innerHTML="3-5hrs/week of moderate exercise"
		}
		if(newValue == 4){
			document.getElementById("range").innerHTML= "5-6hrs/week of strenuous exercise"
		}
		if(newValue == 5){
			document.getElementById("range").innerHTML= "7-21hrs/week of strenuous exercise/work"
		}

	}
	</script>
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
        padding: 0px;
      }
      .media-body p {
        margin: 0px;
        padding-bottom: 0px;
      }
      .birthday-drop {
        margin-bottom:5px;
      }
      .birthday-drop .form-control {
        position: relative;
        font-size: 14px;
        padding: 0px;
        display:inline-block;
        height: auto;
        width: auto;
      }
      .input-sm {
        margin-bottom: 5px;
      }
    </style>
  </head>
  
  <body>
    <%	
  	if(session.getAttribute("username") == null){
		response.sendRedirect("login.jsp");
	}
  	%>
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
          <div class="well">
            <div class="row">
              <div class="col-sm-12">
                <h3>Change Password</h3>
              </div>
              <div class="col-sm-12">
                <form action="passworddets.jsp" method="post" id="myForm">
                  <div class="row">
                    <div class="col-sm-4">
                      <span class="label label-info">Old Password</span>
                    </div>
                    <div class="col-sm-8">
                      <input name = "old password" type="password" class="form-control input-sm">
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-4">
                      <span class="label label-info">New Password</span>
                    </div>
                    <div class="col-sm-8">
                      <input name = "new password" type="password" class="form-control input-sm">
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-4">
                      <span class="label label-info">Confirm New Password</span>
                    </div>
                    <div class="col-sm-8">
                      <input name = "confirm password" type="password" class="form-control input-sm">
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-12">
                      <button class="btn pull-right btn-success">Save Changes</button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="col-sm-2"></div>
      </div>
    </div>
  </body>

</html>