package vtiger_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.partialLinkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//select[@name='salutationtype']")).click();
		driver.findElement(By.xpath("//option[@value='Mr.']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("2Nithish");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kabaddi");
		driver.findElement(By.id("jscal_trigger_support_end_date")).click();
		driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("1995-02-01");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement AdmImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));		
		Actions n = new Actions(driver);
		n.moveToElement(AdmImg).perform();
		
	}

}
