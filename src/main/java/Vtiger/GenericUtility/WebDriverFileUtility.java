package Vtiger.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all the reusable methods related to webDriver Actions
 * @author pulapa govind.
 *
 */
public class WebDriverFileUtility 
{
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	
	}
	
	/**
	 * This Method will wait for all the findElement and finndElements operations to be performed 
	 * @param driver
	 */
	public void waitforElementstoLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This Method will wait until the specified element is visible in DOM
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
/**
 * This method will handle dropdown using index
 * @param element
 * @param index
 */
	public void handleDropDown(WebElement element,int index)
	{
		Select sel = new Select(element);
		 sel.selectByIndex(index);
	}
/**
 * * This method will handle dropdown using value
 * @param element
 * @param value
 */
	public void handleDropDown(WebElement element,String value)
	{
		Select sel = new Select(element);
		 sel.selectByValue(value);
	}
/**
 *  This method will handle dropdown using VisibleText
 * @param value
 * @param element
 */
	public void handleDropDown(String value ,WebElement element)
	{
		Select sel = new Select(element);
		 sel.selectByVisibleText(value);
	}

/**
 * This method will perform mouse hover action on a target element
 * @param driver
 * @param element
 */
	public void moveToElementAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
/**
 * This method will double click anywhere on the web page
 * @param driver
 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
/**
 * This method will double click on a web element 
 * @param driver
 * @param element
 */
	public void doubleClickAction(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform right click anywhere on the web page
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions( driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on a particular webElement
	 * @param driver
	 */	
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions( driver);
			act.contextClick(element).perform();
	}
	
	/** 
	 * This method will perform drag and drop action
	 * @param driver
	 * @param srcElement
	 * @param trgtElement
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement trgtElement)
	{
		Actions act = new Actions( driver);
		act.dragAndDrop(srcElement, trgtElement).perform();		
	}
	
/**
 * This method is used to move the cursor anywhere on the web page based on offset values	
 * @param driver
 * @param xOffset
 * @param yOffset
 */
	public void moveAcrossWebPage(WebDriver driver, int xOffset,int yOffset)
	{
		Actions act = new Actions( driver);
			act.moveByOffset(xOffset, yOffset).perform();
	}
	
/**
 * 	This Method will scroll vertically for 500 pixels
 * @param driver
 */
	public void scrollAction(WebDriver driver)	
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);", "");	
	}
/**
 * This method will scroll vertically until the element reference
 * @param driver
 * @param element
 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+");", element);
		
		/*		                          (OR)
		                          
		 	js.executeScript("arguments[0].scrollIntoView();", element);
	     */		
	}
	
	/**
	 * This method will accept the alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel the confirmation pop up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will enter the text in prompt pop up
	 * @param driver
	 */
	public void sendTextToAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}

	/**
	 * This method will capture the alert message and return to the caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle frame based on Index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
/**
 * This method will handle frame based on value of name or ID attributes 
 * @param driver
 * @param nameOrId
 */
	public void handleFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * This method will handle frame based on web element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
/**
 * This method will help to switch the control back to immediate parent
 * @param driver
 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}

	/**
	 * This method will help to switch the control back to current page 
	 * @param driver
	 */
	public void switchToDefaultPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}


	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		//step1 : Capture all the window IDs 
		Set<String> allWindowIds=driver.getWindowHandles();
		
		//step2: Iterate Through idividals IDs
		   for(String winID:allWindowIds)
		   {
			   
			   //Step3 : Switch to each id and Capture the Title
			 String currenTitle=  driver.switchTo().window(winID).getTitle();
			   
			   //Step4: Compare the Title with reqired reference
			   if( currenTitle.contains(partialWinTitle))
			   {
				   break;
			   }
		   }
	}
	/**
	 * This method will take screenshot and return the absolute path of it
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws Throwable
	 */
	public String takeScreenShot(WebDriver driver,String screenshotname) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dist=new File(".\\ScreenShots"+screenshotname+".png");
		
		Files.copy(src, dist); // This class is from commons  IO Tool
		
		return dist.getAbsolutePath(); //attach the screenshot to extent reports
		
		
	}

}






