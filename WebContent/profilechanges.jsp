<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="BusinessLogic.*" %>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import ="java.text.SimpleDateFormat" %>
<%@page import="javax.script.*"%>
<%@page import="java.io.IOException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<meta http-equiv="refresh" content="0; url=http://localhost:8080/Skimpy/login.jsp" />
<body>
<form action="welcome.jsp" method ="post">
</form>
<%String userID = (String)session.getAttribute("userID"); 
 DBConnect connect = new DBConnect();
Person user = connect.pullUser(userID);
user.setName(request.getParameter("name"));
user.setEmail(request.getParameter("emailaddress"));
user.setPassword(request.getParameter("password"));
user.setGender(request.getParameter("gender").toUpperCase().charAt(0));

String date = request.getParameter("date");
String month = request.getParameter("month");
String year = request.getParameter("year"); 
String dobString = year +"-"+month+"-"+date;
Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobString);
user.setDob(dob);
connect.pushUser(user);
%>

</body>
</html>