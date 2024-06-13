package com.example.Biblioteca.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Biblioteca.interfaces.ILibro;
import com.example.Biblioteca.models.Libro;



@RestController
@RequestMapping("api/v1/Libro")
public class LibroController {
	 @Autowired
		private ILibro LibroService;
		
		@PostMapping("/")
	    public ResponseEntity<Object> save(
	            
	            @ModelAttribute("Libro") Libro Libro
	            ){
	        
	        LibroService.save(Libro);
	        return new ResponseEntity<>(Libro, HttpStatus.OK);
	        
	    }
		
		@GetMapping("/")
	    public ResponseEntity<Object> findAll(){
	        var ListLibro =LibroService.findAll();
	        return new ResponseEntity<>(ListLibro, HttpStatus.OK);
	    }
		
		@GetMapping("/{id_Libro}")
	    public ResponseEntity<Object> findOne(@PathVariable("id_Libro") String id){
	        var Libro = LibroService.findById(id);
	        return new ResponseEntity<>(Libro, HttpStatus.OK);
	    }
		
		@DeleteMapping("/{id_Libro}")
	    public ResponseEntity<Object> delete(@PathVariable("id_Libro") String id_Libro){
	        LibroService.deleteById(id_Libro);
	        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
	    }

	    public ResponseEntity<Object> update(@PathVariable("id_Libro") String id_Libro, @ModelAttribute("Libro") Libro LibroUpdate){
		    var Libro = LibroService.findById(id_Libro).orElse(null);
		    if (Libro != null) {
		        Libro.setTitulo(LibroUpdate.getTitulo());
		        Libro.setAutor(LibroUpdate.getAutor());	        
		        Libro.setISBN(LibroUpdate.getISBN());
		        Libro.setGenero(LibroUpdate.getGenero());
		        Libro.setNumero_Ejemplares_Disponibles(LibroUpdate.getNumero_Ejemplares_Disponibles());
		        Libro.setNumero_Ejemplares_Ocupados(LibroUpdate.getNumero_Ejemplares_Ocupados());
		       
		        
		        LibroService.save(Libro);
		        return new ResponseEntity<>("Guardado", HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>("Error: user no encontrado", HttpStatus.BAD_REQUEST);
		    }
		}

	
}
