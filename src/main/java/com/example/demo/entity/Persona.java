package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
 /* CONSTRUCTOR CON TODOS LOS DATOS*/
@NoArgsConstructor /* CONSTRUCTOR SIN DATOS*/
@Data
public class Persona {
	private int id;
	private String nombres;
	private String apellidos;
	private String dni;
	private int idescuela;
	private Escuela escuela;
	
	public Persona(String nombres, String apellidos, String dni,int idescuela) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.idescuela=idescuela;
	}

	public Persona(int id, String nombres, String apellidos, String dni, int idescuela) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.idescuela = idescuela;
	}
	
	
	
	
}
