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
	@Column(name="id", nullable=false, length = 36)
	private String id;
    
	@Column(name="Nombre", nullable=false, length = 2)
	private String Nombre;
	
	@Column(name="Direccion", nullable=false, length = 11)
	private String Direccion;
	
	@Column(name="Correo Electronico", nullable=false, length = 20)
	private String Correo_Electronico;
	
	
	@Column(name="Tipo Usuario", nullable=true, length = 20)
	private String Tipo_Usuario;
	
	
}
