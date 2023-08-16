package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

/**
 * This class consists of generic methods related to property file 
 * @author Nithish
 *
 */
public class PropertyFileUtility {
	/**
	 * This method reads Data from property file based on given key
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromPrpertyFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties p = new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
	
	}

}
