package com.pengsheng.eims.util.tools;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesUtil {
	
	private static Properties prop;
	
	public static Properties getProperties(String relativeFilePath) {
		
		FileInputStream fis;
		
		try {
			fis = new FileInputStream(relativeFilePath);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}

}