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
                        <li><a href="musica">Musica</a></li>
                        <li><a href="ocupacion">Ocupación</a></li>
                    </ul>
                </td>
                <td>
                    <h2>${accion} Ocupación</h2>
                    <br>
                    <form action="${ruta}" method="POST">
                        <table >
                            <tr>
                                <td>ID</td>
                                <td><input type="text" name="id" value="${ocupacion.id}" readonly/></td>
                            </tr>
                            <tr>
                                <td>OCUPACION</td>
                                <td><input type="text" name="ocupacion" value="${ocupacion.ocupacion}"/></td>
                            </tr>
                            <tr>
                                <td>ESTATUS</td>
                                <td>
                                    Activo <input type="radio" name="estatus" value="1"
                                                  <c:if test="${ocupacion.estatus==1}">checked</c:if> />
                                    &nbsp;&nbsp;&nbsp;
                                    Inactivo <input type="radio" name="estatus" value="0"
                                                    <c:if test="${ocupacion.estatus==0}">checked</c:if>/>
                                </td>
                            </tr>
                        </table>
                            <br>
                            <input type="submit" value="Aceptar"/>
                            <input type="reset" value="restaurar"/>
                    </form>

                </td>
            </tr>
        </table>
    </body>
</html>

