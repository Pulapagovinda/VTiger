package Vtiger.ObjectRepository;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { // Rule1: Create a seperate POM class for every web page

	// Rule2:Identify the Webelements using @findby,@Findbys,@FindAll
		@FindBy(name="user_name")
		 private WebElement userNameEdt;
		
		@FindBy(name="user_password")
		private WebElement passWordEdt;
		
		@FindBy(id="submitButton")
		private WebElement loginBtn;
		
		//Rule3: Create a constructor to initialize the web elements
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	
		//Rule4 : Provide getters to access these web elements
		public WebElement getUserNameEdt() {
			return userNameEdt;
		}

		public WebElement getPassWordEdt() {
			return passWordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
	
		// Business Library -Project Specific generic Method
		/**
		 * This method will perform Login Operation
		 * @param USERNAME
		 * @param PASSWORD
		 */
		public void loginToApp(String USERNAME,String PASSWORD)
		{
			userNameEdt.sendKeys(USERNAME);
			passWordEdt.sendKeys(PASSWORD);
			loginBtn.click();
		}
}
