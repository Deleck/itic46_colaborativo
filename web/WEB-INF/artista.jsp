
<div class="row">
    <div class="col-md-12">
        <h1 class="h2 ">Catálogo de Artistas</h1>
    </div>   
    <div class="col-md-12">&nbsp;</div>
    <div class="col-md-11">
        <input class="btn btn-primary" type="button" value="Registrar artistas" onclick="location.href = 'addArtista'"/>
    </div>
    <div class="col-md-12">&nbsp;</div>
    <div class="table-responsive col-md-12">
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>ARTISTA</th>
                    <th>ALBUMES</th>
                    <th>GENEROS</th>
                    <th>OPCIONES</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="a" items="${artistas}">

                    <tr >
                        <td>${a.id}</td>
                        <td>${a.nombre}</td>
                        <td>
                            <c:forEach var="alb" items="${a.albumList}">
                                <span data-feather="disc"></span>
                                ${alb.titulo}(<fmt:formatDate pattern = "yyyy" value = "${alb.año}"/>) &nbsp;
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach var="g" items="${a.musicaList}">
                                <span data-feather="music"></span> ${g.musica}&nbsp;
                            </c:forEach>
                        </td>
                        <td>
                            <input class="btn btn-sm btn-info" type="button" value="Editar" 
                                   onclick="location.href = 'editArtista?id=${a.id}'"/>
                            <input class="btn btn-sm btn-danger" type="button" value="Borrar"
                                   onclick="location.href = 'deleteArtista?id=${a.id}'"/>
                        </td>

                    </tr>

                </c:forEach>
            </tbody>
        </table>

    </div>
</div>

