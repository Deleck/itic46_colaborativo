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
        <h1>Bienvenido al Ejercicio 2</h1>
        <table>
            <tr>
                <td>
                    <ul>
                        <li><a href="index.html">Inicio</a></li>
                        <li><a href="registro">Registrarse</a></li>
                        <li><a href="perfiles">Perfiles</a></li>
                        <li><a href="#">Musica</a></li>
                        <li><a href="ocupacion">Ocupación</a></li>
                    </ul>
                </td>
                <td>
                    <h2>Catálogo de Música</h2>
                    <br>
                    <input type="button" value="Nueva música" onclick="location.href = 'addMusica'"/>
                    <table border="1" cellpadding="3">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>MÚSICA</th>
                                <th>ESTATUS</th>
                                <th>OPCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="m" items="${musicaList}">
                                <c:if test="${m.estatus==1}">
                                    <tr>
                                        <td>${m.id}</td>
                                        <td>${m.musica}</td>
                                        <td>${m.estatus}</td>
                                        <td>
                                            <input type="button" value="Editar" 
                                                   onclick="location.href = 'editMusica?id=${m.id}'"/>
                                            <input type="button" value="Borrar"
                                                   onclick="location.href = 'deleteMusica?id=${m.id}'"/>
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

