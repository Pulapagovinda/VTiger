package Vtiger.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;
import Vtiger.GenericUtility.WebDriverFileUtility;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists of all the basic configuration annotations for 
 * all the common actions
 * @author Govinda.Pulapa
 */
public class BaseClass
{
	public JavaUtility jUtil = new JavaUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverFileUtility wUtil = new WebDriverFileUtility();
	public WebDriver driver = null;
	
	//Only used for listener to take Screenshot
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = "SmokeSuit")
	public void bsConfig()
	{
		System.out.println("====DB Connection Successfull==== ");
		
	}
	
	@BeforeClass(alwaysRun = true)
	public void bcConfig() throws Throwable
	{
		//Read browser name and URL from property File
				String BROWSER = pUtil.getDataFromPropertyFile("browser");
				String URL = pUtil.getDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			System.out.println(BROWSER);
		}
	else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		 driver =new FirefoxDriver();
			System.out.println(BROWSER);
		}
	 else 
		{
			System.out.println("Invalid Brower Name");
		}
		wUtil.maximeWindow(driver);
		wUtil.waitforElementstoLoad(driver);
		
		//Only used for listner to take Screenshot
		sDriver= driver;
	
		
		//Step 3: Load the URL
		driver.get(URL);
		System.out.println("========  Browser Opened =========");

	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable
	{
		String USERNAME  = pUtil.getDataFromPropertyFile("Username");
		String PASSWORD  = pUtil.getDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	
		System.out.println(" ========  Login Successfull ========= ");
	}	
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws Throwable
	{
		//HomePage hp =new HomePage(driver);
		//hp.logOutApp(driver);
		System.out.println("========  LogOut Successfull =========");
	}
	
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("====== Browser Closed =======");
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		
		System.out.println("====DB Connection Successfull==== ");

	}		
}
