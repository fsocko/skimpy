<%@ page language="java" contentType="application/javascript"
    pageEncoding="ISO-8859-1"%>
<%@ page import="BusinessLogic.DBConnect" %>
<%@ page import="org.json.JSONArray" %>

<%
	DBConnect dbConn = new DBConnect();
	out.println(dbConn.jsonSearch(request.getParameter("q"), request.getParameterValues("cat[]")));
%>