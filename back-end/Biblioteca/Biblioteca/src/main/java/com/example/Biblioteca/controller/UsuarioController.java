package com.example.Biblioteca.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.Biblioteca.interfaceService.IUsuarioService;

import com.example.Biblioteca.models.Usuario;


@RestController
@RequestMapping("/api/v1/Usuario")
public class UsuarioController {


   
    
    @Autowired
    private IUsuarioService UsuarioService;
    
    @PostMapping("/")
    public ResponseEntity<Object> save(@ModelAttribute("Usuario") Usuario Usuario) {
    
        if (Usuario.getNombre().equals("")) {
    
            return new ResponseEntity<>("El nombre del Usuario es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
    
        if (Usuario.getDireccion().equals("")) {
    
            return new ResponseEntity<>("La direccion del Usuario es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
    
        if (Usuario.getCorreo_Electronico().equals("")) {
    
            return new ResponseEntity<>("El correo electronico del Usuario es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
    
        if (Usuario.getTipo_Usuario().equals("")) {
    
            return new ResponseEntity<>("El Tipo de usuario del Usuario es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
    
        UsuarioService.save(Usuario);
        return new ResponseEntity<>(Usuario, HttpStatus.OK);
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        var UsuarioLibro=UsuarioService.findAll();
        return new ResponseEntity<>(UsuarioLibro,HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable String id) {
        var Usuario = UsuarioService.findOne(id);
        return new ResponseEntity<>(Usuario, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        UsuarioService.delete(id);
        return new ResponseEntity<>("Registro eliminado", HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("Usuario") Usuario UsuarioUpdate){
        var Usuario= UsuarioService.findOne(id).get();
    
        if (Usuario != null) {
            
    
            Usuario.setNombre(UsuarioUpdate.getNombre());
            Usuario.setDireccion(UsuarioUpdate.getDireccion());
            Usuario.setCorreo_Electronico(UsuarioUpdate.getCorreo_Electronico());
            Usuario.setTipo_Usuario(UsuarioUpdate.getTipo_Usuario());
           
    
            UsuarioService.save(Usuario);
    
            return new ResponseEntity<>(Usuario, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Error Usuario No encontrado", HttpStatus.BAD_REQUEST);
        }
    }
    }
    

