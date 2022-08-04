package dao.imp;

import java.sql.SQLException;

import model.Persona;

public class SessionDAOImp {

	private static PersonaDAOImp personaDAO = new PersonaDAOImp();
	private Persona usuarioActual;

	public void setUsuarioActual(Persona usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

	public Persona getUsuarioActual() {
		return usuarioActual;
	}

	public boolean login(String email, String pass) throws SQLException {
		Boolean val = true;
		try {
			setUsuarioActual(personaDAO.getByEmail(email));
			if (usuarioActual != null) {

				String userP = getUsuarioActual().getPassword();
				if (!pass.equals(userP)) {
					System.out.println("La contraseña es incorrecta.");
					val = false;
				}
			}
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("El usuario actual no existe.");
			val = false;
		}
		return val;
	}

	public boolean logout(String email) {
		Boolean val = true;
		try {
			if (getUsuarioActual().getEmail().equals(email)) {
				return val;
			}
		} catch (IndexOutOfBoundsException iobe) {
			val = false;
		}
		return val;
	}
}
