<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="javax.script.*"%>
<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(session.getAttribute("username") == null){
	response.sendRedirect("login.jsp");
}
	 %>
<%DBConnect con = new DBConnect();
con.search("tesco", Ingredients[i]); %>
<h3> Welcome, <%=session.getAttribute("username") %></h3>
<form action="search.jsp" method="post">
	<input type="text" value="Enter a product">
</form>
</body>
</html>