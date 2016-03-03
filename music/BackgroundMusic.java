package music;

import utils.ProcessCallback;
import utils.Utils;

public class BackgroundMusic {
	
	static Sound s;

	public static void main(String[] args) {
		music();
	}
	
	public static void music() {
		/*
		try {
			File file = new File("New_Land" + ".wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.start();
			//Thread.sleep(clip.getMicrosecondLength());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		*/
		s = new Sound("res/audio/The_Simplest_Sting.wav", new ProcessCallback() {
			@Override
			public void callbackStatusPercentage(int percentage) {
				System.out.println(percentage + "%");
			}

			@Override
			public void callbackStatusAction(String action) {
				System.out.println(action);
				s.play();
			}
	    });
		s.play();
		Utils.sleep(10000);
		s.stop();
		Utils.sleep(100000);
	}

}
