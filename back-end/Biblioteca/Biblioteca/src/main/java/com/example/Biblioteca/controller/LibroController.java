package com.example.Biblioteca.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Biblioteca.interfaceService.ILibroService;
import com.example.Biblioteca.models.Libro;






@RequestMapping("/api/v1/Libro/")
@RestController
@CrossOrigin
public class LibroController {

	@Autowired
	private ILibroService LibroService;
	
	@PostMapping("/")
	public ResponseEntity<Object> save(
			@ModelAttribute("Libro")Libro Libro
			){
		LibroService.save(Libro);
		return new ResponseEntity<>(Libro,HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var ListaLibro=LibroService.findAll();
		return new ResponseEntity<>(ListaLibro,HttpStatus.OK);
	}
	
	@GetMapping("/busquedafiltro/{filtro}")
	public ResponseEntity<Object>findFiltro(@PathVariable String filtro){
		var ListaLibro = LibroService.filtroLibro(filtro);
		return new ResponseEntity<>(ListaLibro, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable("id") String id){
		var Libro=LibroService.findOne(id);
		return new ResponseEntity<>(Libro,HttpStatus.OK);
	}
	
	@GetMapping("/editarLibro/{id}")
	public String mostrarFormularioDeEditarLibro(@PathVariable("id") String id, @ModelAttribute("Libro") Libro LibroUpdate) {
	    // Lógica para obtener el paciente por ID y agregarlo al modelo
	    return "formularioEditarLibro";  // El nombre de la página Thymeleaf para el formulario de edición
	}

	@PostMapping("/editarLibro/{id}")
	public String actualizarLibro(@PathVariable("id") String id, @ModelAttribute("libro") Libro LibroUpdate) {
	    // Lógica para actualizar el libro en la base de datos
	    return "redirect:/listaLibro";  // Redirigir a la lista de pacientes después de la edición
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id){
		LibroService.delete(id);
		return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable("id") String id, @ModelAttribute("Libro") Libro LibroUpdate){
		var Libro= LibroService.findOne(id).get();
		if (Libro != null) {
			Libro.setTitulo(LibroUpdate.getTitulo());
			Libro.setAutor(LibroUpdate.getAutor());
			Libro.setISBN(LibroUpdate.getISBN());
			Libro.setGenero(LibroUpdate.getGenero());
			Libro.setNumero_Ejemplares_Disponibles(LibroUpdate.getNumero_Ejemplares_Disponibles());
			Libro.setNumero_Ejemplares_Ocupados(LibroUpdate.getNumero_Ejemplares_Ocupados());
			
			LibroService.save(Libro);
			return new ResponseEntity<>("Guardado",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Error paciente no encontrado",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
}
