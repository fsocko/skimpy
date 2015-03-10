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
<title>Insert title here</title>
</head>
<body>

<form action="login.jsp" method="post">
 <%-- <%Person user = new Person("Skimpy", "skimpy@skimpy.com", "password", 18, "user.setHeight(Double.parseDouble(request.getParameter(\"height\")))", 70, 'M', 0); %> --%>
	<h1> Please enter your details:</h1>
	<br><table>
	<tr> <td> Name:</td><td> <input type="text" name="name" > </td></tr>
	<tr><td>  Email:</td><td> <input type="text" name="emailaddress"> (Use format name@company.com) </td></tr>
    <tr><td>  Gender: </td><td> <select name="gender">
                                    <option value="male">Male</option> 
                                    <option value="female">Female</option>
                                </select></td></tr>
	<tr><td> Age: </td><td><input type="text" name="age" ></td></tr>
	<tr><td> Weight:</td><td><input type="text" name="weight"></td></tr>
	<tr> <td>Height: </td> <td><input type="text" name="height" ></td></tr>
	<tr><td> Exercise</td><td> <input type="text" name="exercise" ></td></tr>
	<tr><td> Password: </td><td><input type="text" name="password"  ></td></tr>
     </table>
			<input type="submit" value="Save">
		
</form>
</body>
</html>