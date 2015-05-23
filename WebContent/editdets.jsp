<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="BusinessLogic.*" %>

<%@page import="java.util.Date"%>
<%@page import ="java.text.SimpleDateFormat" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/png" href="images/icon.png">
</head>
<meta http-equiv="refresh" content="0; url=http://localhost:8080/Skimpy/home.jsp" />
<body>
<%
DBConnect con = new DBConnect();
Person user = con.pullUser(String.valueOf(session.getAttribute("ID")));
String name = request.getParameter("name");
String email = request.getParameter("email");
char gender = request.getParameter("gender").toUpperCase().charAt(0);
String date = request.getParameter("date");
String month = request.getParameter("month");
String year = request.getParameter("year"); 
String dobString = year +"-"+month+"-"+date;
Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobString);
if((!(request.getParameter("height").equals("null")) )){
	double height = Double.parseDouble(request.getParameter("height"));
	
	user.setHeight(height);
	session.setAttribute("height", height);

}else{
	%> 
	<script type="text/javascript">
	alert("Please enter your height");
	window.location.href = "/Skimpy/edit.jsp";
		
	</script>
<%}
	

	
		
			if((!(request.getParameter("weight").equals("null")) )){
			double weight = Double.parseDouble(request.getParameter("weight"));
		
			user.setWeight(weight);
			session.setAttribute("weight", weight);
			}else{
			%> 
			<script type="text/javascript">
			alert("Please enter your weight");
			window.location.href = "/Skimpy/edit.jsp";
			</script>	
		<%}
		
		
		if((!(request.getParameter("exercise").equals("null")) )){
			int exercise = Integer.parseInt(request.getParameter("exercise"));
	
			user.setExercise(exercise);
			session.setAttribute("exercise", user.getExerciseDisplay());
			session.setAttribute("exerciseNo", exercise);
			}else{
			%> 
			<script type="text/javascript">
			alert("Please enter an exercise from the following options");
			window.location.href = "/Skimpy/edit.jsp";
			</script>	
		<%}
	
		user.setName(name);
		session.setAttribute("username", name);
		user.setEmail(email);
		session.setAttribute("email", email);
		user.setDob(dob);
		session.setAttribute("dob", dob);
		session.setAttribute("Day", user.getDay(dob));
		session.setAttribute("Month", user.getMonth(dob));
		session.setAttribute("Year", user.getYear(dob));
		
		session.setAttribute("DD", String.valueOf(user.getDay(dob)));
		session.setAttribute("MM", user.getMonthNo(user.getDob()));
		session.setAttribute("YYYY", String.valueOf(user.getYear(user.getDob())));
		
		session.setAttribute("age", user.setAge(dob));
		user.setGender(gender);
		session.setAttribute("gender", gender);
		
		user.resetMacros();
		
		session.setAttribute("BMI", user.getMacros().getBMR());
		session.setAttribute("calories", user.getMacros().getCalories());
		session.setAttribute("protein", user.getMacros().getProtein());
		session.setAttribute("carbs", user.getMacros().getCarbs());
		session.setAttribute("sugar", user.getMacros().getSugars());
		session.setAttribute("fat", user.getMacros().getFat());
		session.setAttribute("saturates",user.getMacros().getSaturates());
		session.setAttribute("fibre", user.getMacros().getFibre());
		session.setAttribute("salt", user.getMacros().getSalt());

		con.updateUser(user);
%>
</body>
</html>