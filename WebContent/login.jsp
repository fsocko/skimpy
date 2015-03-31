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
					email:{
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
<style>
	.myErrors {
	color:red;
	}
</style>

</head>
<body>
<%session.invalidate(); %>
<form action="logindets.jsp" method="post" id="myForm">
<h1> Please Log In:</h1>
<fieldset width="500px">
	<br><table>
	<tr> <td> Email:</td><td> <input type="text" name="email" ><p class="MyErrors"></p></td></tr>
	<tr><td> Password:</td><td> <input type="password" name="password"><p class="MyErrors"></td></tr>
	<tr><td> <input type="submit" value="Log In"> </td></tr>
</table>
</fieldset>
</form>
</body>
</html>
