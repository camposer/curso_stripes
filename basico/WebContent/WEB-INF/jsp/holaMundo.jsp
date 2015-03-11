<%@page import="action.HolaMundoActionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Hola mundo</title>
</head>
<body>
	<ul>
		<li>http://localhost:8080/basico/ejemplo/HolaMundo.action</li>
		<li>http://localhost:8080/basico/ejemplo/HolaMundo.action?cambiarNombre=</li>
	</ul>
	
	<%-- ((HolaMundoActionBean)request.getAttribute("actionBean"))
		.setNombre("Definido en la JSP") --%>
			
	Hola mundo (EL)! ${actionBean.nombre}<br>
	Hola mundo (Java)! <%= ((HolaMundoActionBean)request.getAttribute("actionBean")).getNombre() %>
</body>
</html>