package vtiger_practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustry_Random{
	public static void main(String[] args) {
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
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		
		Random r = new Random();
		int random = r.nextInt(1000);
	
		
		String orgname = "nishu"+random;
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		WebElement en = driver.findElement(By.name("industry"));
		Select sel = new Select(en);
		sel.selectByValue("Energy");
		
		WebElement cus = driver.findElement(By.name("accounttype"));
		Select sel2 = new Select(cus);
		sel2.selectByValue("Customer");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String org = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(org.contains(orgname))
		{
			System.out.println("pass");
			System.out.println(org);
		}
		WebElement ad = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
	act.moveToElement(ad).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("LogOut Sucessful");
	}

}
