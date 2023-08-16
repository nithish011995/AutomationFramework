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

public class CreateOrgWithIndustryUsingDDT {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		Random r = new Random();
		int random = r.nextInt(1000);
		//Step1:read all the necessary data
		//Read data from the property file-Common Data
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
	
		
		//Read data from ExcelSheet-Test Data
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Organization");
		String OrgName = sh.getRow(4).getCell(2).getStringCellValue()+random;
		String Industry = sh.getRow(4).getCell(3).getStringCellValue();
		
		//launch the browser - driver is acting based runtime data - RunTime polymorphism
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step2:load the url
		driver.get(URL);
		
		//step3:login to the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step4:click on organizations link
		driver.findElement(By.partialLinkText("Organizations")).click();
		
		//Step5:click on create organization look up image
		driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
		
		//step6:create organization
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		//step 7: choose chemicals in industry drop down
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		Select sel = new Select(industryDropDown);
		sel.selectByValue(Industry);
		//driver.findElement(By.name("industry")).click();
		//driver.findElement(By.xpath("//option[@value='Chemicals']")).click();
		
		//step8: save
		driver.findElement(By.name("button")).click();
		
		//step9: validate
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
	//step10: logout application
		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(AdminImg).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("LogOut Sucessful");
	
		
	
	}

}
