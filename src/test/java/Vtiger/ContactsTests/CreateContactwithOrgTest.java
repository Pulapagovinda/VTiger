package Vtiger.ContactsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger.BaseClass.BaseClass;
import Vtiger.ObjectRepository.ContactInfoPage;
import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.CreateNewContactsPage;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.OrganizationsPage;

//@Listeners(Vtiger.GenericUtility.ListrImplimentation.class)

public class CreateContactwithOrgTest extends BaseClass
{
	@Test(groups ="RegressionSuit")
	public void createContactOrg() throws Throwable
	{
		
		String ORGNAME  =eUtil.getDatafromExelFile("Contacts", 4, 2)+jUtil.randomNumber();

		String  LASTNAME =eUtil.getDatafromExelFile("Contacts", 5, 2)+jUtil.randomNumber();;

		
		//click on Organization Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		
		//click on Org LookUpimg
		  OrganizationsPage op = new OrganizationsPage(driver);
		  op.clickOnCreateOrgLookupimg();
		   
	   // create new Organization
			CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		     cno.createOrganization(ORGNAME);
		
		     Thread.sleep(5000);

		     
		//click on contact link
		   hp.clickOnContactsLink();
		   
		 //click on contact look up img
		   ContactsPage cp =new ContactsPage(driver);
		   cp.clickOnCreateContactLookupimg();

		   //click on contact with Org
		   CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		   cncp.creareContact(LASTNAME, driver, ORGNAME);
			   	
		    // Validation
				ContactInfoPage cif = new ContactInfoPage(driver);
			  String ORGHEADER=cif.getHeaderText();
			  Assert.assertTrue(ORGHEADER.contains(LASTNAME));
			  System.out.println(ORGHEADER);
			  
		
	}
	
	
}
