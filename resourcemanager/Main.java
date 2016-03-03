package resourcemanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.ProcessCallback;

public class Main {

	public static void main(String[] args) {
		ResourceManager rm = ResourceManager.getInstance();
		
		List<String> paths = Arrays.asList(
			"res/audio/A_Long_Cold_Sting.wav",
			"res/audio/African_Drums_Sting.wav",
			"res/audio/All_This_Down_Time_Sting.wav",
			"res/audio/Animal_Sting.wav",
			"res/audio/Ask_Rufus.wav",
			"res/audio/Bomber_Sting.wav",
			"res/audio/Cataclysmic_Molten_Core_Sting.wav"
		);
		rm.loadListOfFilesByPath(paths, new ProcessCallback() {
			@Override
			public void callbackStatusPercentage(int percentage) {
				System.out.println(percentage + "%");
			}

			@Override
			public void callbackStatusAction(String action) {
				System.out.println(action);
			}
	    });
	}
	
}
