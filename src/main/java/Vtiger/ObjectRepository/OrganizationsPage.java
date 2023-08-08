package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage
{
	//Declaration
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateOrgLookupimg;
	
	//Initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getCreateOrgLookupimg()
	{
		return CreateOrgLookupimg;
	}
	
	//Business Library
	/**
	 * This method will click on Organizataion  look up image 
	 */
	public void clickOnCreateOrgLookupimg()
	{
		CreateOrgLookupimg.click();
	}
	
	
	
	
	
	
	
}
