package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PacienteDAO;
import model.Paciente;
import model.Persona;

public class PacienteDAOImp implements PacienteDAO {
	ConexionDAO conexion = new ConexionDAO();
	PersonaDAOImp personaDAO = new PersonaDAOImp();

	// Obtener paciente by email
	@Override
	public Paciente getByEmail(String email) throws SQLException {
		Persona persona = personaDAO.getByEmail(email);
		Integer idPersona = persona.getId();
		ResultSet rs = conexion.doQuery("SELECT * FROM `paciente` WHERE id_paciente=" + idPersona );
		if (rs.next()) {
			return new Paciente(persona.getId(), persona.getNombre(), persona.getApellido(), persona.getEmail(),
					persona.getPassword(), persona.getTelefono(), persona.getDni(), persona.getFechaAlta(),
					rs.getDate("fechaNacimiento"), rs.getInt("edad"));
		}
		return null;
	}

	// Lista de todos los pacientes
	@Override
	public List<Paciente> getAll() throws SQLException {
		List<Paciente> listPacientes = new ArrayList<>();
		ResultSet pac = conexion.doQuery("SELECT * FROM `paciente`");
		List<Persona> listPersonas = personaDAO.getAll();

		while (pac.next()) {
			Integer idPac = pac.getInt("id_paciente");
			for (Persona persona : listPersonas) {
				if (persona.getId().equals(idPac)) {
					Paciente paciente = new Paciente(persona.getId(), persona.getNombre(), persona.getApellido(),
							persona.getEmail(), persona.getPassword(), persona.getTelefono(), persona.getDni(),
							persona.getFechaAlta(), pac.getDate("fechaNacimiento"), pac.getInt("edad"));
					listPacientes.add(paciente);
				}
			}
		}
		return listPacientes;
	}

	
	@Override
	public Boolean insert(Paciente p) throws SQLException {
		try {
			/*if( personaDAO.getByEmail(p.getEmail()).getId()!=null ) {
				System.out.print("hola");
				return true;*/

			personaDAO.insert(p);
			p.setId(personaDAO.getByEmail(p.getEmail()).getId());
			conexion.updateDB("INSERT IGNORE INTO `paciente`( `id_paciente`,`fechaNacimiento`, `edad` ) VALUES ( ' " + p.getId() + " ', ' "
					+ p.getNacimiento() + " ', ' " + p.getEdad() + "'" + ")");
			return true;

			} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}

	@Override
	public Boolean update(Paciente p) throws SQLException {
		try {
		personaDAO.update(p);
		p.setId(personaDAO.getByEmail(p.getEmail()).getId());
		conexion.updateDB("UPDATE `paciente` SET `fechaNacimiento`='"+p.getNacimiento()+"',`edad`='"+p.getEdad()+"' WHERE `id_paciente`="+p.getId());
		return true;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}
	
	@Override
	public Boolean delete(Paciente p) throws SQLException {
		try {
			p.setId(personaDAO.getByEmail(p.getEmail()).getId());
			personaDAO.delete(p);
			conexion.updateDB("DELETE FROM `paciente` WHERE id_paciente=" + p.getId());
			return true;
		}catch (Exception e) {
			System.out.print(e);
			return false;
		}	
	}
	
	@Override
	public Paciente getById(Integer id) throws SQLException {
		Persona persona = personaDAO.getById(id);
		ResultSet rs = conexion.doQuery("SELECT * FROM `paciente` WHERE id_paciente=" + id );
		if (rs.next()) {
			return new Paciente(id, persona.getNombre(), persona.getApellido(), persona.getEmail(),
					persona.getPassword(), persona.getTelefono(), persona.getDni(), persona.getFechaAlta(),
					rs.getDate("fechaNacimiento"), rs.getInt("edad"));
		}
		return null;
	}
	
	public List<Paciente> searchP(String word) throws SQLException {
		List<Paciente> listFiltered = new ArrayList<>();
		List<Paciente> listPacientes = getAll();
		for (Paciente pac : listPacientes){
			String email = pac.getEmail();
			String nombre = pac.getNombre();
			String apellido = pac.getApellido();
				if (email.contains(word) || nombre.contains(word) || apellido.contains(word) ) {
					listFiltered.add(pac);
				}
		}
		System.out.print(listFiltered);
		return listFiltered;
	}


	
}
