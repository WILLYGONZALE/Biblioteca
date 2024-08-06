var url = "http://localhost:8080/api/v1/Libro/";

function listaLibro() {
    $.ajax({
        url: url,
        type: "GET",
        success: function (result) {
            console.log(result);

            var cuerpoTabla = document.getElementById("cuerpoTabla");
            cuerpoTabla.innerHTML = "";

            result.forEach(function (libro) {
                var trRegistro = document.createElement("tr");

                // Crear celdas
                var celdaId = document.createElement("td");
                var celdaTitulo = document.createElement("td");
                var celdaAutor = document.createElement("td");
                var celdaISBN = document.createElement("td");
                var celdaGenero = document.createElement("td");
                var celdaNumero_Ejemplares_Disponibles = document.createElement("td");
                var celdaNumero_Ejemplares_Ocupados = document.createElement("td");
                var celdaOpciones = document.createElement("td");

                // Asignar valores a las celdas
                celdaId.innerText = libro.id_Libro;
                celdaTitulo.innerText = libro.titulo;
                celdaAutor.innerText = libro.autor;
                celdaISBN.innerText = libro.isbn;
                celdaGenero.innerText = libro.genero;
                celdaNumero_Ejemplares_Disponibles.innerText = libro.numero_Ejemplares_Disponibles;
                celdaNumero_Ejemplares_Ocupados.innerText = libro.numero_Ejemplares_Ocupados;

                // Crear botones con íconos
                var botonEliminar = document.createElement("button");
                botonEliminar.classList.add("btn", "btn-danger", "btn-opciones");
                botonEliminar.innerHTML = '<i class="fas fa-trash"></i>';
                botonEliminar.onclick = function () {
                    eliminarLibro(libro.id_Libro);
                };

                var botonDetalles = document.createElement("button");
                botonDetalles.classList.add("btn", "btn-info", "btn-opciones");
                botonDetalles.innerHTML = '<i class="fas fa-eye"></i>';
                botonDetalles.onclick = function () {
                    verDetalles(libro);
                };
                var botonEditar = document.createElement("button");
                botonEditar.classList.add("btn", "btn-warning", "btn-opciones");
                botonEditar.innerHTML = '<i class="fas fa-edit"></i>';
                botonEditar.onclick = function () {
                    editarLibro(libro);
                };

                


// Función para eliminar un libro
function eliminarLibro(idLibro) {
    Swal.fire({
        title: '¿Estás seguro?',
        text: "¡No podrás recuperar este libro!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, eliminarlo!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: url + idLibro,
                type: "DELETE",
                success: function () {
                    Swal.fire(
                        'Eliminado!',
                        'El libro ha sido eliminado.',
                        'success'
                    );
                    listaLibro(); // Actualizar la lista después de eliminar
                },
                error: function (error) {
                    console.error("Error al eliminar el libro:", error);
                    Swal.fire(
                        'Error',
                        'No se pudo eliminar el libro.',
                        'error'
                    );
                }
            });
        }
    });
}

                // Función para ver detalles del libro
                function verDetalles(libro) {
                    Swal.fire({
                        title: 'Detalles del Libro',
                                        html: `
                                            <p><strong>ID:</strong> ${libro.id_Libro}</p>
                                            <p><strong>Título:</strong> ${libro.titulo}</p>
                                            <p><strong>Autor:</strong> ${libro.autor}</p>
                                            <p><strong>ISBN:</strong> ${libro.isbn}</p>
                                            <p><strong>Género:</strong> ${libro.genero}</p>
                                            <p><strong>Ejemplares Disponibles:</strong> ${libro.numero_Ejemplares_Disponibles}</p>
                                            <p><strong>Ejemplares Ocupados:</strong> ${libro.numero_Ejemplares_Ocupados}</p>
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
                trRegistro.appendChild(celdaId);
                trRegistro.appendChild(celdaTitulo);
                trRegistro.appendChild(celdaAutor);
                trRegistro.appendChild(celdaISBN);
                trRegistro.appendChild(celdaGenero);
                trRegistro.appendChild(celdaNumero_Ejemplares_Disponibles);
                trRegistro.appendChild(celdaNumero_Ejemplares_Ocupados);
                trRegistro.appendChild(celdaOpciones);

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
function agregarLibro(event) {
    event.preventDefault(); // Prevenir el envío del formulario por defecto

    let Titulo = document.getElementById("titulo").value;
    let Autor = document.getElementById("autor").value;
    let Genero = document.getElementById("genero").value;
    let ISBN = document.getElementById("ISBN").value;
    let Numero_Ejemplares_Disponibles = document.getElementById("numero_ejemplares_disponibles").value;
    let Numero_Ejemplares_Ocupados = document.getElementById("numero_ejemplares_ocupados").value;

    // Datos del formulario
    let formData = {
        "Titulo": Titulo,
        "autor": Autor,
        "genero": Genero,
        "ISBN": ISBN,
        "numero_Ejemplares_Disponibles": Numero_Ejemplares_Disponibles,
        "numero_Ejemplares_Ocupados": Numero_Ejemplares_Ocupados
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
            console.log("Libro agregado:", result); // Para depurar
        },
        error: function (error) {
            console.error("Error al agregar el libro:", error); // Para depurar
            Swal.fire({
                title: "Error",
                text: "Error al agregar el libro",
                icon: "error"
            });
        }
    });
}

// Función para limpiar el formulario
function limpiarFormulario() {
    document.getElementById("titulo").value = "";
    document.getElementById("autor").value = "";
    document.getElementById("genero").value = "";
    document.getElementById("isbn").value = "";
    document.getElementById("numero_ejemplares_disponibles").value = "";
    document.getElementById("numero_ejemplares_ocupados").value = "";
}
function editarLibro(libro) {
    // Llena el formulario con la información del libro
    document.getElementById("id_libro_editar").value = libro.id_Libro;
    document.getElementById("titulo_editar").value = libro.titulo;
    document.getElementById("autor_editar").value = libro.autor;
    document.getElementById("genero_editar").value = libro.genero;
    document.getElementById("isbn_editar").value = libro.isbn;
    document.getElementById("numero_ejemplares_disponibles_editar").value = libro.numero_Ejemplares_Disponibles;
    document.getElementById("numero_ejemplares_ocupados_editar").value = libro.numero_Ejemplares_Ocupados;

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
