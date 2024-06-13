package com.example.Biblioteca.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class Libro {
	@Id
	@GeneratedValue(strategy =GenerationType.UUID)
	@Column(name="id_Libro", nullable=false, length = 36)
	private String id_Libro;

	@Column(name="Titulo", nullable=false, length = 40)
	private String Titulo;
	
	@Column(name="Autor", nullable=false, length = 40)
	private String Autor;
	
	@Column(name="ISBN", nullable=false, length = 18)
	private String ISBN;
	
	@Column(name="Genero", nullable=false, length = 45)
	private String Genero;
		
	@Column(name="Numero_Ejemplares_Disponibles", nullable=false, length = 120)
	private String Numero_Ejemplares_Disponibles;

	@Column(name="Numero_Ejemplares_Ocupados", nullable=false, length = 120)
	private String Numero_Ejemplares_Ocupados;

	public String getId_Libro() {
		return id_Libro;
	}

	public void setId_Libro(String id_Libro) {
		this.id_Libro = id_Libro;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public String getNumero_Ejemplares_Disponibles() {
		return Numero_Ejemplares_Disponibles;
	}

	public void setNumero_Ejemplares_Disponibles(String numero_Ejemplares_Disponibles) {
		Numero_Ejemplares_Disponibles = numero_Ejemplares_Disponibles;
	}

	public String getNumero_Ejemplares_Ocupados() {
		return Numero_Ejemplares_Ocupados;
	}

	public void setNumero_Ejemplares_Ocupados(String numero_Ejemplares_Ocupados) {
		Numero_Ejemplares_Ocupados = numero_Ejemplares_Ocupados;
	}

	public Libro(String id_Libro, String titulo, String autor, String iSBN, String genero,
			String numero_Ejemplares_Disponibles, String numero_Ejemplares_Ocupados) {
		super();
		this.id_Libro = id_Libro;
		Titulo = titulo;
		Autor = autor;
		ISBN = iSBN;
		Genero = genero;
		Numero_Ejemplares_Disponibles = numero_Ejemplares_Disponibles;
		Numero_Ejemplares_Ocupados = numero_Ejemplares_Ocupados;
	}

	public Libro() {
		super();
	}



	
	
	
	
}
