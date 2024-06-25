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


import com.example.Biblioteca.interfaces.IMultas;
import com.example.Biblioteca.models.Multas;
import com.example.Biblioteca.service.MultasService;




@RestController
@RequestMapping("api/v1/Multa")
public class MultasController {
	 @Autowired
		private IMultas MultasService;
		
		@PostMapping("/")
	    public ResponseEntity<Object> save(
	            
	            @ModelAttribute("Multas") Multas Multas
	            ){
	        
	        MultasService.save(Multas);
	        return new ResponseEntity<>(Multas, HttpStatus.OK);
	        
	    }
		
		@GetMapping("/")
	    public ResponseEntity<Object> findAll(){
	        var ListMultas =MultasService.findAll();
	        return new ResponseEntity<>(ListMultas, HttpStatus.OK);
	    }
		
		@GetMapping("/{id_Multas}")
	    public ResponseEntity<Object> findOne(@PathVariable("id_Multas") String id){
	        var Multas = MultasService.findById(id);
	        return new ResponseEntity<>(Multas, HttpStatus.OK);
	    }
		
		@DeleteMapping("/{id_Multas}")
	    public ResponseEntity<Object> delete(@PathVariable("id_Multas") String id_Multas){
	        MultasService.deleteById(id_Multas);
	        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
	    }

	    public ResponseEntity<Object> update(@PathVariable("id_Multas") String id_Multas, @ModelAttribute("Multas") Multas MultasUpdate){
		    var Multas = MultasService.findById(id_Multas).orElse(null);
		    if (Multas != null) {
		        Multas.setUsuario_Multado (MultasUpdate.getUsuario_Multado());
		        Multas.setPrestamo(MultasUpdate.getPrestamo());	        
		        Multas.setValor_Multa(MultasUpdate.getValor_Multa());
		        Multas.setFecha_Multa(MultasUpdate.getFecha_Multa());
		        Multas.setEstado(MultasUpdate.getEstado());
		       
		        MultasService.save(Multas);
		        return new ResponseEntity<>("Guardado", HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>("Error: user no encontrado", HttpStatus.BAD_REQUEST);
		    }
		}

}
