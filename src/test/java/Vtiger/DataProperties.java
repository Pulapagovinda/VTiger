package Vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class DataProperties {

	public static void main(String[] args) throws Throwable {
		//Load the Document in java readable format
		FileInputStream fis =new FileInputStream("C:\\Users\\pulap\\eclipse-workspace\\Vtiger\\src\\test\\resources\\data.properties");
		
		
		Properties pObj = new Properties();
		
		pObj.load(fis);
		
		String value =pObj.getProperty("url");
		System.out.println(value);
	}

}
