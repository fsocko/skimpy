<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="BusinessLogic.*" %>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.script.*"%>
<%@page import="java.io.IOException"%>
<%@include file="home.jsp" %>

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
					name:{
						required:true
					},
					
					emailaddress:{
						required : true,
						email: true
					},
					
					age:"required",
					
					weight:"required",
						
					height:"required",
					
					exercise:"required",
					
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
<%if(session.getAttribute("username") == null){
	response.sendRedirect("login.jsp");
}
	 %>

<form action="signupdets.jsp" method="post" id="myForm">
 <%-- <%Person user = new Person("Skimpy", "skimpy@skimpy.com", "password", 18, "user.setHeight(Double.parseDouble(request.getParameter(\"height\")))", 70, "M", 0); %> --%>
	<h1> Please enter your details:</h1>
	<br><table>
	<tr> <td> Name:</td><td> <input type="text" name="name" ><p class="MyErrors"></p></td></tr>
	<tr><td>  Email:</td><td> <input type="text" name="emailaddress"><p class="MyErrors"></td></tr>
    <tr><td>  Gender: </td><td> <select name="gender">
                                    <option value="male">Male</option> 
                                    <option value="female">Female</option>
                                </select></td></tr>
                                
	<tr><td> Age: </td><td><input type="text" name="age" ><p class="MyErrors"></p></td></tr>
	<tr><td> Weight:</td><td><input type="text" name="weight"><p class="MyErrors"></p></td></tr>
	<tr> <td>Height: </td> <td><input type="text" name="height" ><p class="MyErrors"></p></td></tr>
	<tr><td> Exercise</td><td> <input type="text" name="exercise" ><p class="MyErrors"></p></td></tr>
	<tr><td> Password: </td><td><input type="password" name="password"  ><p class="MyErrors"></p></td></tr>
     </table>
			<input type="submit" value="Save">
		
</form>
</body>
</html>


















