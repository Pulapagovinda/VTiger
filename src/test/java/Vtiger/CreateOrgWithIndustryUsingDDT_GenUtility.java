package Vtiger;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;
import Vtiger.GenericUtility.WebDriverFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustryUsingDDT_GenUtility {

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
		
		String ORGNAME  =efu.getDatafromExelFile("Organizations", 4, 2);
		String INDUSTRY =efu.getDatafromExelFile("Organizations", 4, 3);

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
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		Thread.sleep(3000);
		//Step 6: Choose 'Chemicals' in industry drop down
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		Select s = new Select(industryDropDown);
		s.selectByValue(INDUSTRY);
		
		//Step 7: save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: Validate
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
		
		//Step 9: Logout of Application
		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wfu.moveToElementAction(driver, AdminImg);
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Logout successfull");
	
	}
}


