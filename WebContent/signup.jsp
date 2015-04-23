<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.script.*"%>
<%@page import="java.io.IOException"%>
 
  <head>
    <title>Sign Up</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<link href="css/datepicker.css" rel="stylesheet">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
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
    
       label.valid {
			width: 24px;
  			height: 24px;
 			background: url(assets/img/valid.png) center center no-repeat;
 			display: inline-block;
  			text-indent: -9999px;
		}
		
		label.error {
  			font-weight: bold;
  			color: red;
  			padding: 2px 8px;
  			margin-top: 2px;
		}
		
		.form-signup input[type="text"] {
        margin-bottom: 10px;
      }
      .form-signup input[type="password"] {
        margin-bottom: 10px;
      } 
		
		 .birthday-drop {
        margin-bottom:10px;
      }
      .birthday-drop .form-control {
        position: relative;
        font-size: 18px;
        display:inline-block;
        height: auto;
        width: auto;
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
   <div class="form-signup">
      <form action="signupdets.jsp" method="post" id="myForm">
      <fieldset>
          <div class="control-group"> 
          	<div class="controls"> 
            	<input type="text" class="form-control" name="name" id="name" placeholder="Username">
            	 <input type="text" class="form-control" name="email" id="email" placeholder="Email">
            	 <input type="password" class="form-control" name="password" id="password" placeholder="Password">
            </div>
          </div>
          <div class="control-group"> 
            <label class="control-label" for="birthday" id="birthday">Birthday</label>
            <div class="birthday-drop">
              <input type="text" name="datepicker" id="datepicker">
                
            </div>
              <select name="gender"  class="form-control">
              <option value="0" selected>Gender</option>
              <option value="male">Male</option> 
              <option value="female">Female</option>
              </select>
              
              
              <br>
             
            <button class="btn btn-block btn-success btn-lg" type="submit">Sign up</button>
          </div>
       </fieldset>   
      </form>
      </div>
      
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.11/jquery-ui.min.js"></script>
	
    <script type="text/javascript"> 
    $(document).ready(function(){
    	
    	
      $('#myForm').validate({
          rules:{
        	  
        	  	name:{
        	  		minlength: 2,
        	  		required:true
        	  	},
            
        	  	email:{
            	 	required : true,
              		email: true
           	 	},
            
            	password:{
              		required: true
            	},
           	 
            	gender:{
                        selectcheck: true
                },
                 
          },    
      })
      .find('[name="datepicker"]').datepicker());
      jQuery.validator.addMethod('selectcheck', function (value) {
          return (value != '0');
      }, "Gender required");
    }); 
    </script>  
  </body>
</html>
