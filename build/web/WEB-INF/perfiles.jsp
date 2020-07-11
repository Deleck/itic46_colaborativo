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
        <!--<meta name="viewport" content="width=device-width, initial-scale=1.0">-->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="recursos/estilos.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script type="text/javascript" src="recursos/funciones.js"></script>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </head>
    <body>
        <h1>Bienvenido al Ejercicio 2</h1>
        <table>
            <tr>
                <td>
                    <ul>
                        <li><a href="index.html">Inicio</a></li>
                        <li><a href="registro">Registrarse</a></li>
                        <li><a href="#">Perfiles</a></li>
                        <li><a href="musica">Musica</a></li>
                        <li><a href="ocupacion">Ocupación</a></li>
                    </ul>
                </td>
                <td>
                    <h2>Catálogo de Perfiles</h2>
                    <br>
                    <input type="button" value="Registrar perfil" onclick="location.href = 'registro'"/>
                    <table border="1" cellpadding="3">
                        <thead>
                            <tr>
                                <th>USUARIO</th>
                                <th>OCUPACIÓN</th>
                                <th>MÚSICA FAVORITA</th>
                                <th>ESTATUS</th>
                                <th>OPCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="p" items="${perfiles}">
                                <c:if test="${p.usuarioId.estatus==1}">
                                    <tr>
                                        <td>${p.usuarioId.usuario}</td>
                                        <td>${p.ocupacionId.ocupacion}</td>
                                        <td><c:forEach var="mf" items="${p.musicaList}">
                                                /${mf.musica}/
                                            </c:forEach>
                                        </td>
                                        <td>${p.usuarioId.estatus}</td>
                                        <td>
                                            <input type="button" value="Editar" 
                                                   onclick="location.href = 'editPerfiles?id=${p.usuarioId.id}'"/>
                                            <input type="button" value="Borrar"
                                                   onclick="location.href = 'deletePerfiles?id=${p.usuarioId.id}'"/>
                                        </td>

                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>

                </td>
            </tr>
        </table>
    </body>
</html>

