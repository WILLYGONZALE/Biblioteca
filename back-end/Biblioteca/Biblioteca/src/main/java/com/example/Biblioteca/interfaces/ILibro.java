package com.example.Biblioteca.interfaces;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Biblioteca.models.Libro;
@Repository
public interface ILibro extends CrudRepository<Libro, String>  {
	
	@Query("SELECT p FROM paciente p WHERE "
			+ "p.Titulo LIKE %?1% OR "
			+ "p.Autor LIKE %?1% OR "
			+ "p.ISBN LIKE %?1% OR "
			+ "p.Genero LIKE %?1% OR "
			+ "p.Numero_Ejemplares_Disponibles LIKE %?1% OR "
			+ "p.Numero_Ejemplares_Ocupados LIKE %?1% OR ")
	List<Libro>filtroLibro(String filtro);
}
