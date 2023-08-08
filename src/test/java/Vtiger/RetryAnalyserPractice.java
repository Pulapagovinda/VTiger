package Vtiger;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {

		@Test(retryAnalyzer = Vtiger.GenericUtility.RetryAnalyserImplimentation.class)
		public void sample()
		{
			Assert.fail();
			System.out.println("Hi");
		}
}
