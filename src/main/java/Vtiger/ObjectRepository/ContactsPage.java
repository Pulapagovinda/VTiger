package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage

{
	//Declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateContactLookupimg;
	
	//Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateContactLookupimg()
	{
		return CreateContactLookupimg;
	}
	
	
	
	//Business Library
	/**
	 * This method will click on Contacts look up image 
	 */
	public void clickOnCreateContactLookupimg()
	{
		CreateContactLookupimg.click();
	}
		
	
	
}
