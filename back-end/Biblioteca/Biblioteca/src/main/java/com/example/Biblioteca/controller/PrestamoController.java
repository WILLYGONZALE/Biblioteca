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


import com.example.Biblioteca.interfaces.IPrestamo;

import com.example.Biblioteca.models.Prestamo;



@RestController
@RequestMapping("api/v1/Prestamo")
public class PrestamoController {
	 @Autowired
		private IPrestamo PrestamoService;
		
		@PostMapping("/")
	    public ResponseEntity<Object> save(
	            
	            @ModelAttribute("Prestamo") Prestamo Prestamo
	            ){
	        
	        PrestamoService.save(Prestamo);
	        return new ResponseEntity<>(Prestamo, HttpStatus.OK);
	        
	    }
		
		@GetMapping("/")
	    public ResponseEntity<Object> findAll(){
	        var ListPrestamo =PrestamoService.findAll();
	        return new ResponseEntity<>(ListPrestamo, HttpStatus.OK);
	    }
		
		@GetMapping("/{id_Prestamo}")
	    public ResponseEntity<Object> findOne(@PathVariable("id_Prestamo") String id){
	        var Prestamo = PrestamoService.findById(id);
	        return new ResponseEntity<>(Prestamo, HttpStatus.OK);
	    }
		
		@DeleteMapping("/{id_Prestamo}")
	    public ResponseEntity<Object> delete(@PathVariable("id_Prestamo") String id_Prestamo){
	        PrestamoService.deleteById(id_Prestamo);
	        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
	    }

	    public ResponseEntity<Object> update(@PathVariable("id_Prestamo") String id_Prestamo, @ModelAttribute("Prestamo") Prestamo PrestamoUpdate){
		    var Prestamo = PrestamoService.findById(id_Prestamo).orElse(null);
		    if (Prestamo != null) {
		        Prestamo.setFecha_De_Prestamo(PrestamoUpdate.getFecha_De_Prestamo());
		        Prestamo.setFecha_De_Devolucion(PrestamoUpdate.getFecha_De_Devolucion());	        
		        Prestamo.setUsuario_Prestamo(PrestamoUpdate.getUsuario_Prestamo());
		        Prestamo.setLibro_Prestado(PrestamoUpdate.getLibro_Prestado());
		        Prestamo.setEstado(PrestamoUpdate.getEstado());
		        Prestamo.setPrestamo(PrestamoUpdate.getPrestamo());
		        Prestamo.setEntregado(PrestamoUpdate.getEntregado());
		        Prestamo.setCancelado(PrestamoUpdate.getCancelado());
		       
		        
		        PrestamoService.save(Prestamo);
		        return new ResponseEntity<>("Guardado", HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>("Error: user no encontrado", HttpStatus.BAD_REQUEST);
		    }
		}

	
}
