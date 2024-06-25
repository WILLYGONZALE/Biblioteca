package com.example.Biblioteca.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class Prestamo {
	@Id
	@GeneratedValue(strategy =GenerationType.UUID)
	@Column(name="id_Prestamo", nullable=false, length = 36)
	private String id_Prestamo;
	
	@Column(name="Fecha_De_Prestamo", nullable=false, length = 10)
	private String Fecha_De_Prestamo;
	
	@Column(name="Fecha_De_Devolucion", nullable=false, length = 10)
	private String Fecha_De_Devolucion;
	
	@Column(name="Usuario_Prestamo", nullable=false, length = 40)
	private String Usuario_Prestamo;
	
	@Column(name="Libro_Prestado", nullable=false, length = 35)
	private String Libro_Prestado;
	
	@Column(name="Estado", nullable=false, length = 15)
	private String Estado;
		
	@Column(name="Prestamo", nullable=false, length = 5)
	private String Prestamo;

	@Column(name="Entregado", nullable=false, length = 20)
	private String Entregado;
	
	@Column(name="Cancelado", nullable=false, length = 20)
	private String Cancelado;

	public String getId_Prestamo() {
		return id_Prestamo;
	}

	public void setId_Prestamo(String id_Prestamo) {
		this.id_Prestamo = id_Prestamo;
	}

	public String getFecha_De_Prestamo() {
		return Fecha_De_Prestamo;
	}

	public void setFecha_De_Prestamo(String fecha_De_Prestamo) {
		Fecha_De_Prestamo = fecha_De_Prestamo;
	}

	public String getFecha_De_Devolucion() {
		return Fecha_De_Devolucion;
	}

	public void setFecha_De_Devolucion(String fecha_De_Devolucion) {
		Fecha_De_Devolucion = fecha_De_Devolucion;
	}

	public String getUsuario_Prestamo() {
		return Usuario_Prestamo;
	}

	public void setUsuario_Prestamo(String usuario_Prestamo) {
		Usuario_Prestamo = usuario_Prestamo;
	}

	public String getLibro_Prestado() {
		return Libro_Prestado;
	}

	public void setLibro_Prestado(String libro_Prestado) {
		Libro_Prestado = libro_Prestado;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getPrestamo() {
		return Prestamo;
	}

	public void setPrestamo(String prestamo) {
		Prestamo = prestamo;
	}

	public String getEntregado() {
		return Entregado;
	}

	public void setEntregado(String entregado) {
		Entregado = entregado;
	}

	public String getCancelado() {
		return Cancelado;
	}

	public void setCancelado(String cancelado) {
		Cancelado = cancelado;
	}

	public Prestamo(String id_Prestamo, String fecha_De_Prestamo, String fecha_De_Devolucion, String usuario_Prestamo,
			String libro_Prestado, String estado, String prestamo, String entregado, String cancelado) {
		super();
		this.id_Prestamo = id_Prestamo;
		Fecha_De_Prestamo = fecha_De_Prestamo;
		Fecha_De_Devolucion = fecha_De_Devolucion;
		Usuario_Prestamo = usuario_Prestamo;
		Libro_Prestado = libro_Prestado;
		Estado = estado;
		Prestamo = prestamo;
		Entregado = entregado;
		Cancelado = cancelado;
	}

	public Prestamo() {
		super();
	}

}
