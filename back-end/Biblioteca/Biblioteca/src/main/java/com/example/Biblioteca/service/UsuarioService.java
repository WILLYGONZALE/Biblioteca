package com.example.Biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.example.Biblioteca.interfaceService.IUsuarioService;
import com.example.Biblioteca.interfaces.IUsuario;
import com.example.Biblioteca.models.Usuario;

@Service
public class UsuarioService implements IUsuarioService{
    private IUsuario data;
	
	@Override
	public String save(Usuario Usuario) {
		data.save(Usuario);
		return Usuario.getId_Usuario();
	}

	@Override
	public List<Usuario> findAll() {
		List<Usuario> listaUsuario=(List<Usuario>) data.findAll();
		
		return listaUsuario;
	}
	
	@Override
	public List<Usuario> filtroUsuario(String Nombre, String Correo_Electronico) {
		List <Usuario> listaUsuario=data.filtroUsuario(Nombre, Correo_Electronico);
		return listaUsuario;
	}


	@Override
	public Optional<Usuario> findOne(String id) {
		Optional<Usuario> Usuario=data.findById(id);
		
		return Usuario;
	}

	@Override
	public int delete(String id) {
		data.deleteById(id);
		return 1;
	}

}
