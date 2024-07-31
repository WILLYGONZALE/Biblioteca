package com.example.Biblioteca.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.Biblioteca.models.Libro;


public interface ILibroService {
	public String save(Libro Libro);
	public List<Libro> findAll();
	public List<Libro> filtroLibro(String Titulo, String Autor, String Genero);
	public Optional<Libro> findOne(String id);
	public int delete(String id);
}
