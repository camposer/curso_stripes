<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] numeros = new String[] { "uno", "dos", "tres" };
%>
	
		<html>
		<head><title>Hola mundo</title></head>
		<body>

		Hola mundo <br>
		<table border='1'>
		
		<%
		for (String n : numeros) {
		%>
			<tr><td><%= n %></td></tr>
		<%
		}
		%>
		
		</table>
		
		</body>
		</html>
    