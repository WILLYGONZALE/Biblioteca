package com.example.Biblioteca.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.example.Biblioteca.models.Usuario;

public interface IUsuario extends CrudRepository<Usuario, String>{
    @Query("SELECT U FROM Usuario U WHERE U.Nombre = ?1 OR U.Correo_Electronico = ?2")
	List<Usuario>filtroUsuario(String Nombre, String Correo_Electronico);

}
