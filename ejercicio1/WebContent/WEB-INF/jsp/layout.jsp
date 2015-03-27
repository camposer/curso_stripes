<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="comun.jsp" %> 

<s:layout-definition> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Stripes framework</title>
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/comun.css"">
	<style>
		#cabecera {
			background-color: grey;
		}
		#menu {
			float: left;
			width: 10%;
		}
		#contenido {
			float: left;
			width: 90%;
		}
		#footer {
			background-color: grey;
			clear: both;
		}
	</style>
	<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
	<div id="cabecera">Cabecera</div>
	<div id="menu">
		<s:link beanclass="action.InicioActionBean">Inicio</s:link>
		<s:link beanclass="action.PersonaActionBean">Persona</s:link>
	</div>
	<div id="contenido"><s:layout-component name="contenido"/></div>
	<div id="footer">Footer</div>
</body>
</html>
</s:layout-definition>