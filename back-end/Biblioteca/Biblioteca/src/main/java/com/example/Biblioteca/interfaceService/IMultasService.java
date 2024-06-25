package com.example.Biblioteca.interfaceService;
import java.util.List;
import java.util.Optional;

import com.example.Biblioteca.models.Multas;
public interface IMultasService {
	public String save(Multas Multas);
	public List<Multas> findAll();
	public List<Multas> filtroMultas(String filtro);
	public Optional<Multas> findOne(String id);
	public int delete(String id);
}
