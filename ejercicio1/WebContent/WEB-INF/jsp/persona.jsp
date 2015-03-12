<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="comun.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Personas</title>
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/comun.css">
	<style>
		#form-persona tr:last-child td {
			text-align: center;
		}
		
		#tabla-personas td:nth-child(1),
		#tabla-personas td:nth-child(4),
		#tabla-personas td:nth-child(5),
		#tabla-personas td:nth-child(6) {
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>Personas</h1>
	<form action="" method="post">
		<table id="form-persona" class="tabla-centrada tabla-formulario">
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre"></td>
			</tr>
			<tr>
				<td>Apellido:</td>
				<td><input type="text" name="apellido"></td>
			</tr>
			<tr>
				<td>Fecha de Nacimiento:</td>
				<td><input type="text" name="fechaNacimiento"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="guardar">
				</td>
			</tr>
		</table>
	</form>
	
	<br>
	
	<table id="tabla-personas" class="tabla-centrada tabla-datos">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Fecha de Nacimiento</th>
				<th>Mostrar</th>
				<th>Eliminar</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>Juan</td>
				<td>Pérez</td>
				<td>2012-02-01</td>
				<td><a href="#">mostrar</a></td>
				<td><a href="#">eliminar</a></td>
			</tr>
			<tr>
				<td>1</td>
				<td>Juan</td>
				<td>Pérez</td>
				<td>2012-02-01</td>
				<td><a href="#">mostrar</a></td>
				<td><a href="#">eliminar</a></td>
			</tr>
			<tr>
				<td>1</td>
				<td>Juan</td>
				<td>Pérez</td>
				<td>2012-02-01</td>
				<td><a href="#">mostrar</a></td>
				<td><a href="#">eliminar</a></td>
			</tr>
		</tbody>
	</table>	
	
</body>
</html>








