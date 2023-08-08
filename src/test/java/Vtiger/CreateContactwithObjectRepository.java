package Vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;
import Vtiger.GenericUtility.WebDriverFileUtility;
import Vtiger.ObjectRepository.ContactInfoPage;
import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.CreateNewContactsPage;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactwithObjectRepository 
{
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
	
	String ORGNAME  =efu.getDatafromExelFile("Contacts", 4, 3)+ju.randomNumber();
	String  LASTNAME =efu.getDatafromExelFile("Contacts", 5, 2);

	                
	
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

	lp.loginToApp(USERNAME, PASSWORD);

	//Step 5: Click on Organizations Link
	 HomePage hp = new HomePage(driver);
	 hp.clickOnOrgLink();
	
	//Step 6: click on Create Organization look up image
	 OrganizationsPage op = new OrganizationsPage(driver );
	 op.clickOnCreateOrgLookupimg();
	
	//Step 7: Create New Organization
	CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
	     cno.createOrganization(ORGNAME);
	
	     Thread.sleep(3000);
	     
	//Step 8: Click on contacts Link
	  hp.clickOnContactsLink();
	  
	// Step 9: click on Create Contacts look up image   
		ContactsPage cp =new ContactsPage(driver);
		cp.clickOnCreateContactLookupimg();
		
    //Step 10: Create contact with Organization
		CreateNewContactsPage cnp = new CreateNewContactsPage(driver);
		cnp.creareContact(LASTNAME, driver, ORGNAME);
		
	//Step 12: Validation
		ContactInfoPage cif = new ContactInfoPage(driver);
	  String ORGHEADER=cif.getHeaderText();
	  if(ORGHEADER.contains(LASTNAME))
	  {
		  System.out.println("Pass");
		  System.out.println(ORGHEADER);
	  }
	  else
	  {
		  System.out.println("Fail");
	  }	  
		
	//LogOut
	  hp.logOutApp(driver);
	  System.out.println("Logout successfull");			
   }
}
