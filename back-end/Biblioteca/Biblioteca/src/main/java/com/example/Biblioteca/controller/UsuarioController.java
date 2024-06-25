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

import com.example.Biblioteca.interfaces.IUsuario;
import com.example.Biblioteca.models.Usuario;






@RestController
@RequestMapping("api/v1/Usuario")
public class UsuarioController {
	 @Autowired
		private IUsuario UsuarioService;
		
		@PostMapping("/")
	    public ResponseEntity<Object> save(
	            
	            @ModelAttribute("Usuario") Usuario Usuario
	            ){
	        
	        UsuarioService.save(Usuario);
	        return new ResponseEntity<>(Usuario, HttpStatus.OK);
	        
	    }
		
		@GetMapping("/")
	    public ResponseEntity<Object> findAll(){
	        var ListUsuario =UsuarioService.findAll();
	        return new ResponseEntity<>(ListUsuario, HttpStatus.OK);
	    }
		
		@GetMapping("/{id_Usuario}")
	    public ResponseEntity<Object> findOne(@PathVariable("id_Prestamo") String id){
	        var Usuario = UsuarioService.findById(id);
	        return new ResponseEntity<>(Usuario, HttpStatus.OK);
	    }
		
		@DeleteMapping("/{id_Usuario}")
	    public ResponseEntity<Object> delete(@PathVariable("id_Usuario") String id_Usuario){
	        UsuarioService.deleteById(id_Usuario);
	        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
	    }

	    public ResponseEntity<Object> update(@PathVariable("id_Usuario") String id_Usuario, @ModelAttribute("Usuario") Usuario UsuarioUpdate){
		    var Usuario = UsuarioService.findById(id_Usuario).orElse(null);
		    if (Usuario != null) {
		        Usuario.setNombre(UsuarioUpdate.getNombre());
		        Usuario.setDireccion(UsuarioUpdate.getDireccion());	        
		        Usuario.setCorreo_Electronico(UsuarioUpdate.getCorreo_Electronico());
		        Usuario.setTipo_Usuario(UsuarioUpdate.getTipo_Usuario());
		
		        
		        UsuarioService.save(Usuario);
		        return new ResponseEntity<>("Guardado", HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>("Error: user no encontrado", HttpStatus.BAD_REQUEST);
		    }
		}

}
