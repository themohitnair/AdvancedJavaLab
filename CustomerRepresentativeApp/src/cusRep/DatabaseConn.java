package cusRep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cusrep";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "mohitnair";

    static Connection getConn() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            System.out.println("Connection successful");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed.");
            e.printStackTrace();
        }
        return connection;
    }
}
