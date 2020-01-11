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
    <title>Listado de imagenes del banner</title>
    
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
	  
      <h3>Listado de imagenes del Banner</h3>
      
      <a href="${urlRoot}banners/create" class="btn btn-success" role="button" title="Nuevo Banner" >Nuevo</a><br><br>

      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Titulo</th>                           
                <th>Fecha Publicacion</th>              
                <th>Nombre Archivo</th>
                <th>Estatus</th>
                <th>Opciones</th>              
            </tr>
            
            <c:forEach var="banner" items="${lista_banners}">
            <tr>
                <td>${banner.id}</td>
                <td>${banner.titulo}</td>
                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${banner.fecha}"/></td>    
                <td>${banner.archivo}</td>
                
                <c:choose>
                	<c:when test="${banner.estatus == 'Activo'}">
                		<td><span class="badge badge-success">Activo</span></td>
                	</c:when>
                	<c:otherwise>
                		<td><span class="badge badge-danger">Activo</span></td>
                	</c:otherwise>
                </c:choose>
                                         
                <td>
                    <a href="#" class="btn btn-success btn-sm" role="button" title="Edit" ><i class="fa fa-pencil-alt" aria-hidden="true"></i></a>
                    <a href="#" class="btn btn-danger btn-sm" role="button" title="Eliminar" ><i class="fa fa-trash" aria-hidden="true"></i></span></a>
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
    <script src="${urlPublic}bootstrap/js/bootstrap.min.js"></script>     
  </body>
</html>