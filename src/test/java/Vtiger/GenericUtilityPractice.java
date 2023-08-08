package Vtiger;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable 
	{
		JavaUtility jutil = new JavaUtility();
		int value=jutil.randomNumber();
		System.out.println(value);
		
		System.out.println(jutil.getSystemDate());
		
		System.out.println(jutil.getSystemDateinFormat());
		
		
		PropertyFileUtility pUtil = new PropertyFileUtility();		
		System.out.println(pUtil.getDataFromPropertyFile("url"));
			
			ExcelFileUtility eUtil = new ExcelFileUtility();	
			System.out.println(eUtil.getDatafromExelFile("Trail",3,3));
			
			eUtil.writeDatafromExelFile("Tiger1", 2, 3, "HI");
			
			System.out.println("Data Added");
	}

}
