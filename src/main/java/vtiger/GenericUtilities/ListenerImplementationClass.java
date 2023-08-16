package vtiger.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class provides implementtion to ITestListeners interface of TestNG
 * @author Nithish
 *Example for abstraction
 */
public class ListenerImplementationClass implements ITestListener 
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("---Execution started---"+methodName);
	test=report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//System.out.println("---PASS---"+methodName);
	test.log(Status.PASS, "---PASS---"+methodName);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//System.out.println("---FAIL---"+methodName);
		test.log(Status.FAIL, "---FAIL---"+methodName);
		//System.out.println(result.getThrowable());
		test.log(Status.INFO, result.getThrowable());
		
		WebDriverUtility wu=new WebDriverUtility();
		JavaUtilty ju=new JavaUtilty();
		
		String screenshotName = methodName+ju.getSystemDateFormat();
		
		//take screen shot for failure test script - to attach with bug rising
		try {
			String path = wu.takeScreenShot(BaseClass.sdriver, screenshotName);
		test.addScreenCaptureFromPath(path);
		
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//System.out.println("---SKIP---"+methodName);
		test.log(Status.SKIP, "---SKIP---"+methodName);
		//System.out.println(result.getThrowable());
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		//Start of<suite> -@BeforeSuite
		System.out.println("---suite execution started---");
	
		//configure the extent Report
	ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtilty().getSystemDateFormat()+".html");
	htmlreport.config().setDocumentTitle("Vtiger Execution Report");
	htmlreport.config().setReportName("Build 3 Vtiger Execution Report");
	htmlreport.config().setTheme(Theme.DARK);
	
	//Report Generation
	 report=new ExtentReports();
	 report.attachReporter(htmlreport);
	report.setSystemInfo("Base Browser", "chrome");
	report.setSystemInfo("Base PlatForm", "Testing-Env");
	report.setSystemInfo("Base URL", "http://localhost:8888");
	report.setSystemInfo("Base OS", "Windows");
	report.setSystemInfo("Reporter", "Nithish");
	
	}

	public void onFinish(ITestContext context) {
		// End of<suite> -@AfterSuite
		System.out.println("---suite execution ended---");
	//Report Generation
		report.flush();
	
	}

}
