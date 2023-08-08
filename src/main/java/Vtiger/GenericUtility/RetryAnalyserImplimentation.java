package Vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * 	This class provides implimentation for IRetryanlyser Interface
 * @author pulapa Govinda
 */

public class RetryAnalyserImplimentation implements IRetryAnalyzer

{
	int count =1;
	int retryCount = 3;
	
	public boolean retry(ITestResult result)
	{		
		//1<=3 2<=3 3<=3 4<=3
		while(count<=retryCount)
		{
			count++;
			return	true; //retry retry retry
		}
		
		return false; // no retry		
	}
	
}
