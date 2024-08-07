package custs;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DatabaseConn {
	static String URL = "jdbc:mysql://localhost:3306/customers";
	static String User = "root";
	static String Password = "mohitnair"; //Imma change the password
	
	static Connection obtainConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, User, Password);
			if (conn == null) {
				System.out.println("Failed to make connection. ");
			}
			return conn;			
		}
		catch (SQLException ex) {
			System.out.println("Failed to make connection.");	
			return null;
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Failed to make connection.");		
			return null;
		}
	}
}
