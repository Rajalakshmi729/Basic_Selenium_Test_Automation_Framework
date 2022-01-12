package commonMethods_reusableComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesOperations {
	
	static Properties prop = new Properties();
	
	public static String getPropertyValueByKey(String key) throws IOException {
		//load data from property file
		String propFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\config.properties";
		FileInputStream fis = new FileInputStream(propFilePath);
			
		prop.load(fis);
		// read data
		String value = prop.get(key).toString();
		
		return value;
		
		
		
	}
	

}
