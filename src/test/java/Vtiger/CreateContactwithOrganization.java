package Vtiger;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;
import Vtiger.GenericUtility.WebDriverFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactwithOrganization {

	public static void main(String[] args) throws Throwable {
		// Create object of required Utilities
		JavaUtility ju =new JavaUtility();
		PropertyFileUtility pfu = new PropertyFileUtility();
		ExcelFileUtility efu = new ExcelFileUtility();
		WebDriverFileUtility wfu =new WebDriverFileUtility();
		WebDriver driver =null;
		
		
		//Step1 Read all the necessary data
		String BROWSER   =pfu.getDataFromPropertyFile("browser");
		String URL       =pfu.getDataFromPropertyFile("url");					
		String USERNAME  =pfu.getDataFromPropertyFile("Username");
		String PASSWORD =pfu.getDataFromPropertyFile("password");
		
		String ORGNAME  =efu.getDatafromExelFile("Contacts", 4, 3);
		String LASTNAME =efu.getDatafromExelFile("Contacts", 5, 2);

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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 5: Click on Organizations Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 6: click on Create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 6: create Organization
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+ju.randomNumber());
		

		//Step 7: save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: Validate for Organization
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("Fail");
		}
		
		//Step9: Create Contact using Oganization
		driver.findElement(By.linkText("Contacts")).click();
		
		// Step 10: Navigate to create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		// step 11: Create a contact with mandatory information
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		// Step 11: switch to child window
		wfu.switchToWindow(driver, "Accounts");
		
		// Step 12: search for Organization
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click();  // dynamic xpath

		// Step 13: switch the control back to parent window
		wfu.switchToWindow(driver, "Contacts");
		
		// Step 14: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// Step 15: Validate for Organization
		String ContactHeader = 	driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (ContactHeader.contains(LASTNAME)) {
			System.out.println("PASS");
			System.out.println(ContactHeader);
		} 
		else
                 {
			System.out.println("Fail");
		}
		
		
		//Step 9: Logout of Application
		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wfu.moveToElementAction(driver, AdminImg);
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Logout successfull");
	
	}
	}


