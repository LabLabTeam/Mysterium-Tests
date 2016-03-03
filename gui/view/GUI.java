package gui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends View implements ActionListener {
	
	private static JFrame window;
	private static GUI instance;
	
	public GUI() {
		GUI.instance = this;
	}
	
	
	public void displayLoadingScreen() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//Create and set up the window.
				if (GUI.window != null) {
					GUI.window.setVisible(false); //you can't see me!
					GUI.window.dispose(); //Destroy the JFrame object
				}
				
				GUI.window = new JFrame();
				GUI.window.setUndecorated(true);
				
				GUI.window.setTitle("Loading...");
				GUI.window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
			    JPanel panel = new JPanel();
			    ImageIcon pic = new ImageIcon("logo.jpg");
			    panel.add(new JLabel(pic));
			    
			    //JLabel label = new JLabel("Loading...");
				//panel.add(label);
			    
			    GUI.window.add(panel);
			    GUI.window.pack();
			    GUI.window.setVisible(true);
			    GUI.window.setLocationRelativeTo(null);
            }
        });
    }
	
	public void displayGameWindow() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//Create and set up the window.
				if (GUI.window != null) {
					GUI.window.setVisible(false); //you can't see me!
					GUI.window.dispose(); //Destroy the JFrame object
				}
				
				GUI.window = new JFrame();
				GUI.window.setTitle("Picture Application");
				GUI.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				GUI.window.setSize(500, 500);
				
				JPanel panel = new JPanel();
				
				JLabel label = new JLabel("Cluedo Game");
				panel.add(label);
				
				
				JButton button1 = new JButton("Increase");
				button1.addActionListener(instance);
				panel.add(button1);
				
				GUI.window.getContentPane().add(panel);
				
			    //GUI.window.pack();
			    GUI.window.setVisible(true);
			    GUI.window.setLocationRelativeTo(null);
				
            }
        });
	}
	
	
	public void actionPerformed(ActionEvent e) {
        System.out.println("Pressed!");
    }
	
	
	private static void cluedoLogo() {
        //Create and set up the window.
		GUI.window = new JFrame();
		GUI.window.setUndecorated(true);
		
		GUI.window.setTitle("Picture Application");
		GUI.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel panel1 = new JPanel();
	    ImageIcon pic = new ImageIcon("logo.png");
	    panel1.add(new JLabel(pic));
	    GUI.window.add(panel1);
	    GUI.window.pack();
	    GUI.window.setVisible(true);
	    GUI.window.setLocationRelativeTo(null);
    }
}
