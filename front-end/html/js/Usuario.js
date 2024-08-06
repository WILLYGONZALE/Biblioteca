var url = "http://localhost:8080/api/v1/Libro/";

function listaUsuario() {
    $.ajax({
        url: url,
        type: "GET",
        success: function (result) {
            console.log(result);

            var cuerpoTabla = document.getElementById("cuerpoTabla");
            cuerpoTabla.innerHTML = "";

            result.forEach(function (Usuario) {
                var trRegistro = document.createElement("tr");

                // Crear celdas
                var celdaID = document.createElement("td");
                var celdaNombre = document.createElement("td");
                var celdaDireccion = document.createElement("td");
                var celdaCorreo_electrónico = document.createElement("td");
                var celdaTipo_de_usuario = document.createElement("td");
                var celdaOpciones = document.createElement("td");
                // Asignar valores a las celdas
                celdaID.innerText = Usuario.ID;
                celdaNombre.innerText = Usuario.Nombre;
                celdaDireccion.innerText = Usuario.Direccion;
                celdaCorreo_electrónico.innerText = Usuario.Correo_electrónico;
                celdaTipo_de_usuario.innerText = Usuario.Tipo_de_usuario;
                celdaOpciones.innerText = Usuario.Opciones;

                // Crear botones con íconos
                var botonEliminar = document.createElement("button");
                botonEliminar.classList.add("btn", "btn-danger", "btn-opciones");
                botonEliminar.innerHTML = '<i class="fas fa-trash"></i>';
                botonEliminar.onclick = function () {
                    eliminarUsuario(Usuario.id_usuario);
                };

                var botonDetalles = document.createElement("button");
                botonDetalles.classList.add("btn", "btn-info", "btn-opciones");
                botonDetalles.innerHTML = '<i class="fas fa-eye"></i>';
                botonDetalles.onclick = function () {
                    verDetalles(Usuario);
                };
                var botonEditar = document.createElement("button");
                botonEditar.classList.add("btn", "btn-warning", "btn-opciones");
                botonEditar.innerHTML = '<i class="fas fa-edit"></i>';
                botonEditar.onclick = function () {
                    editarUsuario(Usuario);
                };

                


// Función para eliminar un libro
function eliminarUsuario(id_usuario) {
    Swal.fire({
        title: '¿Estás seguro?',
        text: "¡No podrás recuperar este Usuario!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, eliminarlo!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: url + ID,
                type: "DELETE",
                success: function () {
                    Swal.fire(
                        'Eliminado!',
                        'El Usuario ha sido eliminado.',
                        'success'
                    );
                    listaUsuario(); // Actualizar la lista después de eliminar
                },
                error: function (error) {
                    console.error("Error al eliminar el Usuario:", error);
                    Swal.fire(
                        'Error',
                        'No se pudo eliminar el Usuario.',
                        'error'
                    );
                }
            });
        }
    });
}

                // Función para ver detalles del Usuario
                function verDetalles(Usuario) {
                    Swal.fire({
                        title: 'Detalles del Usuario',
                                        html: `
                                            <p><strong>ID:</strong> ${Usuario.id_usuario}</p>
                                            <p><strong>Título:</strong> ${Usuario.Nombre}</p>
                                            <p><strong>Autor:</strong> ${Usuario.Direccion}</p>
                                            <p><strong>ISBN:</strong> ${Usuario.Correo_electrónico}</p>
                                            <p><strong>Género:</strong> ${Usuario.Tipo_de_usuario}</p>
                                            <p><strong>Ejemplares Disponibles:</strong> ${Usuario.Opciones}</p>
                                        `,
                                        icon: 'info',
                                        confirmButtonText: 'Cerrar'
                    });
                }
botonDetalles.classList.add("btn", "btn-info");
botonEliminar.classList.add("btn", "btn-danger");

                   // Añadir botones a la celda de opciones
                   celdaOpciones.appendChild(botonDetalles);
                   celdaOpciones.appendChild(botonEliminar);
                   celdaOpciones.appendChild(botonEditar);

                // Añadir celdas al registro
                trRegistro.appendChild(celdaId_usuario);
                trRegistro.appendChild(celdaNombre);
                trRegistro.appendChild(celdaDireccion);
                trRegistro.appendChild(celdaCorreo_electrónico);
                trRegistro.appendChild(celdaGenero);

                // Añadir el registro a la tabla
                cuerpoTabla.appendChild(trRegistro);
            });
        },
        error: function (error) {
            console.error("Error en la petición:", error);
            alert("Error en la petición: " + error.statusText);
        }
    });
}
// Función para agregar un libro
function agregarUsuario(event) {
    event.preventDefault(); // Prevenir el envío del formulario por defecto

    let Nombre = document.getElementById("Nombre").value;
    let Direccion = document.getElementById("Direccion").value;
    let Correo_electrónico = document.getElementById("Correo_electrónico").value;
    let Tipo_Usuario = document.getElementById("Tipo_Usuario").value;
    // Datos del formulario
    let formData = {
        "Nombre": Nombre,
        "Direccion": Direccion,
        "Correo_Electronico": Correo_electrónico,
        "Tipo_Usuario": Tipo_Usuario,
    };

    $.ajax({
        url: url,
        type: "POST",
        data:formData, // Convertir los datos a una cadena JSON
        success: function (result) {
            Swal.fire({
                title: "¡Excelente!",
                text: "Se guardó correctamente",
                icon: "success"
            });
            limpiarFormulario();
            console.log("Usuario agregado:", result); // Para depurar
        },
        error: function (error) {
            console.error("Error al agregar el Usuario:", error); // Para depurar
            Swal.fire({
                title: "Error",
                text: "Error al agregar el Usuario",
                icon: "error"
            });
        }
    });
}

// Función para limpiar el formulario
function limpiarFormulario() {
    document.getElementById("Nombre").value = "";
    document.getElementById("Direccion").value = "";
    document.getElementById("Correo Electronico").value = "";
    document.getElementById("Tipo de usuarios").value = "";

}
function editarLibro(Usuario) {
    // Llena el formulario con la información del Usuario
    document.getElementById("id_libro_editar").value = Usuario.id_Libro;
    document.getElementById("titulo_editar").value = Usuario.titulo;
    document.getElementById("autor_editar").value = Usuario.autor;
    document.getElementById("genero_editar").value = Usuario.genero;
    document.getElementById("isbn_editar").value = Usuario.isbn;
    document.getElementById("numero_ejemplares_disponibles_editar").value = Usuario.numero_Ejemplares_Disponibles;
    document.getElementById("numero_ejemplares_ocupados_editar").value = Usuario.numero_Ejemplares_Ocupados;

    // Muestra el modal
    var myModal = new bootstrap.Modal(document.getElementById('modalEditarLibro'));
    myModal.show();
}


function ocultarFormularioEdicion() {
    document.getElementById("formularioEdicion").style.display = "none";
}
document.getElementById("formularioLibroEdicion").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevenir el envío del formulario por defecto

    let id_Libro = document.getElementById("id_libro_editar").value;
    let Titulo = document.getElementById("titulo_editar").value;
    let Autor = document.getElementById("autor_editar").value;
    let Genero = document.getElementById("genero_editar").value;
    let ISBN = document.getElementById("isbn_editar").value;
    let Numero_Ejemplares_Disponibles = document.getElementById("numero_ejemplares_disponibles_editar").value;
    let Numero_Ejemplares_Ocupados = document.getElementById("numero_ejemplares_ocupados_editar").value;

    // Datos del formulario
    let formData = {
        "titulo": Titulo,
        "autor": Autor,
        "genero": Genero,
        "ISBN": ISBN,
        "numero_Ejemplares_Disponibles": Numero_Ejemplares_Disponibles,
        "numero_Ejemplares_Ocupados": Numero_Ejemplares_Ocupados
    };

    $.ajax({
        url: url + id_Libro,
        type: "PUT",
        data:formData, // Convertir los datos a una cadena JSON
        success: function (result) {
            Swal.fire({
                title: "¡Excelente!",
                text: "Se actualizó correctamente",
                icon: "success"
            });
            listaLibro(); // Actualizar la lista después de editar
            ocultarFormularioEdicion(); // Ocultar el formulario
            console.log("Libro actualizado:", result); // Para depurar
        },
        error: function (error) {
            console.error("Error al actualizar el libro:", error); // Para depurar
            Swal.fire({
                title: "Error",
                text: "Error al actualizar el libro",
                icon: "error"
            });
        }
    });
});
