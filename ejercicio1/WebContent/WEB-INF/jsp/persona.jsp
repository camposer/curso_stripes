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
	<script>
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
				<td><s:text name="persona.fechaNacimiento"/></td>
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
			<c:forEach var="p" items="${actionBean.personas}">
				<tr>
					<td>${p.id}</td>
					<td>${p.nombre}</td>
					<td>${p.apellido}</td>
					<td>${p.correoElectronico}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${p.fechaNacimiento}"/></td>
					<td>
						<a href="Persona.action?mostrar=&personaId=${p.id}">mostrar</a><!-- No!! -->
					</td>
					<td>
						<s:link beanclass="action.PersonaActionBean"
							event="eliminar">
							<s:param name="personaId">${p.id}</s:param>
							eliminar
						</s:link>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
	
</body>
</html>








