<%-- 
    Document   : registro
    Created on : 4/06/2020, 05:10:28 PM
    Author     : alberto
--%>

<div class="row">
    
    <div class="col-md-12">
        <h1 class="h2"> Cátalogo de Musica </h1>
    </div>
    <div class="col-md-12">&nbsp;</div>
    <div class="col-md-11">
        <input class="btn btn-primary" type="button" value="Nueva música" onclick="location.href = 'addMusica'" />
    </div>
    <div class="col-md-12">&nbsp;</div>
    <div class="table-responsive col-md-12">
        <table class="table table-bordered table-hover"
        
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
        
        
        </div>
    </div>


                    
                  
                    
                    
                    


