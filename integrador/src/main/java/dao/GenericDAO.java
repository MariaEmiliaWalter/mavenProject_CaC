package dao;
import java.sql.SQLException;
import java.util.List;

public interface GenericDAO <TipoDato> {
		
		public TipoDato getByEmail(String email) throws SQLException ;
		
		public TipoDato getById(Integer id) throws SQLException ;

		public List<TipoDato> getAll() throws SQLException ;
		
		public Boolean insert(TipoDato name) throws SQLException  ;
		
		public Boolean update(TipoDato name) throws SQLException  ;
		
		public Boolean delete(TipoDato name) throws SQLException  ;
}
