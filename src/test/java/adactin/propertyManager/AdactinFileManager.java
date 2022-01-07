package adactin.propertyManager;

import adactin.propertyReader.AdactinConfigReader;

public class AdactinFileManager {
	
	private  AdactinFileManager fm;
	private static AdactinConfigReader cr;
	
	private AdactinFileManager() {}
	
//	private  AdactinFileManager getInstance() {
//		fm = new AdactinFileManager();
//		return fm;
//	}
//	
	public static AdactinConfigReader configReader() throws Throwable {
		cr = new AdactinConfigReader();
		return cr;
	}
}


