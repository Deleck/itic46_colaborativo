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
                                <div class="col-sm-12"><h2>${action} perfiles</h2></div>
                                <br>
                                    <form name="form1" action="${action}" method="post" onsubmit="return validarForma(this)">

                                        <table id="enfasis-columna" class="table">
                                            <caption>
                                                ${titulo}
                                            </caption>
                                            <tr>
                                                <td>
                                                    USUARIO:(*)
                                                </td>
                                                <td>
                                                <input class="form-control" type="text" name="usuario" 
                                                placeholder="Escribir usuario" value="${perfil.usuarioId.usuario}" 
                                                onfocus="this.select()"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    PASSWORD:(*)
                                                </td>
                                                <td>
                                                    <input class="form-control" type="password" name="password"
                                                    value="${perfil.password}"
                                                    onfocus="this.select()"/>
                                                </td>
                                            </tr>
                                            <tr>
                                            <td>
                                                TECNOLOGÍAS DE INTERNET:(*)
                                            </td>
                                            <td>
                                                <c:set var="cont" value="0"></c:set>
                                                <c:forEach var="tec" items="${listaTecnologia}">
                                                    ${tec.tecnologia} <input type="checkbox" name="tecnologia" value="${tec.id}"
                                                           <c:forEach var="t" items="${perfil.tecnologiaList}">
                                                               <c:if test="${t.id == tec.id}">checked</c:if>
                                                           </c:forEach>>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <c:set var="cont" value="${cont + 1}"></c:set>
                                                    <c:if test="${cont % 2 == 0 }"><br></c:if>
                                                </c:forEach>
                                    <!--                                    .Net <input type="checkbox" name="tecnologia" value="net">
                                                                        &nbsp;&nbsp;&nbsp;
                                                                        Php<input type="checkbox" name="tecnologia" value="php">
                                                                        &nbsp;&nbsp;&nbsp;
                                                                        Python<input type="checkbox" name="tecnologia" value="python">-->
                                            </td>
                                            </tr>
                                                <tr>
                                                    <td>
                                                        GENERO:(*)
                                                    </td>
                                                    <td>
                                                        Hombre <input type="radio" name="genero" value="H" 
                                                                      <c:if test="${perfil.genero == 'H'}">checked
                                                                      </c:if>> &nbsp;&nbsp;&nbsp;
                                                        Mujer <input type="radio" name="genero" value="M"
                                                                     <c:if test="${perfil.genero == 'M'}">checked</c:if>>
                                                        </td>
                                                </tr>
                                            <tr>
                                                <td>
                                                    OCUPACIÓN:(*)  
                                                </td>
                                                <td>
                                                    <select class="form-control" id="ocupacion" name="ocupacion" onclick="anexarOcupacion()">
                                                        <option value="">Seleccionar</option>
                                                    <c:forEach var="ocupacion" items="${listaOcupacion}">
                                                        <option value="${ocupacion.id}"
                                                                <c:if test="${perfil.ocupacionId.id == ocupacion.id}">
                                                                    selected
                                                                </c:if>>${ocupacion.ocupacion}</option>
                                                    </c:forEach>
                                                    <option value="0">OTRO</option>
                                                </select>
                                            <div id="otra"></div>
                                        <!--
                                        si hay otra ocupación se agrega un input con name='otraOcupacion'
                                        desde funciones.js
                                        -->
                                            </tr>
                                            <tr>
                                            <td>
                                                MÚSICA FAVORITA:
                                            </td>
                                            <td>
                                                <select class="form-control" name="musica" multiple="">
                                                    <c:forEach var="musica" items="${listaMusica}">
                                                        <option value="${musica.id}"
                                                                <c:forEach var="m" items="${perfil.musicaList}">
                                                                    <c:if test="${musica.id == m.id}">selected</c:if>
                                                                </c:forEach>>${musica.musica}</option>
                                                    </c:forEach>

                                        <!--
                                        JSTL 
                                        <option value="cumbia">Cumbia</option>
                                        <option value="rock">Rock</option>
                                        <option value="pop">Pop</option>
                                        <option value="reggaeton">Reggaeton</option>
                                        <option value="salsa">Salsa</option>
                                        -->
                                                </select>
                                            </td>
                                            </tr>
                                            <tr>
                                            <td>
                                                COMENTARIOS:
                                            </td>
                                            <td>
                                                <textarea class="form-control" name="comentarios" cols="30" rows="2"
                                                          placeholder="Escribe un texto" onfocus="this.select()">${perfil.comentarios}</textarea>
                                            </td>
                                        </tr>
                                        <tr><input class="form-control" type="hidden" name="id" value="${perfil.usuarioId.id}"/></tr>
                                        <tr style="text-align:center">
                                            <td>
                                                <input class="btn btn-danger" type="reset" value="Limpiar">
                                            </td>
                                            <td>
                                                <input class="btn btn-success" type="submit" value="Enviar">
                                            </td>
                                        </tr>
                            </table>
                        </form>
                    </td>
                    </tr>
                </table>
             </div>
           </div>
        </div>
    </body>
</html>

