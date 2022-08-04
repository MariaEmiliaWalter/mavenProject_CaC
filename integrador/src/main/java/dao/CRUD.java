package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import database.ConexionDB;


public class CRUD {
	

	public static ResultSet executeQuery(String query) throws SQLException {
		ConexionDB conexionDB = new ConexionDB();
		Connection conn = conexionDB.getConexion();
		Statement st = conn.createStatement();
		return  st.executeQuery(query);
	}
	
	public static ResultSet select(String tabla, String campos, String condicion) throws SQLException {	
		String query = "SELECT " + campos + " FROM " + tabla;
		if(!condicion.equals(""))
			query += " WHERE " + condicion;
		return executeQuery(query);	
	}
	
	
	public  int insertDB(String tabla, List<String> columna, List<String> tipo, List<String> valor ) throws SQLException {
		int contador = 0;
		String rows = "";
		String values = "";
		String query = "";
		
		query = "INSERT INTO " + tabla + " (";
		
		for (int i = 0; i < columna.size(); i++) {
			rows += columna.get(i)+ ", ";
			values += "?, ";
		}
						
		query += rows.substring(0, rows.length()-2) + ") VALUES (" + values.substring(0, values.length()-2) + ")"; 			
		contador += doUpdate(tipo, valor, query);
		return contador;
	}
	

	public static int update(String tabla, List<String> columna, List<String> tipo, List<String> valor, String condicion) throws SQLException {
		 
		String rows = "";
	//	String values = "";
		String query = "";
		
		query = "UPDATE " + tabla + " SET ";
				
		for(int i = 1; i < columna.size(); i++) {
			rows += columna.get(i) + " = ?, ";
		}
				
	//	values = " WHERE " + columna.get(0) + " = " + valor.get(0);
		query += rows.substring(0, rows.length()-2) + condicion; 
		columna.remove(0);
		tipo.remove(0);
		valor.remove(0);
		
		return doUpdate(tipo, valor, query);
	}

		private static int doUpdate(List<String> tipos, List<String> valores, String query) throws SQLException {
			ConexionDB conexionDB = new ConexionDB();
			Connection conn = conexionDB.getConexion();
			PreparedStatement datos = conn.prepareStatement(query);
			
			for (int i = 0; i < tipos.size(); i++) {
				                
				if (tipos.get(i).equalsIgnoreCase("int"))
					datos.setInt(i+1, Integer.parseInt(valores.get(i)));
			
				if (tipos.get(i).equalsIgnoreCase("double"))
					datos.setDouble(i+1, Double.parseDouble(valores.get(i)));
			
				if (tipos.get(i).equalsIgnoreCase("string"))
					datos.setString(i+1, valores.get(i));
			}
			return datos.executeUpdate();
		}
	
}
