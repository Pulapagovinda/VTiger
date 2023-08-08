package Vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustryByUsingDDT {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		//Read Data From Properties File -CommonData
		FileInputStream fisp =new FileInputStream("C:\\Users\\pulap\\eclipse-workspace\\Vtiger\\src\\test\\resources\\data.properties");
		
		
		Properties pObj = new Properties();
		
		pObj.load(fisp);
		
		String BROWSER =pObj.getProperty("browser");
		String URL =pObj.getProperty("url");
		String USERNAME =pObj.getProperty("Username");
		String PASSWORD =pObj.getProperty("password");

		/* Read Data from Excel sheet - Test data */
   FileInputStream fise = new FileInputStream("C:\\Users\\pulap\\eclipse-workspace\\Vtiger\\src\\test\\resources\\TestData.xlsx");
		
		//Create a workBook for the file Loaded
		Workbook wb =WorkbookFactory.create(fise);
		
		Sheet sh=wb.getSheet("Organizations");
		String	OrgName	=sh.getRow(4).getCell(2).getStringCellValue();

		String Industry=sh.getRow(4).getCell(3).getStringCellValue();

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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
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
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		Thread.sleep(3000);
		//Step 6: Choose 'Chemicals' in industry drop down
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		Select s = new Select(industryDropDown);
		s.selectByValue(Industry);
		
		//Step 7: save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(OrgName))
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
		Actions act = new Actions(driver);
		act.moveToElement(AdminImg).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Logout successfull");
		
		
	
	
	
	
	}

}
