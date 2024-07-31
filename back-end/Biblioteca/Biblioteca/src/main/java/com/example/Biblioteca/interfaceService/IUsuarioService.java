package com.example.Biblioteca.interfaceService;

import java.util.List;
import java.util.Optional;


import com.example.Biblioteca.models.Usuario;

public interface IUsuarioService {
	public String save(Usuario Usuario);
	public List<Usuario> findAll();
	public List<Usuario> filtroUsuario(String Nombre, String Correo_Electronico);
	public Optional<Usuario> findOne(String id);
	public int delete(String id);
}
