package Vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * This class consist of all Generic Methods Related to java
 * @author pulapa Govinda
 *
 */

public class JavaUtility {
/**
 * This Method will generate a random number for every execution
 * @ return Random Value 
 * 
 */
public int randomNumber()
   	{
		Random r = new Random();
		int ran=r.nextInt(1000);
		return ran;
		
   	}
/**
 * @return
 */

public String getSystemDate()
	{
		Date d=new Date();
		String date=d.toString();
		return date;
	}
public String getSystemDateinFormat()
    {
	
	Date d=new Date();
	String[] date=d.toString().split(" ");
		
	String currentDate=date[2];
	String month=date[1];
	String year=date[5];
	String time=date[3].replace(":","_");
	
	String DateInFormat =currentDate+" /"+month+" /"+year+"  "+time;


		return DateInFormat;
	
	}

}