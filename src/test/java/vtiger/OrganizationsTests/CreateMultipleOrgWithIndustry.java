package vtiger.OrganizationsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtilty;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateMultipleOrgWithIndustry extends BaseClass {
	
	
	
	@Test(dataProvider = "getData")
	public void createMultipleOrg(String Org,String INDUSTRY) throws Throwable 
	{
		//Read data from ExcelSheet-Test Data
		String OrgName = Org +jUtil.getRandomNumber();
		
			//step5:click on organizations link
			HomePage hp=new HomePage(driver);
					hp.ClickOnOrgLink();
			
			//Step6:click on create organization look up image
			OrganizationsPage op=new OrganizationsPage(driver);
			op.ClickOnCreateOrgLookUpImg();
			
			//step7:create organization
			CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
			cnop.createOrganization(OrgName, INDUSTRY);
			
			//step8: validate
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			 String OrgHeader = oip.getHeaderText();
			 Assert.assertTrue(OrgHeader.contains(OrgName));	
				System.out.println(OrgName);
			}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eUtil.readMultipleData("MultipleOrg");
		
	}
}
