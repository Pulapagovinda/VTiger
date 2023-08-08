package Vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtility.WebDriverFileUtility;

public class CreateNewContactsPage extends WebDriverFileUtility
{
	//Declaration
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement Savebtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement Lookupimg;
	
	@FindBy(id = "search_txt")
	private WebElement OrgSearchEdt;
	
	@FindBy(name = "search")
	private WebElement OrgSearchBtn;
	
	
	//Initialization
	public CreateNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}


	public WebElement getSavebtn() {
		return Savebtn;
	}


	public WebElement getLookupimg() {
		return Lookupimg;
	}


	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}


	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}
	
	 
	//Business Library
	/**
	 * This method will Create Contact
	 * @param name
	 */
	public void creareContact(String name)
	{
		
		LastNameEdt.sendKeys(name);
		Savebtn.click();	
	}
	
	
	/**
	 * This Method will Create contact with relevant  Organization
	 * @param name
	 * @param driver
	 * @param ORGNAME
	 */
	
	public void creareContact(String name,WebDriver driver, String ORGNAME)
	{
		
		LastNameEdt.sendKeys(name);
		Lookupimg.click();
		
		switchToWindow(driver,"Accounts");
		
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		Savebtn.click();
		
	}		
}
