package com.example.Biblioteca.interfaceService;
import java.util.List;
import java.util.Optional;

import com.example.Biblioteca.models.Prestamo;



public interface IPrestamoService {
	public String save(Prestamo Prestamo);
	public List<Prestamo> findAll();
	public List<Prestamo> filtroPrestamo(String filtro);
	public Optional<Prestamo> findOne(String id);
	public int delete(String id);
}
