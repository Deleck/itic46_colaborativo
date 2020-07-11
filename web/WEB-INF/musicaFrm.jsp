<%-- 
    Document   : registro
    Created on : 4/06/2020, 05:10:28 PM
    Author     : alberto
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ejercicio 2 de Formularios con  Servlets</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="recursos/estilos.css">
        <script type="text/javascript" src="recursos/funciones.js"></script>
    </head>
    <body>
        <div class="row">
            <div class="container">
                <div class="col-sm-12">
                    <table class="table">
                        <tr>                
                            <td>
                                <div class="col-sm-12"><h2>${accion} música</h2></div>
                                <br>
                                <form action="${ruta}" method="POST">
                                    <table class="table">
                                        <tr>
                                            <td>ID</td>
                                            <td><input class="form-control" type="text" name="id" value="${musica.id}" readonly/></td>
                                        </tr>
                                        <tr>
                                            <td>MUSICA</td>
                                            <td><input class="form-control" type="text" name="musica" value="${musica.musica}"/></td>
                                        </tr>
                                        <tr>
                                            <td>ESTATUS</td>
                                            <td>
                                                Activo <input type="radio" name="estatus" value="1"
                                                              <c:if test="${musica.estatus==1}">checked</c:if> />
                                                              &nbsp;&nbsp;&nbsp;
                                                              Inactivo <input type="radio" name="estatus" value="0"
                                                              <c:if test="${musica.estatus==0}">checked</c:if>/>
                                            </td>
                                        </tr>
                                    </table>
                                    <div class="col-sm-12">
                                        <input class="btn btn-success" type="submit" value="Aceptar"/>
                                        <input class="btn btn-danger" type="reset" value="restaurar"/>
                                    </div>
                                </form>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

