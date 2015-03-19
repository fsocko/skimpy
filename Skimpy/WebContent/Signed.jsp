<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="BusinessLogic.*" %>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.script.*"%>
<%@page import="java.io.IOException"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign up complete</title>

<% Person user = new Person("Skimpy", "skimpy@skimpy.com", "password", 18, 30, 70, 'M', 0);
user.setName(request.getParameter("name"));
user.setAge(Integer.valueOf(request.getParameter("age")));
user.setHeight(Double.parseDouble(request.getParameter("height")));
user.setWeight(Double.parseDouble(request.getParameter("weight")));
user.setGender(request.getParameter("gender").toUpperCase().charAt(0));
user.setExercise(Integer.valueOf(request.getParameter("exercise")));
user.setPassword(request.getParameter("password"));
user.setEmail(request.getParameter("emailaddress"));
DBConnect connect = new DBConnect("skimpy");
connect.pushUser(user);%>
<p>You are now successfully registered with our application. Please, log in and start using our services.</p>
<form action="login.jsp">
	<input type="submit" value="Log In">
</body>
</html>