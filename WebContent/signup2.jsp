<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="BusinessLogic.*" %>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.script.*"%>
<%@page import="java.io.IOException"%>

<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:useBean id="userdetails" scope="session" class = "BusinessLogic.Person" /> 
<jsp:useBean id="person" scope="session" class="BusinessLogic.Main" />  --%> 

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	jQuery.validator.setDefaults({
// where to display the error relative to the element
	errorPlacement: function(error, element) {
	error.appendTo(element.parent().find('p.myErrors'));
 }
});

		$("#myForm").validate({
			
				rules:{
					name:{
						required:true
					},
					
					emailaddress:{
						required : true,
						email: true
					},
					
					password:{
						required: true
					},		
				}
		});
	});




</script>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" />
<style type="text/css">
      .form-signup {
        max-width: 330px;
        padding: 0px;
        margin: 0 auto;
      }
      
      .form-signup .form-control {
        position: relative;
        font-size: 18px;
        height: auto;
        padding: 5px;
      }
      
      .form-signup input[type="text"] {
        margin-bottom: 10px;
      }
      
      .form-signup input[type="password"] {
        margin-bottom: 10px;
      }
      
	  .myErrors {
		color:red;
	  }
</style>

</head>
<body>
<div class="container-fluid">
      <div class="navbar navbar-default">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand"><b>Skimpy</b></a>
          </div>
          <div class="collapse navbar-collapse pull-left">
            <ul class="nav navbar-nav"></ul>
          </div>
          <div class="pull-right btn-group btn-group-sm"></div>
          <a class="btn pull-right btn-primary btn-lg">Login</a>
        </div>
      </div>
    </div>
    <div class="container">
    <div class="form-signup">
		<form action="signupdets.jsp" method="post" id="myForm">
 		<%-- <%Person user = new Person("Skimpy", "skimpy@skimpy.com", "password", 18, "user.setHeight(Double.parseDouble(request.getParameter(\"height\")))", 70, "M", 0); %> --%>
		<div class="controls">
	 		<input type="text" name="name" class="form-control" placeholder="Username"><p class="MyErrors"></p>
	 		<input type="text" name="emailaddress" class="form-control" placeholder="Email"><p class="MyErrors">
	 		<input type="password" name="password" class="form-control" placeholder="Password"><p class="MyErrors">
     					<select name="gender">
    								<option value="0" selected>Gender</option>
                                    <option value="male">Male</option> 
                                    <option value="female">Female</option>
                                </select>
   
			<button class="btn btn-block btn-success btn-lg" type="submit">Sign Up</button>
		</div>
</form>
</div>
</div>
</body>
</html>















