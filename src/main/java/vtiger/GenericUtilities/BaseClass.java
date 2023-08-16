package vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 *  This class consists of all the basic configuration annotations for
 *  all the common actions
 * @author Nithish
 *
 */
public class BaseClass {

	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public JavaUtilty jUtil=new JavaUtilty();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public	WebDriverUtility wUtil=new WebDriverUtility();
	
	//only used for listener to take screenshot
	public static WebDriver sdriver;
	
	public WebDriver driver=null;
	
	
	
	//after parallel execution we should make again change ie. use beforesuit and aftersuite
	//@BeforeSuite(groups = {"SmokeSuite" , "RegressionSuite"})
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("===DB connection successful===");
	}
	
	//@Parameters("browser")//hold a value
	//only for cross browser execution for others we should remove this
	
	//@BeforeTest  //only for parallel execution 
	@BeforeClass(alwaysRun = true)
	
	//public void bcConfig(String BROWSER) throws Throwable//only for cross browser execution
	//For others we use below method
	
	public void bcConfig() throws Throwable
	{
		//read browser name and URL from property file
		
		//only for cross browser execution we incommand property file
		String BROWSER = pUtil.getDataFromPrpertyFile("browser");
		String URL = pUtil.getDataFromPrpertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER +"=== Browser launched ===");
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER +"=== Browser launched ===");
		}
		else if(BROWSER.equalsIgnoreCase("Microsoft Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER +"=== Browser launched ===");
		}
		else
		{
			System.out.println("=== invalid browser name ===");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoad(driver);
		
		//only used for listener to take screenshot
		sdriver=driver;
		
		//Load the url
		driver.get(URL);
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable
	{
		//read username and password from the property file
		String USERNAME = pUtil.getDataFromPrpertyFile("username");
		String PASSWORD = pUtil.getDataFromPrpertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginApp(USERNAME, PASSWORD);
		
		System.out.println("=== Login successful ===");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.logoutofApp(driver);
		System.out.println("=== Logout successful ===");
	}
	
	//@AfterTest //only for parallel 
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("===Browser closed===");
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("=== DB connection closed ===");
	}
}

