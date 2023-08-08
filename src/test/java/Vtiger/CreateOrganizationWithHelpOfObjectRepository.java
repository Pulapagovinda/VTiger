package Vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;
import Vtiger.GenericUtility.WebDriverFileUtility;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationsInfoPage;
import Vtiger.ObjectRepository.OrganizationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithHelpOfObjectRepository {

	public static void main(String[] args) throws Throwable {
		
		// Create object of required Utilities
		JavaUtility          ju =new JavaUtility();
		PropertyFileUtility  pfu = new PropertyFileUtility();
		ExcelFileUtility     efu = new ExcelFileUtility();
		WebDriverFileUtility wfu =new WebDriverFileUtility();
		
		WebDriver driver =null;
				
		//Step1 Read all the necessary data
		String BROWSER   = pfu.getDataFromPropertyFile("browser");
		String URL       = pfu.getDataFromPropertyFile("url");					
		String USERNAME  = pfu.getDataFromPropertyFile("Username");
		String PASSWORD  = pfu.getDataFromPropertyFile("password");
		
		String ORGNAME  =efu.getDatafromExelFile("Organizations", 4, 2);
		String INDUSTRY =efu.getDatafromExelFile("Organizations", 4, 3);

		int RandomNUM   =ju.randomNumber();
		                
		//Step 2: Launch the browser - driver is acting based runtime data - RunTime polymorphism
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
		wfu.maximeWindow(driver);
		wfu.waitforElementstoLoad(driver);
		
		
		//Step 3: Load the URL
		driver.get(URL);
		
	//Step 4: Login to the Application
		LoginPage lp =new LoginPage(driver);
	/*	lp.getUserNameEdt();
		lp.getPassWordEdt();
		lp.getLoginBtn(); */
		
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		//Step 5: Click on Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		
		//Step 6: click on Create Organization look up image
		OrganizationsPage op = new OrganizationsPage(driver );
		op.clickOnCreateOrgLookupimg();
		
		
		//Step 6: create Organization With Industry
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createOrganization(ORGNAME+RandomNUM, INDUSTRY);
		
		//Step 8: Validate
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String OrgHeader=oip.getHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);
		
		/*
		  
		 if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("Fail");
		}
		*/
		
		//Step 9: Logout of Application
		hp.logOutApp(driver);
		
		System.out.println("Logout successfull");
	
	}

}
