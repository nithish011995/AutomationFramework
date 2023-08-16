package vtiger.OrganizationsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
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
@Listeners(vtiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateOrganizationWithIndustryTest extends BaseClass {
	
	@Test(groups = "RegressionSuite")
public void createOrgWithIndustryTest () throws Throwable{
		
		//Read data from ExcelSheet-Test Data
	String OrgName = eUtil.getDataFromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.getDataFromExcel("Organization", 4, 3);

	//
		
		//step5:click on organizations link
		//driver.findElement(By.partialLinkText("Organizations")).click();
		HomePage hp=new HomePage(driver);
				hp.ClickOnOrgLink();
		
		//Step6:click on create organization look up image
		//driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
		OrganizationsPage op=new OrganizationsPage(driver);
		op.ClickOnCreateOrgLookUpImg();
		
		//step7:create organization
		//driver.findElement(By.name("accountname")).sendKeys(OrgName);
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrganization(OrgName, INDUSTRY);
		
		
		//step 8: choose chemicals in industry drop down
	/*	WebElement industryDropDown = driver.findElement(By.name("industry"));
		wUtil.handleDropDown(industryDropDown, INDUSTRY);*/
		//driver.findElement(By.name("industry")).click();
		//driver.findElement(By.xpath("//option[@value='Chemicals']")).click();
				
		//step9: save
		//driver.findElement(By.name("button")).click();
		
		//step10: validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		 String OrgHeader = oip.getHeaderText();
		 Assert.assertTrue(OrgHeader.contains(OrgName));	
			System.out.println(OrgName);
		}
	@Test
	public void demotest12()
	{
		//Assert.fail();
		System.out.println("demo");
	}

}
