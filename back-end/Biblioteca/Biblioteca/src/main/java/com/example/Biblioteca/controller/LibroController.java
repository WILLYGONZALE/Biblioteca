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

import com.example.Biblioteca.interfaceService.ILibroService;
import com.example.Biblioteca.models.Libro;


@RestController
@RequestMapping("/api/v1/Libro")
public class LibroController {

@Autowired
private ILibroService LibroService;

@PostMapping("/")
public ResponseEntity<Object> save(@ModelAttribute("Libro") Libro Libro) {

    if (Libro.getTitulo().equals("")) {

        return new ResponseEntity<>("El nombre del Libro es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }

    if (Libro.getAutor().equals("")) {

        return new ResponseEntity<>("El estado del Libro es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }

    if (Libro.getISBN().equals("")) {

        return new ResponseEntity<>("El precio del Libro es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }

    if (Libro.getGenero().equals("")) {

        return new ResponseEntity<>("El precio del Libro es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }
    

    LibroService.save(Libro);
    return new ResponseEntity<>(Libro, HttpStatus.OK);
}

@GetMapping("/")
public ResponseEntity<Object> findAll(){
    var listaLibro=LibroService.findAll();
    return new ResponseEntity<>(listaLibro,HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<Object> findOne(@PathVariable String id) {
    var Libro = LibroService.findOne(id);
    return new ResponseEntity<>(Libro, HttpStatus.OK);
}

@DeleteMapping("/{id}")
public ResponseEntity<Object> delete(@PathVariable String id) {
    LibroService.delete(id);
    return new ResponseEntity<>("Registro eliminado", HttpStatus.OK);
}

@PutMapping("/{id}")
public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("Libro") Libro LibroUpdate){
    var Libro= LibroService.findOne(id).get();

    if (Libro != null) {
        

        Libro.setTitulo(LibroUpdate.getTitulo());
        Libro.setAutor(LibroUpdate.getAutor());
        Libro.setISBN(LibroUpdate.getISBN());
        Libro.setGenero(LibroUpdate.getGenero());
        Libro.setNumero_Ejemplares_Disponibles(LibroUpdate.getNumero_Ejemplares_Disponibles());
        Libro.setNumero_Ejemplares_Ocupados(LibroUpdate.getNumero_Ejemplares_Ocupados());

        LibroService.save(Libro);

        return new ResponseEntity<>(Libro, HttpStatus.OK);
    }else{
        return new ResponseEntity<>("Error Libro No encontrado", HttpStatus.BAD_REQUEST);
    }
}
}

