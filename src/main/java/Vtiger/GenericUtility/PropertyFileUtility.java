package Vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consist of GenericMethods related to Property file
 * @author pulapa Govinda
 *
 */
public class PropertyFileUtility{
/**
 * This method reads Data from property file based on given key 
 * @throws Throwable 
 */
public String getDataFromPropertyFile(String key) throws Throwable 	
{
	FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\data.properties");
	
	
	Properties p = new Properties();
	
	p.load(fis);
	
	String value =p.getProperty(key);
	
	return value;

}
}