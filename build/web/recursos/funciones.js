function validarForma(forma) {
    var usuario = forma.usuario;
    if (usuario.value == "" || usuario.value == "Escribir usuario") {
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
    }

    var password = forma.password;
    if (password.value == "" || password.value.length < 3) {
        alert("Debe proporcionar un password al menos de 3 carácteres");
        password.focus();
        password.select();
        return false;
    }

    var tecnologias = forma.tecnologia;
    var checkSeleccionado = false;

    for (var i = 0; i < tecnologias.length; i++) {
        if (tecnologias[i].checked) {
            checkSeleccionado = true;
        }
    }

    if (!checkSeleccionado) {
        alert("Debe seleccionar una tecnología");
        return false;
    }

    var generos = forma.genero;
    var radioSeleccionado = false;

    for (var i = 0; i < generos.length; i++) {
        if (generos[i].checked) {
            radioSeleccionado = true;
        }
    }

    if (!radioSeleccionado) {
        alert("Debe seleccionar un género");
        return false;
    }

    var ocupacion = forma.ocupacion;
    if (ocupacion.value == "") {
        alert("Debe seleccionar una ocupacion");
        return false;
    }
    if (ocupacion.value == "0") {
        var otraOcupacion = forma.otraOcupacion;
        if (otraOcupacion.value == "") {
            alert("Debe indicar la ocupación");
            return false;
        }
    }

    //Formulario es valido
    alert("Formulario válido, enviado datos al servidor");
    return true;
}

function guardado() {
    alert("Guardado correctamente");
}

/***
 * Determina si agrega un input para incluir otra ocupación,
 * dependiendo del valor del select de ocupaciones dentro del formulario
 * registroFrm.jsp
 * @returns {undefined}
 */
function anexarOcupacion() {
    var seleccion = document.getElementById("ocupacion").value;
    var otraOcupacion = document.getElementById("otraOcupacion");
    if (seleccion == '0') {
        document.getElementById('otra').innerHTML = '<input type="text" id="otraOcupacion" name="otraOcupacion" placeHolder="Escribe la ocupacion" />';
    } else {
        document.getElementById('otra').innerHTML = '';
    }
}

/**
 * Agrega un renglón a la tabla que permite registrar los álbumes de los artistas
 * dentro del formulario artistaFrm.jsp 
 * @returns {undefined}
 */
function anexarAlbum() {
    var renglon =  
            "<tr>" +
            "<td><input type='hidden' name='idAlbum' value='0'><input type='text' name='titulo' placeholder='ingresa el título' required>" +
            "<div class='invalid-feedback'>El album es obligatorio.</div></td>"+
            "<td><input type='date' name='anio' required>" +
            "<div class='invalid-feedback'>La fecha es obligatoria.</div></td>" +
            "<td><input type='button' value='Borrar' onclick='quitarAlbum(this)'></td>"
            "</tr>";
            $('#tablaAlbum').append(renglon);
}

/**
 * Quita un renglón a la tabla que permite registrar los álbumes de los artistas
 * dentro del formulario artistaFrm.jsp
 * @param {type} idBtn
 * @returns {undefined}
 */
function quitarAlbum(idBtn){
    // cell element
    var cell = idBtn.parentNode;
    // row element
    var row = cell.parentNode;

    document.getElementById("tablaAlbum").deleteRow(row.rowIndex);
    
    
}