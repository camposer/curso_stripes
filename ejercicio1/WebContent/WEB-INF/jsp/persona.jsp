<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Personas</title>
</head>
<body>
	<h1>Personas</h1>
	<form action="" method="post">
		<table>
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
</body>
</html>