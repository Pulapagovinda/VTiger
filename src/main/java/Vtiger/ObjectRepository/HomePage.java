package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtility.WebDriverFileUtility;

public class HomePage extends WebDriverFileUtility
{
	@FindBy(linkText = "Organizations")
	private WebElement organizataionLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstraorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	public WebElement getOrganizataionLink() {
		return organizataionLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getAdminstraorImg() {
		return adminstraorImg;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business Library
	/**
	 * This method will click on OrganizationLink
	 */
	public void clickOnOrgLink()
	{
		organizataionLink.click();
		
	}
	
	/**
	 * This method will click on ContactsLink
	 */
	public void clickOnContactsLink()
	{
		contactsLink.click();
	}
	
	/**
	 * This method will logout of application
	 * @param driver
	 * @throws Throwable
	 */
	public void logOutApp(WebDriver driver) throws Throwable
	{
		moveToElementAction(driver, adminstraorImg);
		Thread.sleep(2000);
		signOut.click();
	}
	
	
	
	
	
	
	
	
}
