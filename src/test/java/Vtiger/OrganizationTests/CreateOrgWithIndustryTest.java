package Vtiger.OrganizationTests;

import org.testng.annotations.Test;


import org.testng.annotations.Test;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;

import Vtiger.BaseClass.BaseClass;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.OrganizationsInfoPage;
import Vtiger.ObjectRepository.OrganizationsPage;

@Listeners(Vtiger.GenericUtility.ListrImplimentation.class)

public class CreateOrgWithIndustryTest  extends BaseClass
{
	
	@Test(groups ="SmokeSuit")
	public void CreOrgWithIndTest() throws Throwable	
	{	
		String ORGNAME  =eUtil.getDatafromExelFile("Organizations", 7, 2)+jUtil.randomNumber();
		String INDUSTRY =eUtil.getDatafromExelFile("Organizations", 4, 3);
	
	       //Step 5: Click on Organizations Link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrgLink();
			Reporter.log("org clicked");
			
			//Step 6: click on Create Organization look up image
			OrganizationsPage op = new OrganizationsPage(driver );
			op.clickOnCreateOrgLookupimg();
			Reporter.log("look up clicked");
			
			//Assert.fail();

			
			//Step 6: create Organization With Industry
			CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
			cno.createOrganization(ORGNAME, INDUSTRY);
			//Step 8: Validate
			OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
			String OrgHeader=oip.getHeaderText();
			if(OrgHeader.contains(ORGNAME))
			{
				System.out.println("=== PASS =====");
				System.out.println(OrgHeader);
			}
			else
			{
				System.out.println("===== Fail =====");
			}			
	
}
	
	/*
   @Test
	public void demotest()
	{
		Assert.fail();
		System.out.println("Demo is Passed");		
	}
		*/
}
