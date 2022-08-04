package model;

import java.sql.Date;

public class Persona {
	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private Integer telefono;
	private Integer dni;
	private Date fechaAlta;

	// ------ GETTERS ------
	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public Integer getDni() {
		return dni;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	// ------ SETTERS ------

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	// ------ CONSTRUCTOR ------
	public Persona(Integer id, String nombre, String apellido, String email, String password,
			Integer telefono, Integer dni, Date fechaAlta) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.dni = dni;
		this.fechaAlta = fechaAlta;
	}
	
	public Persona(String nombre, String apellido, String email, String password,
			Integer telefono, Integer dni, Date fechaAlta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.dni = dni;
		this.fechaAlta = fechaAlta;
	}
	
	public Persona(String nombre, String apellido, String email, String password,
			Integer telefono, Integer dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.dni = dni;
	}
}
