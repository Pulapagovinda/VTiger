package Vtiger;

import org.testng.annotations.Test;

public class ReadDataFromcmdLineTest {
	@Test
	public void readData()
	{
	String un=System.getProperty("username");
		System.out.println(un);
		
		String pwd=System.getProperty("password");
		System.out.println(pwd);
	
	}
}
