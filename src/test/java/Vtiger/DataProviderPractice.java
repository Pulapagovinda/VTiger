package Vtiger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test
	public void addToCartTest()
	{
		
	}
	
	@DataProvider 
	public Object[][] getData()
	{
		Object[][] data = new Object[3][3];
		
		data[0][0] = "Iphone";// 1st set of Data
		data[0][1] = 2000;
		data[0][2] = "I13";
				
		data[1][0] = "Samsung";// 2nd set of Data
		data[1][1] = 5000;
		data[1][2] = "S13";
						
		data[0][0] = "Vivo";// 3rd set of Data
		data[0][1] = 2000;
		data[0][2] = "y12";
		return data;
						
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
