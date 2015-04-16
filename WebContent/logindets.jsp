<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="BusinessLogic.*" %>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date" %>
<%@page import="javax.script.*"%>
<%@page import="java.io.IOException"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="0; url=http://localhost:8080/Skimpy/home.jsp" />
<title>Log In</title>
</head>
<body>
<form action="welcome.jsp" method="post"></form>
<%! String userdbEmail;
	String userdbPswd;
	String userdbN;
	Date userdbDOB;
	double userdbWeight;
	char userdbGender;
	String userdbEx;
	double userdbHeight;
	int userdbAge;
	String userID;
	
	DBConnect con = new DBConnect();
	Person sessionUser = null;
%>
<% 

String email = request.getParameter("email");
String password = request.getParameter("password");
sessionUser = con.pullUser(email);

if((!(email.equals(null) || email.equals("")) && !(password.equals(null) || password.equals("")) )){
	userID = sessionUser.getID();
	userdbN = sessionUser.getName();
	userdbEmail = sessionUser.getEmail();
	userdbPswd = sessionUser.getPassword();
	userdbHeight = sessionUser.getHeight();
	userdbEx= sessionUser.getExerciseDisplay();
	userdbWeight = sessionUser.getWeight();
	userdbGender = sessionUser.getGender();
	userdbAge = sessionUser.getAge();
	userdbDOB = sessionUser.getDob(); 
	System.out.println(email);
	System.out.println(userdbEmail);
//	java.util.Date DOB = new Date(userdbDOB.getTime());
	if(email.equals(userdbEmail) && password.equals(userdbPswd)){
		System.out.println("Step Two");
		session.setAttribute("email", email);
		session.setAttribute("password", userdbPswd);
		session.setAttribute("username", userdbN);
 		session.setAttribute("dob", userdbDOB);
 		session.setAttribute("age", userdbAge);
		session.setAttribute("exercise", userdbEx);
		session.setAttribute("weight", userdbWeight);
		session.setAttribute("height", userdbHeight);
		session.setAttribute("gender", userdbGender);
		session.setAttribute("ID", userID);
		
		session.setMaxInactiveInterval(3000);
		response.sendRedirect("home.jsp");
	} else {
		response.sendRedirect("error.jsp");
		con.closeCon();
	}
}else{
%>
	<center><p style="color:red">Error In Login</p></center>
<% getServletContext().getRequestDispatcher("/login.jsp").include(request,response);
}
%>
</body>
</html>