<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="BusinessLogic.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="0; url=http://localhost:8080/Skimpy/home.jsp" />
<title>Log In</title>
</head>
<body>
<% 
DBConnect con = new DBConnect();
Person sessionUser = null;
String email = request.getParameter("email");
String password = request.getParameter("password");

int sessionID = con.getIDfromEmail(email);
sessionUser = con.pullUser(String.valueOf(sessionID));

if((!(email.equals(null) || email.equals("")) && !(password.equals(null) || password.equals("")) )){
	if(email.equals(sessionUser.getEmail()) && password.equals(sessionUser.getPassword())){
		session.setAttribute("username", sessionUser.getName());
		session.setAttribute("email", sessionUser.getEmail());
		session.setAttribute("password", sessionUser.getPassword());
 		session.setAttribute("dob", sessionUser.getDob());
 		session.setAttribute("age", sessionUser.getAge());
		session.setAttribute("height", sessionUser.getHeight());
		session.setAttribute("weight", sessionUser.getWeight());
		session.setAttribute("exercise", sessionUser.getExerciseDisplay());
		session.setAttribute("exerciseNo", sessionUser.getExercise());
		session.setAttribute("genderChar", sessionUser.getGender());
		session.setAttribute("genderDisp", sessionUser.getGenderDisp(sessionUser.getGender()));
		session.setAttribute("ID", sessionID);
		
		sessionUser.resetMacros();
		
		session.setAttribute("Day", sessionUser.getDay(sessionUser.getDob()));
		session.setAttribute("Month", sessionUser.getMonth(sessionUser.getDob()));
		session.setAttribute("Year", sessionUser.getYear(sessionUser.getDob()));
		
		session.setAttribute("DD", String.valueOf(sessionUser.getDay(sessionUser.getDob())));
		session.setAttribute("MM", sessionUser.getMonthNo(sessionUser.getDob()));
		session.setAttribute("YYYY", String.valueOf(sessionUser.getYear(sessionUser.getDob())));
		
		session.setAttribute("BMI", sessionUser.getMacros().getBMR());
		session.setAttribute("calories", sessionUser.getMacros().getCalories());
		session.setAttribute("protein", sessionUser.getMacros().getProtein());
		session.setAttribute("carbs", sessionUser.getMacros().getCarbs());
 		session.setAttribute("sugar", sessionUser.getMacros().getSugars());
 		session.setAttribute("fat", sessionUser.getMacros().getFat());
		session.setAttribute("saturates",sessionUser.getMacros().getSaturates());
		session.setAttribute("fibre", sessionUser.getMacros().getFibre());
		session.setAttribute("salt", sessionUser.getMacros().getSalt());
		
		session.setMaxInactiveInterval(3000);
		response.sendRedirect("home.jsp");
	} 
	else {
		response.sendRedirect("error.jsp");
		con.closeCon();
	}
}
else{
%>
	<center><p style="color:red">Error In Login</p></center>
<% getServletContext().getRequestDispatcher("/login.jsp").include(request,response);
}
%>
</body>
</html>