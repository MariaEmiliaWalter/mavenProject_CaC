package model;

public class Turno {

	private Integer id;
	private String fecha;
	private String horario;
	private Integer id_paciente;
	private Boolean activo;
	
	
	// ------ GETTERS ------
	public Integer getId() {
		return id;
	}
	public String getFecha() {
		return fecha;
	}
	public String getHorario() {
		return horario;
	}
	public Integer getId_paciente() {
		return id_paciente;
	}
	public Boolean getActivo() {
		return activo;
	}
	
	
	// ------ SETTERS ------
	public void setId(Integer id) {
		this.id = id;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
		
	
	// ------ CONSTRUCTOR ------
	public Turno(Integer id, String fecha, String horario, Integer id_paciente, Boolean activo) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.horario = horario;
		this.id_paciente = id_paciente;
		this.activo = activo;
	}
	
}
