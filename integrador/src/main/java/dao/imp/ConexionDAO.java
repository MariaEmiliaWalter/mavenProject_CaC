package dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import database.ConexionDB;

public class ConexionDAO {

	public ResultSet doQuery(String query) throws SQLException {
		ConexionDB conexionDB = new ConexionDB();
		Connection conn = conexionDB.getConexion();
		Statement st = conn.createStatement();
		return st.executeQuery(query);
	}

	public boolean updateDB(String query) throws SQLException {
		try {
			ConexionDB conexionDB = new ConexionDB();
			Connection conn = conexionDB.getConexion();
			Statement st = conn.createStatement();
			String sql =query;
			st.executeUpdate(sql);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	

	}


