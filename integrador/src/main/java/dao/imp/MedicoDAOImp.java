package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MedicoDAO;
import model.Medico;
import model.Persona;

public class MedicoDAOImp implements MedicoDAO {
	ConexionDAO conexion = new ConexionDAO();
	PersonaDAOImp personaDAO = new PersonaDAOImp();
	
	private static final String areaDeTrabajo= "areaDeTrabajo";

	// Obtener paciente by email
	@Override
	public Medico getByEmail(String email) throws SQLException {
		Persona persona = personaDAO.getByEmail(email);
		Integer idPersona = persona.getId();
		ResultSet rs = conexion.doQuery("SELECT * FROM `medico` WHERE id_medico=" + idPersona);
		if (rs.next()) {
			return new Medico(persona.getId(), persona.getNombre(), persona.getApellido(), persona.getEmail(),
					persona.getPassword(), persona.getTelefono(), persona.getDni(), persona.getFechaAlta(),
					rs.getString(areaDeTrabajo));
		}
		return null;
	}

	// Lista de todos los medicos
	@Override
	public List<Medico> getAll() throws SQLException {
		List<Medico> listMedicos = new ArrayList<>();
		ResultSet med = conexion.doQuery("SELECT * FROM `medico`");
		List<Persona> listPersonas = personaDAO.getAll();

		while (med.next()) {
			Integer idMed = med.getInt("id");
			for (Persona persona : listPersonas) {
				if (persona.getId().equals(idMed)) {
					Medico medico = new Medico(persona.getId(), persona.getNombre(), persona.getApellido(),
							persona.getEmail(), persona.getPassword(), persona.getTelefono(), persona.getDni(),
							persona.getFechaAlta(), med.getString(areaDeTrabajo));
					listMedicos.add(medico);
				}
			}
		}
		return listMedicos;
	}

	@Override
	public Boolean insert(Medico m) throws SQLException {
		try {
			personaDAO.insert(m);
			m.setId(personaDAO.getByEmail(m.getEmail()).getId());
			conexion.updateDB("INSERT IGNORE INTO `medico`( `id_medico`, `areaDeTrabajo` ) VALUES ( ' " + m.getId() + " ' , ' "
					+ m.getAreaDeTrabajo() + " ' )");
			return true;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}

	@Override
	public Boolean update(Medico m) throws SQLException {
		try {
		//personaDAO.update(m);
		Boolean pers = personaDAO.update(m);
		System.out.println(pers);
		return conexion.updateDB("UPDATE `medico` SET `areaDeTrabajo`='"+m.getAreaDeTrabajo()+"' WHERE `id_medico`="+m.getId());
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}

	@Override
	public Boolean delete(Medico m) throws SQLException {
		try {
			m.setId(personaDAO.getByEmail(m.getEmail()).getId());
			personaDAO.delete(m);
			conexion.updateDB("DELETE FROM `medico` WHERE `id_medico`=" + m.getId() );
			return true;
		}catch (Exception e) {
			System.out.print(e);
			return false;
		}	
	}


	@Override
	public Medico getById(Integer id) throws SQLException {
		Persona persona = personaDAO.getById(id);
		ResultSet rs = conexion.doQuery("SELECT * FROM `medico` WHERE id_medico=" + id );
		if (rs.next()) {
			return new Medico(id, persona.getNombre(), persona.getApellido(), persona.getEmail(),
					persona.getPassword(), persona.getTelefono(), persona.getDni(), persona.getFechaAlta(),
					rs.getString(areaDeTrabajo));
		}
		return null;
	}

}
