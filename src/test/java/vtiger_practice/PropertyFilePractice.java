package vtiger_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyFilePractice {
public static void main(String[] args) throws Throwable {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	//Step1:Load the document in java readable format
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	//2:create object of properties class from the Java.util
	Properties pro = new Properties();
	
	//3:load the file into properties class
	pro.load(fis);
	
	//4:provide the key and get the value
	String URL = pro.getProperty("url");
	System.out.println(URL);
	
	driver.get(URL);
	
}
}
