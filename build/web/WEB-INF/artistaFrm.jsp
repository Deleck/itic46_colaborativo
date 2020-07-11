<div class="row">
    <div class="col-md-12">
        <h4 class="mb-3">${titulo}</h4>

        <form class="needs-validation" novalidate action="${action}" method="post">

            <div class="row">
                <div class="col-md-12 mb-3">
                    <label for="nombre">Nombre del artista</label>
                    <input class="form-control" type="text" id="nombre" name="nombre" 
                           placeholder="Escribir el nombre" value="${art.nombre}" 
                           required>
                    <div class="invalid-feedback">
                        El nombre del artista es obligatorio.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 mb-3">
                    <label for="musica">Género(s) en el que incursiona el artista</label>
                    <select class="custom-select d-block w-100" id="musica" name="musica" multiple="" required="">
                        <!--<option value="">Seleccione...</option>-->
                        <c:forEach var="musica" items="${listaMusica}">
                            <option value="${musica.id}"
                                    <c:forEach var="m" items="${art.musicaList}">
                                        <c:if test="${musica.id == m.id}">selected</c:if>
                                    </c:forEach>>${musica.musica}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">
                        Seleccione la música.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 mb-3">
                    <label>Álbumes del artista</label>
                    <input type="button" value="anexar album" onclick="anexarAlbum()">
                    <table class="table table-bordered" id="tablaAlbum">
                        <tbody>
                            <c:forEach var="a" items="${art.albumList}">
                                <tr>
                                    <td><input type="hidden" name="idAlbum" value="${a.id}">
                                        <input type='text' name='titulo' placeholder='ingresa el título' value="${a.titulo}" required/>
                                        <div class="invalid-feedback">
                                            El album es obligatorio.
                                        </div>
                                    </td>
                                    <td>
                                        <input type='date' name='anio' value="<fmt:formatDate pattern = 'yyyy-MM-dd' value = '${a.año}'/>" required/>
                                        <div class="invalid-feedback">
                                            La fecha es obligatoria.
                                        </div>
                                    </td>
                                    <td><input type="button" value="Borrar" onclick="quitarAlbum(this)"></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <input type="hidden" name="id" value="${art.id}"/>
            <div class="row">
                <div class="mx-auto">
                    <input class="btn btn-secondary" type="reset" value="Limpiar">

                    <input class="btn btn-primary" type="submit" value="Enviar">
                </div>
        </form>
    </div>
</div>