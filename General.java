import java.sql.SQLException;

import db.DatabaseMiddleware;
import gui.view.GUI;
import gui.view.View;
import music.BackgroundMusic;

public class General {

	public static void main(String[] args) {
		View v = new GUI();
		v.displayLoadingScreen();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			DatabaseMiddleware db = DatabaseMiddleware.getInstance();
			//db.createTable();
		} catch (SQLException e) {
			DatabaseMiddleware.printSQLException(e);
		}
		
		v.displayGameWindow();
		BackgroundMusic.music();
	}

}
