package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	// Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	
	//Initialization
	public ContactInfoPage(WebDriver driver)	
	{
		PageFactory.initElements(driver, this);
	}


	//Utilization
	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	
	//Business Library
	/**
	 * This Method will capture the header text and return it to caller
	 * @return
	 */
	public String getHeaderText()
	{
		
		return ContactHeaderText.getText();
	}

	
	
	
}
