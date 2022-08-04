package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDAO;
import model.Paciente;
import model.Persona;

public class PersonaDAOImp implements PersonaDAO {
	ConexionDAO conexion = new ConexionDAO();

	@Override
	public Persona getByEmail(String email) throws SQLException {

		ResultSet per = conexion.doQuery("SELECT * FROM `persona` WHERE email= '" + email.trim() + "'");
		if (per.next()) {
			return new Persona(per.getInt("id"), per.getString("nombre"), per.getString("apellido"),
					per.getString("email"), per.getString("password"), per.getInt("telefono"), per.getInt("dni"),
					per.getDate("fechaAlta"));
		}
		return null;
	}

	@Override
	public List<Persona> getAll() throws SQLException {
		List<Persona> listPersonas = new ArrayList<>();
		ResultSet per = conexion.doQuery("SELECT * FROM `persona`");
		while (per.next()) {
			Persona persona = new Persona(per.getInt("id"), per.getString("nombre"), per.getString("apellido"),
					per.getString("email"), per.getString("password"), per.getInt("telefono"), per.getInt("dni"),
					per.getDate("fechaAlta"));
			listPersonas.add(persona);
		}
		return listPersonas;
	}

	@Override
	public Boolean insert(Persona p) throws SQLException {
		try {
			conexion.updateDB(
					"INSERT IGNORE  INTO `persona`( `nombre`, `apellido`, `email`, `password`, `telefono`, `dni`, `fechaAlta`) VALUES ("
							+ "'" + p.getNombre() + "'" + ',' + "'" + p.getApellido() + "'" + ',' + "'" + p.getEmail()
							+ "'" + ',' + "'" + p.getPassword() + "'" + ',' + "'" + p.getTelefono() + "'" + ',' + "'"
							+ p.getDni() + "'" + ',' + "'" + p.getFechaAlta() + "'" + ")");
			return true;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}

	public boolean validationUser(String email, String password) throws SQLException {
		try {
			ResultSet rs = conexion.doQuery("SELECT * FROM persona WHERE email = '" + email.trim() + "' AND password ='"
					+ password.trim() + "'");
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean isAdmin(String email) throws SQLException {
		String query = "SELECT id FROM persona WHERE email = '" + email.trim() + "'";
		query = "SELECT 1 FROM medico WHERE id_medico = (" + query + ")";
		ResultSet rs = conexion.doQuery(query);
		if (rs.next()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean update(Persona p) throws SQLException {
		try {
			return conexion.updateDB("UPDATE `persona` SET `nombre`='" + p.getNombre() +"',`apellido`='"+p.getApellido()+"',`email`='"+p.getEmail()+"',`password`='"+p.getPassword()+"',`telefono`='"+p.getTelefono()+"',`dni`='"+p.getDni()+"' WHERE `id`="+p.getId());
		}catch (Exception e) {
			System.out.print(e);
			return false;
		}	
	}

	@Override
	public Boolean delete(Persona p) throws SQLException {
		try {
			conexion.updateDB("DELETE FROM `persona` WHERE `id`=" + p.getId() );
			return true;
		}catch (Exception e) {
			System.out.print(e);
			return false;
		}	
	}
	
	@Override
	public Persona getById(Integer id) throws SQLException {
		ResultSet rs = conexion.doQuery("SELECT * FROM `persona` WHERE id=" + id );
		if (rs.next()) {
			return new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
					rs.getString("email"), rs.getString("password"), rs.getInt("telefono"), rs.getInt("dni"),
					rs.getDate("fechaAlta"));
		}
		
		return null;
	}

}
