package vtiger_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;

public class CreateOrganizationWithIndustry {
	
	public static void main(String[] args) throws Throwable {
		
		//step1: Launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step2:load the url
		driver.get("http://localhost:8888/");
		
		//step3:login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//step4:click on organizations link
		driver.findElement(By.partialLinkText("Organizations")).click();
		
		//Step5:click on create organization look up image
		driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
		
		//step6:create organization
		driver.findElement(By.name("accountname")).sendKeys("GMS21");
		
		//step 7: choose chemicals in industry drop down
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		Select sel = new Select(industryDropDown);
		sel.selectByValue("Chemicals");
		
		//driver.findElement(By.name("industry")).click();
		//driver.findElement(By.xpath("//option[@value='Chemicals']")).click();
		
		//step8: save
		driver.findElement(By.name("button")).click();
		
		//step9: validate
		 String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains("GMS21"))
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
