package resourcemanager;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import utils.ProcessCallback;
import utils.Utils;

public class ResourceManager {
	private static ResourceManager Instance = null;
	private static HashMap<String, File> resourceMap;
	
	private ResourceManager() {
		resourceMap = new HashMap<String, File>();
	}
	
	public static ResourceManager getInstance() {
		if (ResourceManager.Instance == null) {
			ResourceManager.Instance = new ResourceManager();
		}
		return ResourceManager.Instance;
	}
	
	public void loadListOfFilesByPath(List<String> paths, ProcessCallback cb) {
		for (int i = 0; i < paths.size(); i++) {
			if (cb != null) {
				cb.callbackStatusAction("Loading file: " + paths.get(i));
			}
			loadFileByPath(paths.get(i), null);
			if (cb != null) {
				cb.callbackStatusPercentage((i + 1) * 100 / paths.size() );
			}
			
		}
	}
	
	public void loadFileByPath(String path, ProcessCallback cb) {
		if (cb != null) {
			cb.callbackStatusAction("Loading file: " + path);
		}
		if (resourceMap.containsKey(path)) {
			if (cb != null) {
				cb.callbackStatusAction("File "+ path +" already loaded");
				cb.callbackStatusPercentage(100);
			}
		} else {
			resourceMap.put(path, new File(path));
			Utils.sleep(100);
			if (cb != null) {
				cb.callbackStatusPercentage(100);
			}
		}
	}
	
}
