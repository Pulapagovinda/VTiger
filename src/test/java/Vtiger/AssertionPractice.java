package Vtiger;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice
{
	@Test
	public void sampleTest()
	{
		SoftAssert sa = new SoftAssert();
		
		int a=1; //expect
		int b=2; //actual
		
		System.out.println("Step 1");
		System.out.println("Step 2");

		//Assert.assertEquals(b, a);
		System.out.println("Step 3");
		System.out.println("Step 110");
		
		sa.assertTrue(true);
		
		System.out.println("Happy Birthday to you");
		
		//sa.assertAll(); //logging the all failures		
		
	}
}
