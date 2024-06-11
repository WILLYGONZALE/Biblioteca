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
	@Column(name="id", nullable=false, length = 36)
	private String id;
    
	@Column(name="Titulo", nullable=false, length = 41)
	private String Titulo;
	
	@Column(name="Autor", nullable=false, length = 49)
	private String Autor;
	
	@Column(name="ISBN", nullable=false, length = 13)
	private String ISBN;
	
	@Column(name="Genero", nullable=false, length = 30)
	private String Genero;
	
	@Column(name="Numero Ejemplares Disponibles", nullable=false, length = 4)
	private String Numero_Ejemplares_Disponibles;
		
	@Column(name="Numero Ejemplares Ocupados", nullable=false, length = 4)
	private String Numero_Ejemplares_Ocupados;
	public Libro() {
		super();
	}


	public Libro(String id, String Titulo, String Autor, String ISBN, String Genero,
			String Numero_Ejemplares_Disponibles, String Numero_Ejemplares_Ocupados) {
		super();
		this.id = id;
		this.Titulo = Titulo;
		this.Autor = Autor;
		this.ISBN = ISBN;
		this.Genero = Genero;
		this.Numero_Ejemplares_Disponibles = Numero_Ejemplares_Disponibles;
		this.Numero_Ejemplares_Ocupados = Numero_Ejemplares_Ocupados;
		
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitulo() {
		return Titulo;
	}


	public void setTitulo(String Titulo) {
		this.Titulo = Titulo;
	}


	public String getAutor() {
		return Autor;
	}


	public void setAutor(String Autor) {
		this.Autor = Autor;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}


	public String getGenero() {
		return Genero;
	}


	public void setGenero(String Genero) {
		this.Genero = Genero;
	}


	public String getNumero_Ejemplares_Disponibles() {
		return Numero_Ejemplares_Disponibles;
	}


	public void setNumero_Ejemplares_Disponibles(String Numero_Ejemplares_Disponibles) {
		this.Numero_Ejemplares_Disponibles = Numero_Ejemplares_Disponibles;
	}


	public String getNumero_Ejemplares_Ocupados() {
		return Numero_Ejemplares_Ocupados;
	}


	public void setNumero_Ejemplares_Ocupados(String Numero_Ejemplares_Ocupados) {
		this.Numero_Ejemplares_Ocupados = Numero_Ejemplares_Ocupados;
	}


	
	
	
}
