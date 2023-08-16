package vtiger_practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtilty;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateOrgWithIndustryUsingDDT_GU {
	public static void main(String[] args) throws Throwable {
		
		//Create object of required Utilities
		JavaUtilty jUtil=new JavaUtilty();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		WebDriver driver=null;
		
		//Step1:read all the necessary data
		//Read data from the property file-Common Data
		String BROWSER = pUtil.getDataFromPrpertyFile("browser");
		String URL = pUtil.getDataFromPrpertyFile("url");
		String USERNAME = pUtil.getDataFromPrpertyFile("username");
		String PASSWORD = pUtil.getDataFromPrpertyFile("password");
		
		//Read data from ExcelSheet-Test Data
	String OrgName = eUtil.getDataFromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.getDataFromExcel("Organization", 4, 3);

	//Step2: launch the browser - driver is acting based runtime data - RunTime polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER +"......Browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER +"......Browser launched");
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoad(driver);
		
		//step3:load the url
		driver.get(URL);
		
		//step4:login to the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step5:click on organizations link
		driver.findElement(By.partialLinkText("Organizations")).click();
		
		//Step6:click on create organization look up image
		driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
		
		//step7:create organization
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		//step 8: choose chemicals in industry drop down
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		wUtil.handleDropDown(industryDropDown, INDUSTRY);
		//driver.findElement(By.name("industry")).click();
		//driver.findElement(By.xpath("//option[@value='Chemicals']")).click();
		
		//step9: save
		driver.findElement(By.name("button")).click();
		
		//step10: validate
		 String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(OrgName))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("Fail");
		}
	//step11: logout application
		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, AdminImg);
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("LogOut Sucessful");
	
		
	
	}
}
