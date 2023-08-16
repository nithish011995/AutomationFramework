package vtiger.ContactsTest;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility; 
import vtiger.GenericUtilities.JavaUtilty;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

//it is a inetegration scenario

@Listeners(vtiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateContactWithOrganizationTests  extends BaseClass{
//Create Organization
	
	@Test(groups="SmokeSuite")
	//@Test
	public void createContactWithOrg() throws Throwable
	{	
		//Read data from ExcelSheet-Test Data
		String OrgName = eUtil.getDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.getDataFromExcel("Contacts", 4, 2);
	
		//step5:click on organizations link
		//driver.findElement(By.partialLinkText("Organizations")).click();
		HomePage hp=new HomePage(driver);
		hp.ClickOnOrgLink();
		Reporter.log("Org link clicked");
		
		//Step6:click on create organization look up image
		//driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
		OrganizationsPage op=new OrganizationsPage(driver);
		op.ClickOnCreateOrgLookUpImg();
		Reporter.log("create org look up image is clicked");
		
		//step7:create organization
		//driver.findElement(By.name("accountname")).sendKeys(OrgName);
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrganization(OrgName);
		Reporter.log("Organization created");
		
		//step8: save
		//driver.findElement(By.name("button")).click();
		
		//step9: validate for organization
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader =  oip.getHeaderText();
		Assert.assertTrue(OrgHeader.contains(OrgName));
		
		/*Create contact using organization*/
		
		//Step10:click on contacts link
		//driver.findElement(By.linkText("Contacts")).click();
		hp.ClickOnContactsLink();
		Reporter.log("Contacts link clicked");
		
		//Step11:Navigate to create contact look up image
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImage();
		Reporter.log("create contact look up image is clicked");
		
		//Step12:Create a contact with mandatory information
		//driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createContact(driver, LASTNAME, OrgName);
		Reporter.log("Contact is created");
		
		//driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		
	/*	//Step13:Switch to child window
		wUtil.switchToWindow(driver, "Accounts");
		
		//step14:search for Organization
		driver.findElement(By.name("search_text")).sendKeys(OrgName);
		
		driver.findElement(By.name("search")).click();
		
		//dynamic x path ..that means x path contains run time data
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
			
		//write a x path for 1st existing element (take reference static element)after that remove 
				//that static data and upend ur data
		
		//Step15: switch the control back to parent window
		wUtil.switchToWindow(driver, "Contacts");
		

		//step16: save
		driver.findElement(By.name("button")).click();*/
		
		//step17: validate for organization
		ContactInfoPage cip=new ContactInfoPage(driver);
		String ContactHeader=cip.getContactHeader();
		// String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		Assert.assertTrue(ContactHeader.contains(LASTNAME));	
		System.out.println(ContactHeader);
	}
	@Test
	public void demotest()
	{
		//Assert.fail();
		System.out.println("demo");
	}
}
