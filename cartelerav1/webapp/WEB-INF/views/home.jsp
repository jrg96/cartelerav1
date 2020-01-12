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
	<title>CineSite | Bienvenido</title>

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
</head>

<body>
	<jsp:include page="include/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<!-- Carousel
    ================================================== -->
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>
			<!-- Image Size 1140 x 250 -->
			<div class="carousel-inner">
				<c:forEach var="banner" items="${banners}" varStatus="status">
					<c:choose>
						<c:when test="${status.first}">
							<div class="carousel-item active">
								<img src="${urlPublic}/images/${banner.archivo}" alt="Slide" title="${banner.titulo}">
							</div>
						</c:when>
						<c:otherwise>
							<div class="carousel-item">
								<img src="${urlPublic}/images/${banner.archivo}" alt="Slide" title="${banner.titulo}">
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			<a class="carousel-control-prev" href="#myCarousel" role="button"
				data-slide="prev"> <span class="carousel-control-prev-icon"
				aria-hidden="true"></span> <span class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#myCarousel" role="button"
				data-slide="next"> <span class="carousel-control-next-icon"
				aria-hidden="true"></span> <span class="sr-only">Next</span>
			</a>
		</div>
		<!-- /.carousel -->

		<br /> <br />
		<div class="row page-header">
			<div class="col-lg-12 col-sm-12 col-xs-12">
				<h2 class="text text-center">
					<span class="badge badge-success">EN CARTELERA</span>
				</h2>
			</div>
		</div>
		
		<br />
		<form action="${urlRoot}search" method="post">
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="form-group row">
						<label for="fecha" class="col-sm-2 col-form-label">Fecha: </label>
						<div class="col-sm-10"> 
							<select id="fecha" name="fecha"
								class="form-control">
								<c:forEach items="${fechas}" var="fecha">
									<c:choose>
										<c:when test="${fecha eq fechaBusqueda}">
											<option value="${fecha}" selected>${fecha}</option>
										</c:when>
										<c:otherwise>
											<option value="${fecha}">${fecha}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
					<button type="submit" class="btn btn-primary btn-block">Filtrar</button>
				</div>
			</div>
		</form>
		<br /> <br />

		<!-- Marketing messaging -->
		<div class="container marketing">

			<div class="row">
				<c:forEach items="${peliculas}" var="pelicula">
					<div class="col-xs-12 col-sm-6 col-md-3">
						<img class="img-rounded" src="${urlPublic}/images/${pelicula.imagen}"
							alt="Generic placeholder image" width="150" height="200">
						<h5>${pelicula.titulo}</h5>
						<h5>
							<span class="badge badge-secondary">${pelicula.clasificacion}</span> <span
								class="badge badge-secondary">${pelicula.duracion} min</span> <span
								class="badge badge-secondary">${pelicula.genero}</span>
						</h5>
						<p>
							<a class="btn btn-sm btn-primary" href="peliculas/detail/${pelicula.id}/${fechaBusqueda}" role="button">Consulta
								Horarios &raquo;</a>
						</p>
					</div>
				</c:forEach>
			</div>

			<br /> <br />
			<div class="page-header">
				<h2 class="text text-center">
					<span class="badge badge-success">Noticias y novedades</span>
				</h2>
			</div>
			<br />

			<div class="row">

				<div class="col-sm-12 blog-main">
					
					<c:forEach var="noticia" items="${noticias}">
					<div class="blog-post">
						<h3 class="blog-post-title">${noticia.titulo}</h3>

						<p class="blog-post-meta">
							<span class="badge badge-danger">Publicado: <fmt:formatDate value="${noticia.fecha}" pattern="dd-MM-yyyy HH:mm" /></span>
						</p>
						<p>
							${noticia.detalle}
						</p>

						<hr class="featurette-divider">
					</div>
					</c:forEach>
				</div>
			</div>

		</div>

		<jsp:include page="include/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
