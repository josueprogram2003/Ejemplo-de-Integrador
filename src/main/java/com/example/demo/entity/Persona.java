package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor /* CONSTRUCTOR CON TODOS LOS DATOS*/
@NoArgsConstructor /* CONSTRUCTOR SIN DATOS*/
@Data
public class Persona {
	private int id;
	private String nombres;
	private String apellidos;
	private String dni;
	
	public Persona(String nombres, String apellidos, String dni) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
	}
	
	
}
