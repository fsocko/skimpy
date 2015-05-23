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
<title>Edit Password</title>
<link rel="icon" type="image/png" href="images/icon.png">
</head>
<meta http-equiv="refresh" content="0; url=http://localhost:8080/Skimpy/home.jsp" />
<body>
<%
DBConnect con = new DBConnect();
Person user = con.pullUser(String.valueOf(session.getAttribute("ID")));

String oldPassword = request.getParameter("old password");
String oldPasswordHash = PasswordHash.getSecurePassword(oldPassword);
String newPassword = request.getParameter("new password");
String confirmPassword = request.getParameter("confirm password");

String password = user.getPassword();
if(oldPasswordHash.equals(password) && newPassword.equals(confirmPassword)){
	String newPasswordHash = PasswordHash.getSecurePassword(newPassword);
	user.setPassword(newPasswordHash);
	session.setAttribute("password", newPasswordHash);
}

con.updateUser(user);
%>

</body>
</html>