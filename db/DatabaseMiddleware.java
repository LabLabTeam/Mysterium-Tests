package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DatabaseMiddleware {
	
	private static final String IP = "localhost";
	private static final String PORT = "3306";
	private static final String DB = "mysterium";
	private static final String USERNAME = "mysterium";
	private static final String PASSWORD = "mysterium";
	
	private static DatabaseMiddleware Instance = null;
	private static Connection connection;
	
	private DatabaseMiddleware() throws SQLException {
		DatabaseMiddleware.connection = DatabaseMiddleware.getConnection();
	}
	
	public static DatabaseMiddleware getInstance() throws SQLException {
		if (DatabaseMiddleware.Instance == null) {
			DatabaseMiddleware.Instance = new DatabaseMiddleware();
		}
		return DatabaseMiddleware.Instance;
	}
	
	private static Connection getConnection() throws SQLException {
	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", DatabaseMiddleware.USERNAME);
	    connectionProps.put("password", DatabaseMiddleware.PASSWORD);

	    conn = DriverManager.getConnection("jdbc:mysql://"+DatabaseMiddleware.IP+":"+DatabaseMiddleware.PORT+"/"+DatabaseMiddleware.DB, connectionProps);
	    System.out.println("Connected to database");
	    return conn;
	}
	
	public static void printSQLException(SQLException ex) {
		System.err.println("Message: " + ex.getMessage());
		/*
	    for (Throwable e : ex) {
	        if (e instanceof SQLException) {
	        	e.printStackTrace(System.err);
                System.err.println("SQLState: " +
                    ((SQLException)e).getSQLState());

                System.err.println("Error Code: " +
                    ((SQLException)e).getErrorCode());

                System.err.println("Message: " + e.getMessage());

                Throwable t = ex.getCause();
                while(t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
	        }
	    }
	    */
	}
	
	public void createTable() throws SQLException {
	    String createString =
	        "create table " + DatabaseMiddleware.DB +
	        ".SUPPLIERS " +
	        "(SUP_ID integer NOT NULL, " +
	        "SUP_NAME varchar(40) NOT NULL, " +
	        "STREET varchar(40) NOT NULL, " +
	        "CITY varchar(20) NOT NULL, " +
	        "STATE char(2) NOT NULL, " +
	        "ZIP char(5), " +
	        "PRIMARY KEY (SUP_ID))";

		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(createString);
		} catch (SQLException e) {
			DatabaseMiddleware.printSQLException(e);
		} finally {
			if (stmt != null) { stmt.close(); }
		}
	}
}
