<%-- 
    Document   : datos
    Created on : 4/06/2020, 05:28:01 PM
    Author     : alberto
--%>

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
                        <li><a href="#">Mis datos</a></li>
                    </ul>
                </td>
                <td>
                    <form name="form1" action="Servlet" method="post" 
                          onsubmit="return validarForma(this)">
                        <input type="hidden" name="oculto" value="valorOculto"/>

                        <table id="enfasis-columna">
                            <caption>
                                Registro de Datos
                            </caption>
                            <tr>
                                <td class="columna">
                                    Usuario:(*)
                                </td>
                                <td>
                                    <input class="default" type="text" name="usuario" 
                                           placeholder="Escribir usuario" value="${user}" onfocus="this.select()"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="columna">
                                    Password:(*)
                                </td>
                                <td>
                                    <input class="default" type="password" name="password"
                                           value="${pwd}" onfocus="this.select()"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="columna">
                                    Tecnologías de Internet:(*)
                                </td>
                                <td>
                                    Java <input type="checkbox" name="tecnologia" value="java" ${technology[0]}>
                                    &nbsp;&nbsp;&nbsp;
                                    .Net <input type="checkbox" name="tecnologia" value="net" ${technology[1]}>
                                    &nbsp;&nbsp;&nbsp;
                                    Php<input type="checkbox" name="tecnologia" value="php" ${technology[2]}>
                                    &nbsp;&nbsp;&nbsp;
                                    Python<input type="checkbox" name="tecnologia" value="python" ${technology[3]}>
                                </td>
                            </tr>
                            <tr>
                                <td class="columna">
                                    Genero:(*)
                                </td>
                                <td>
                                    Hombre <input type="radio" name="genero" value="H" ${gender[0]}>
                                    &nbsp;&nbsp;&nbsp;
                                    Mujer <input type="radio" name="genero" value="M" ${gender[1]}>
                                </td>
                            </tr>
                            <tr>
                                <td class="columna">
                                    Ocupación (*)  
                                </td>
                                <td>
                                    <select class="default" name="ocupacion">
                                        <option value="">Seleccionar</option>
                                        <option value="1" ${occupancy[0]}>Instructor</option>
                                        <option value="2" ${occupancy[1]}>Ingeniero</option>
                                        <option value="3" ${occupancy[2]}>Licenciado</option>
                                        <option value="4" ${occupancy[3]}>Otro</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="columna">
                                    Musica Favorita:
                                </td>
                                <td>
                                    <select class="default" name="musica" multiple="">
                                        <option value="cumbia" ${music[0]}>Cumbia</option>
                                        <option value="rock" ${music[1]}>Rock</option>
                                        <option value="pop" ${music[2]}>Pop</option>
                                        <option value="reggaeton" ${music[3]}>Reggaeton</option>
                                        <option value="salsa" ${music[4]}>Salsa</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="columna">
                                    Comentarios:
                                </td>
                                <td>
                                    <textarea class="default" name="comentarios" cols="30" rows="2"
                                              onfocus="this.select()">${comments}
                                    </textarea>
                                </td>
                            </tr>
                            <tr style="text-align:center">
                                <td>
                                    <input class="default" type="submit" value="Actualizar datos">
                                </td>
                            </tr>
                        </table>
                    </form>                    
                </td>
            </tr>
        </table>
    </body>
</html>
