package com.example.Biblioteca.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class Multas {

	@Id
	@GeneratedValue(strategy =GenerationType.UUID)
	@Column(name="id_Multas", nullable=false, length = 36)
	private String id_Multas;
	
	@Column(name="Usuario_Multado", nullable=false, length = 40)
	private String Usuario_Multado;
	
	@Column(name="Prestamo", nullable=false, length = 40)
	private String Prestamo;
	
	@Column(name="Valor_Multa", nullable=false, length = 40)
	private String Valor_Multa;
	
	@Column(name="Fecha_Multa", nullable=false, length = 10)
	private String Fecha_Multa;
	
	@Column(name="Estado", nullable=false, length = 15)
	private String Estado;

	public String getId_Multas() {
		return id_Multas;
	}

	public void setId_Multas(String id_Multas) {
		this.id_Multas = id_Multas;
	}

	public String getUsuario_Multado() {
		return Usuario_Multado;
	}

	public void setUsuario_Multado(String usuario_Multado) {
		Usuario_Multado = usuario_Multado;
	}

	public String getPrestamo() {
		return Prestamo;
	}

	public void setPrestamo(String prestamo) {
		Prestamo = prestamo;
	}

	public String getValor_Multa() {
		return Valor_Multa;
	}

	public void setValor_Multa(String valor_Multa) {
		Valor_Multa = valor_Multa;
	}

	public String getFecha_Multa() {
		return Fecha_Multa;
	}

	public void setFecha_Multa(String fecha_Multa) {
		Fecha_Multa = fecha_Multa;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Multas(String id_Multas, String usuario_Multado, String prestamo, String valor_Multa, String fecha_Multa,
			String estado) {
		super();
		this.id_Multas = id_Multas;
		Usuario_Multado = usuario_Multado;
		Prestamo = prestamo;
		Valor_Multa = valor_Multa;
		Fecha_Multa = fecha_Multa;
		Estado = estado;
	}

	public Multas() {
		super();
	}
		
	

}
