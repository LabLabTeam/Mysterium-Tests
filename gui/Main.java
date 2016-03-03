package gui;

import gui.view.GUI;
import gui.view.View;
import utils.Utils;

public class Main {

	public static void main(String[] args) {
		View v = new GUI();
		v.displayLoadingScreen();
		Utils.sleep(2000);
		v.displayGameWindow();
	}

}
