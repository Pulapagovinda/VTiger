package Vtiger.GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Vtiger.BaseClass.BaseClass;

/**
 * This Class provides implementation to ITestlistner Interface of TestNG
 * @author pulapa Govind
 */

public class ListrImplimentation implements ITestListener
{
    
	public void onTestStart(ITestResult result)
	{
	String	methodName=result.getMethod().getMethodName();
		System.out.println("====== Excution Started ========");
	}

	public void onTestSuccess(ITestResult result)
	{
		String	methodName=result.getMethod().getMethodName();
		System.out.println("====== Pass  =======");
	}

	public void onTestFailure(ITestResult result) 
	{
		String	methodName=result.getMethod().getMethodName();
		System.out.println("====== Failure  =======");
		
		System.out.println(result.getThrowable());

		WebDriverFileUtility wu = new WebDriverFileUtility();
		JavaUtility ju = new JavaUtility();
		
		String screenshotname = methodName+ju.getSystemDateinFormat();	

		//Take screen shot for failed test scripts- to attach with bug rising
		try 
		{
			wu.takeScreenShot(BaseClass.sDriver, screenshotname);
		} 
		catch (Throwable e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void onTestSkipped(ITestResult result) 
	{
		String	methodName=result.getMethod().getMethodName();
		System.out.println("====== Skipped  =======");

		System.out.println(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	public void onStart(ITestContext context)
	{
		System.out.println("====== Suite Execution Started ======");
	}

	public void onFinish(ITestContext context) 
	{
		System.out.println("====== Suite Execution Ended ======");
	}
	
}
