package com.example.Biblioteca.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy =GenerationType.UUID)
	@Column(name="id_Usuario", nullable=false, length = 36)
	private String id_Usuario;
    
	@Column(name="Nombre", nullable=false, length =20 )
	private String Nombre;
	
	@Column(name="Direccion", nullable=false, length = 11)
	private String Direccion;
	
	@Column(name="Correo_Electronico", nullable=false, length = 35)
	private String Correo_Electronico;
	
	
	@Column(name="Tipo_Usuario", nullable=false, length = 20)
	private String Tipo_Usuario;


	public String getId_Usuario() {
		return id_Usuario;
	}


	public void setId_Usuario(String id_Usuario) {
		this.id_Usuario = id_Usuario;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getDireccion() {
		return Direccion;
	}


	public void setDireccion(String direccion) {
		Direccion = direccion;
	}


	public String getCorreo_Electronico() {
		return Correo_Electronico;
	}


	public void setCorreo_Electronico(String correo_Electronico) {
		Correo_Electronico = correo_Electronico;
	}


	public String getTipo_Usuario() {
		return Tipo_Usuario;
	}


	public void setTipo_Usuario(String tipo_Usuario) {
		Tipo_Usuario = tipo_Usuario;
	}


	public Usuario() {
	}


	public Usuario(String id_Usuario, String nombre, String direccion, String correo_Electronico, String tipo_Usuario) {
		this.id_Usuario = id_Usuario;
		Nombre = nombre;
		Direccion = direccion;
		Correo_Electronico = correo_Electronico;
		Tipo_Usuario = tipo_Usuario;
	}


	
	
	
}
