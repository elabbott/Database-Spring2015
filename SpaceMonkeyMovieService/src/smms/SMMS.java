package smms;
import java.sql.*;

public class SMMS {
	static final String JDBC_DRIVER = "com.sql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/smms";
	public SMMS(){
		
	}
	// so every time we open a connection all we have to do is 'Connection con = openConnection();'
	public Connection openConnection() throws SQLException, ClassNotFoundException{
		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL, "root", "root");
		return con;
	}
}
