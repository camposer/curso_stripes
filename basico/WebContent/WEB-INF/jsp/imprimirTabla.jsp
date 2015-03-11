<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Imprimir tabla</title>
</head>
<body>
	<h1>Imprimir tabla</h1>
	<table border="1">
		<c:forEach var="n" items="${actionBean.numeros}">
			<tr><td>${n}</td></tr>
		</c:forEach>
	</table>
</body>
</html>