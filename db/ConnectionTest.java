package db;

import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		try {
			DatabaseMiddleware db = DatabaseMiddleware.getInstance();
			db.createTable();
		} catch (SQLException e) {
			DatabaseMiddleware.printSQLException(e);
		}
	}

}
