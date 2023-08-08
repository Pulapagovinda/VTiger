package Vtiger.ObjectRepository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtility.WebDriverFileUtility;

public class CreateNewOrganizationPage extends WebDriverFileUtility
{
	//Initialization
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	 //Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrgName() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getSaveBtn() 
	{
		return SaveBtn;
	}
	
	//Business Libraries
	/**
	 * This Method will create Organization with mandatory fields
	 * @param ORGNAME
	 */
	public void createOrganization(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	
	public void createOrganization(String ORGNAME, String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(INDUSTRY, IndustryDropDown);	
		SaveBtn.click();
	}
	
}
