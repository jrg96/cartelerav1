<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<spring:url value="/" var="urlRoot" />

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
	<a class="navbar-brand" href="${urlRoot}">Cine app</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto">
			<sec:authorize access="isAnonymous()">
				<li class="nav-item active">
					<a class="nav-link" href="#">Acerca</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${urlRoot}admin/loginform">Login</a>
				</li>
			</sec:authorize>
			
			<sec:authorize access="hasAnyAuthority('EDITOR')" >
				<li class="nav-item">
					<a class="nav-link" href="${urlRoot}peliculas/index">Peliculas</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${urlRoot}banners/index">Banners</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${urlRoot}admin/logout">Cerrar sesión</a>
				</li>
			</sec:authorize>
		</ul>
	</div>
</nav>