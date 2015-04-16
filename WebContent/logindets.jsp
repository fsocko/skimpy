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
<meta http-equiv="refresh" content="0; url=http://localhost:8080/Skimpy/welcome.jsp" />
<title>Insert title here</title>
</head>
<body>
<form action="welcome.jsp" method="post"></form>
<%! String userdbName;
	String userdbPswd;
	String userdbN;
	Date userdbDOB;
	double userdbWeight;
	char userdbGender;
	int userdbEx;
	double userdbHeight;
	String userID;
%>
<% 
Connection con = null;
Statement st = null;
ResultSet rs = null;


String driverName = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/Skimpy";
String user = "root";
String psw = "";

String username = request.getParameter("email");
String password = request.getParameter("password");
String sql = "select * FROM user_info where UserEmail LIKE'" + username + "'";
if((!(username.equals(null) || username.equals("")) && !(password.equals(null) || password.equals("")) )){
try{
	Class.forName(driverName);
	con = DriverManager.getConnection(url, user, psw);
	st = con.prepareStatement(sql);
	rs = st.executeQuery(sql);
	if(rs.next()){
		
		userID = rs.getString("UserID");
		userdbN = rs.getString("UserName");
		userdbName = rs.getString("UserEmail");
		userdbHeight = rs.getFloat("Height");
		userdbEx= rs.getInt("Exercise");
		userdbWeight = rs.getFloat("Weight");
		userdbGender = rs.getString("Gender").charAt(0);
		/* userdbDOB =rs.getDate("DateOfBirth"); 
		java.util.Date DOB = new Date(userdbDOB.getTime()); */

		
		System.out.println(userdbN);
		System.out.println(userID);
		userdbPswd = rs.getString("UserPassword");
		if(username.equals(userdbName) && password.equals(userdbPswd)){
			session.setAttribute("email", username);
			session.setAttribute("password", userdbPswd);
			session.setAttribute("username", userdbN);
  			session.setAttribute("dob", userdbDOB);
			session.setAttribute("exercise", userdbEx);
			session.setAttribute("weight", userdbWeight);
			session.setAttribute("height", userdbHeight);
			session.setAttribute("gender", userdbGender);
			session.setAttribute("ID", userID);
			
			session.setMaxInactiveInterval(3000);
			response.sendRedirect("home.jsp");
		} else {
			response.sendRedirect("error.jsp");
			rs.close();
			st.close();
		}
	}
	else
		response.sendRedirect("error.jsp");
		rs.close();
		st.close();
}catch(Exception ex){
	System.out.println(ex);
}
}else{
%>
	<center><p style="color:red">Error In Login</p></center>
<% getServletContext().getRequestDispatcher("/login.jsp").include(request,response);
}
%>
</body>
</html>