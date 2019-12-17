<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido a cineapp</title>
</head>
<body>
	<h1>Tabla de peliculas</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Titulo</th>
				<th>Duracion</th>
				<th>Clasificacion</th>
				<th>Genero</th>	
			</tr>		
		</thead>
		
		<tbody>
			<c:forEach items="${peliculas}" var="pelicula">
				<tr>
					<td>${pelicula.id}</td>
					<td>${pelicula.titulo}</td>
					<td>${pelicula.duracion}</td>
					<td>${pelicula.clasificacion}</td>
					<td>${pelicula.genero}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>