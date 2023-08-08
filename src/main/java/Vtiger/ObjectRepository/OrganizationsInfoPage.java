package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage 
{	
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	//Initialization
	public OrganizationsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrgHeaderText()
	{
		return OrgHeaderText;
	}
	
	//Business Library
	/**
	 * This Method will capture the header text and return it to caller
	 * @return
	 */
	public String getHeaderText()
	{
		return OrgHeaderText.getText();
	}
	
}
