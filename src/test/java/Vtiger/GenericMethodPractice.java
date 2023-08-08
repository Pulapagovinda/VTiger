package Vtiger;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class GenericMethodPractice {

	public static void main(String[] args) //Caller
	  	{
		
			int result =add(20,10);
			System.out.println(result);
	  	}
	public static int add(int a,int b) // Called
		{
			int c=a+b;
			return c;
		}

	

}
