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
    <title>Listado de Noticias</title>
    
    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
    
    <link href="${urlPublic}/fontawesome/css/fontawesome.css" rel="stylesheet">
    <link href="${urlPublic}/fontawesome/css/brands.css" rel="stylesheet">
    <link href="${urlPublic}/fontawesome/css/solid.css" rel="stylesheet">
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../include/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">
    	<!-- INICIO DESPLIEGUE MENSAJES -->
    	<c:if test="${mensaje != null}">
    		<div class="alert alert-success" role="alert">
  				${mensaje}
  			</div>
    	</c:if>
    	<!-- FIN DESPLIEGUE MENSAJES -->

      <h3>Listado de Noticias</h3>
      
      <a href="${urlRoot}noticias/create" class="btn btn-success" role="button" title="Nueva Noticia" >Nueva</a><br><br>

      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Fecha</th>              
                <th>Estatus</th>              
                <th>Opciones</th>              
            </tr>
            <c:forEach var="noticia" items="${lista_noticias}">
	            <tr>
	                <td>${noticia.id}</td>
	                <td>${noticia.titulo}</td>
	                <td><fmt:formatDate value="${noticia.fecha}" pattern="dd-MM-yyyy HH:mm" /></td>              
	                <td>
	                	<c:choose>
	                		<c:when test="${noticia.estatus == 'Activa'}">
	                			<span class="badge badge-success">Activa</span>
	                		</c:when>
	                		<c:otherwise>
	                			<span class="badge badge-danger">Inactiva</span>
	                		</c:otherwise>
	                	</c:choose>
	                </td>
	                <td>
	                    <a href="${urlRoot}noticias/edit/${noticia.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><i class="fa fa-pencil-alt" aria-hidden="true"></i></a>
	                    <a href="${urlRoot}noticias/delete/${noticia.id}" onclick="return confirm('Esta seguro que desea eliminar la noticia?')" class="btn btn-danger btn-sm" role="button" title="Eliminar" ><i class="fa fa-trash" aria-hidden="true"></i></a>
	                </td>
	            </tr>
            </c:forEach>         
        </table>
      </div>  
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