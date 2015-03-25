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
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script>
		var formatDate = function(date){
			if (date)
		    	return (date.getMonth() + 1) + 
			    	"/" +  date.getDate() +
			    	"/" +  date.getFullYear();
			else
				return "";
		};	
	
		var enviar = function() {
			var guardar = document.getElementById("guardar");
			var personaId = document.getElementById("personaId").value;

			if (personaId)
				guardar.name= "modificar";
			
			if (!document.getElementById("nombre").value) {
				window.alert("Falta el nombre");
//				return false;
			}
			
			return true;
		};
		
		$(document).ready(function() {
			var url = "Persona.action?listar=";
			
			$.ajax(url, {
				type: "get"
			}).done(function(response) {
				var personas = eval(response);
				var html = "";
				for (var i in personas) {
					var correo = personas[i].correoElectronico; 
					
					html += "<tr>";
					html += "<td>" + personas[i].id + "</td>";
					html += "<td>" + personas[i].nombre + "</td>";
					html += "<td>" + personas[i].apellido + "</td>";
					html += "<td>" + correo + "</td>";
					html += "<td>" + formatDate(personas[i].fechaNacimiento) + "</td>";
					html += "<td><a href='${contextPath}/Persona.action?mostrar=&personaId=" + personas[i].id + "'>mostrar</a></td>";
					html += "<td><a href='${contextPath}/Persona.action?eliminar=&personaId=" + personas[i].id + "'>eliminar</a></td>";
					html += "</tr>";
				}
				
				
				$("#tabla-personas tbody").html(html);
			});
		});
	</script>
</head>
<body>
	<h1>Personas</h1>
	<s:form name="personaForm" beanclass="action.PersonaActionBean" method="post">
		<s:errors/>
		<s:hidden name="persona.id" id="personaId"/>
		<table id="form-persona" class="tabla-centrada tabla-formulario">
			<tr>
				<td><s:label for="persona.nombre"/>:</td>
				<td><input id="nombre" type="text" name="persona.nombre" value="${actionBean.persona.nombre}"></td>
			</tr>
			<tr>
				<td><s:label for="persona.apellido"/>:</td>
				<td><s:text name="persona.apellido"/></td>
			</tr>
			<tr>
				<td><s:label for="persona.correoElectronico"/>:</td>
				<td><s:text name="persona.correoElectronico"/></td>
			</tr>
			<tr>
				<td><s:label for="persona.fechaNacimiento"/>:</td>
				<td>
					<s:text name="persona.fechaNacimiento" formatPattern="dd-MM-yyyy"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<s:submit id="guardar" name="agregar" value="Guardar" onclick="return enviar()"/>
				</td>
			</tr>
		</table>
	</s:form>
	
	<br>
	
	<table id="tabla-personas" class="tabla-centrada tabla-datos">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Correo</th>
				<th>Fecha de Nacimiento</th>
				<th>Mostrar</th>
				<th>Eliminar</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>	
	
</body>
</html>








