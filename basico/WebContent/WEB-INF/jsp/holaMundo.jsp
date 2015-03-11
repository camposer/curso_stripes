<%@page import="action.ejemplo.HolaMundoActionBean"%>
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
	// http://localhost:8080/basico/ejemplo/HolaMundo.action
	// http://localhost:8080/basico/ejemplo/HolaMundo.action?cambiarNombre=
	
	<c:set var="${actionBean.nombre}" value="Definido en la JSP"/>
	<%= ((HolaMundoActionBean)request.getAttribute("actionBean"))
		.setNombre("Definido en la JSP") %>
			
	Hola mundo (EL)! ${actionBean.nombre}<br>
	Hola mundo (Java)! <%= ((HolaMundoActionBean)request.getAttribute("actionBean")).getNombre() %>
</body>
</html>