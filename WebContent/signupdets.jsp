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
</head>
<meta http-equiv="refresh" content="0; url=http://localhost:8080/Skimpy/edit.jsp" />
<body>
<% 
DBConnect con = new DBConnect();

String name = request.getParameter("name");
String email = request.getParameter("email");
String password = request.getParameter("password");
char gender = request.getParameter("gender").toUpperCase().charAt(0);
String date = request.getParameter("datepicker");
System.out.println(date);
String str[] = date.split("/");
String month = str[0];
System.out.println(month);
String day = str[1];
System.out.println(day);
String year = str[2]; 
System.out.println(year);
String dobString = day +"/"+month+"/"+year;
System.out.println(dobString);
Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(dobString);


Person user = new Person(name, email, password, dob, -1, -1, gender, -1);

con.pushUser(user);

int sessionID = con.getIDfromEmail(email);
Person sessionUser = con.pullUser(String.valueOf(sessionID));

session.setAttribute("username", sessionUser.getName());
session.setAttribute("email", sessionUser.getEmail());
session.setAttribute("password", sessionUser.getPassword());
session.setAttribute("dob", sessionUser.getDob());
session.setAttribute("age", sessionUser.getAge());
session.setAttribute("genderChar", sessionUser.getGender());
session.setAttribute("genderDisp", sessionUser.getGenderDisp(sessionUser.getGender()));
session.setAttribute("ID", sessionID);

session.setAttribute("Day", sessionUser.getDay(sessionUser.getDob()));
session.setAttribute("Month", sessionUser.getMonth(sessionUser.getDob()));
session.setAttribute("Year", sessionUser.getYear(sessionUser.getDob()));

session.setAttribute("DD", String.valueOf(sessionUser.getDay(sessionUser.getDob())));
session.setAttribute("MM", sessionUser.getMonthNo(sessionUser.getDob()));
session.setAttribute("YYYY", String.valueOf(sessionUser.getYear(sessionUser.getDob())));
%>

</body>
</html>