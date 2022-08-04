package model;

import java.sql.Date;

public class Medico extends Persona{
	private String areaDeTrabajo;

	// ------ GETTERS ------
	public String getAreaDeTrabajo() {
		return areaDeTrabajo;
	}
	
	// ------ SETTERS ------
	public void setAreaDeTrabajo(String areaDeTrabajo) {
		this.areaDeTrabajo = areaDeTrabajo;
	}


	// ------ CONSTRUCTOR ------
	public Medico(Integer id, String nombre, String apellido, String email, String password, Integer telefono, Integer dni,
			Date fechaAlta, String areaDeTrabajo) {
		super(id,nombre, apellido, email, password,  telefono, dni, fechaAlta);
		this.areaDeTrabajo = areaDeTrabajo;
	}
	
	// ----- sin ID-----
	public Medico(String nombre, String apellido, String email, String password, Integer telefono, Integer dni,
			Date fechaAlta, String areaDeTrabajo) {
		super(nombre, apellido, email, password,  telefono, dni, fechaAlta);
		this.areaDeTrabajo = areaDeTrabajo;
		}
	
	// ----- sin fechaAlta-----
	public Medico(String nombre, String apellido, String email, String password, Integer telefono, Integer dni,String areaDeTrabajo) {
		super(nombre, apellido, email, password,  telefono, dni);
		this.areaDeTrabajo = areaDeTrabajo;
		}
	
}
