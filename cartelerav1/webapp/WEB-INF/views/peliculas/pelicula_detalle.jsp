<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Tags para la libreria JSTL -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Tag para la libreria de spring y el uso de URL relativa -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/" var="urlRoot" />

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Detalles de la pelicula</title>

		<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

	</head>

	<body>

	<!-- Fixed navbar -->
	<jsp:include page="../include/menu.jsp"></jsp:include>

		<div class="container theme-showcase" role="main">

			<!-- Marketing messaging -->
			<div class="container marketing">

				<div class="page-header">
					<h2>${pelicula.titulo}</h2>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<p class="text-center">
							<img class="img-rounded" src="${urlPublic}/images/${pelicula.imagen}" alt="Generic placeholder image" width="155" height="220">            
						</p>
					</div>
					<div class="col-sm-9">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">Detalles</h3>
							</div>
							<div class="card-body">                           
								<p>
									T�tulo Original : ${pelicula.titulo} <br>
									Actores : ${pelicula.detalle.actores} <br>
									Director: ${pelicula.detalle.director} <br>                  
									Clasificaci�n: ${pelicula.clasificacion} <br>
									Duraci�n: ${pelicula.duracion} minutos <br>
									G�nero: ${pelicula.genero} <br>                  
									Fecha Estreno: ${pelicula.fechaEstreno}                  
								</p> 

							</div>
						</div>                          
					</div>
				</div>
				
				<br />

				<div class="card">
					<div class="card-header">
						<h3 class="card-title"><span class="badge badge-success">20-05-2017</span></h3>
					</div>
					<div class="card-body">
						<table class="table table-striped">
							<thead>
								<tr>                  
									<th>Hora</th>
									<th>Sala</th>                                  
									<th>Precio</th>                                  
								</tr>
							</thead>
							<tbody>             
								<tr>                 
									<td>16:00</td>
									<td>Sala 1</td>  
									<td>$10</td>  
								</tr>              
								<tr>                 
									<td>18:00</td>
									<td>Sala 1</td> 
									<td>$10</td>  
								</tr>              
								<tr>                 
									<td>20:00</td>
									<td>Sala 1</td>                        
									<td>$10</td>  
								</tr>              
								<tr>                
									<td>14:00</td>
									<td>Sala 1</td>                       
									<td>$10</td>  
								</tr>              
								<tr>               
									<td>16:00</td>
									<td>Sala 1</td> 
									<td>$10</td>  
								</tr>                             
								<tr>                  
									<td>20:00</td>
									<td>Sala 1</td> 
									<td>$10</td>  
								</tr>              
								<tr>                 
									<td>22:00</td>
									<td>Sala 1</td>  
									<td>$10</td>  
								</tr>              
							</tbody>           
						</table>
					</div>
				</div>

				<br />

				<div class="row">
					<div class="col-sm-7">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">Trailer</h3>
							</div>
							<div class="card-body">
								<iframe width="100%" height="315" 
												src="${pelicula.detalle.trailer}" >                          
								</iframe>
							</div>
						</div>           
					</div> 
					<div class="col-sm-5">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">SINOPSIS</h3>
							</div>
							<div class="card-body">
								<p>${pelicula.detalle.sinopsis}</p>
							</div>
						</div>                          
					</div>
				</div>

			</div><!-- /.container -->

			<hr class="featurette-divider">

			<!-- FOOTER -->
			<jsp:include page="../include/footer.jsp"></jsp:include>

		</div> <!-- /container -->

		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
		<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script> 
	</body>
</html>