package smms;
import java.sql.*;

public class SMMS {
	static final String JDBC_DRIVER = "com.sql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/root";
	public SMMS(){
		
	}
	// so every time we open a connection all we have to do is 'Connection con = openConnection();'
	private Connection openConnection() throws SQLException, ClassNotFoundException{
		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL, "root", "root");
		return con;
	}
	private void populateDBTable(String table_name) throws ClassNotFoundException, SQLException{
		Statement stmt = null;
		Connection con = openConnection();
		
		stmt = con.createStatement();
		
		String sql = "INSERT INTO " + table_name + " VALUES "; 
	}
}