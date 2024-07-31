package com.example.Biblioteca.interfaces;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Biblioteca.models.Libro;
@Repository
public interface ILibro extends CrudRepository<Libro, String>  {
	
	@Query("SELECT l FROM Libro l WHERE l.Titulo = ?1 OR l.Autor = ?2 OR l.Genero = ?3")
	List<Libro>filtroLibro(String Titulo, String Autor, String Genero);
}
