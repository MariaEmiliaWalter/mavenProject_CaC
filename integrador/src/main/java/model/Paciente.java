package model;

import java.sql.Date;
import java.util.List;


public class Paciente extends Persona {
	
	private Date nacimiento;
	private Integer edad;

	private List<Turno> turnos;

	// ------ GETTERS ------
	public Date getNacimiento() {
		return nacimiento;
	}
	public Integer getEdad() {
		return edad;
	}
	public List<Turno> getTurnos() {
		return turnos;
	}


	// ------ SETTERS ------
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	// ------ CONSTRUCTOR ------
	public Paciente( Integer id, String nombre, String apellido, String email, String password, Integer telefono, Integer dni, Date fechaAlta, Date nacimiento, Integer edad) {
		super(id, nombre, apellido, email, password, telefono, dni, fechaAlta);
		this.nacimiento = nacimiento;
		this.edad = edad;
	}
	
	public Paciente(String nombre, String apellido, String email, String password, Integer telefono, Integer dni,
			Date fechaAlta, Date nacimiento, Integer edad) {
		super(nombre, apellido, email, password, telefono, dni, fechaAlta);
		this.nacimiento = nacimiento;
		this.edad = edad;	
		}

	public Paciente(String nombre, String apellido, String email, String password, Integer telefono, Integer dni,
	 Date nacimiento, Integer edad) {
		super(nombre, apellido, email, password, telefono, dni);
		this.nacimiento = nacimiento;
		this.edad = edad;	
		}

}
