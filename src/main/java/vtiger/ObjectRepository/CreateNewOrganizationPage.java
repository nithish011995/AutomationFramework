package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	//declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	
	@FindBy(name="button")
	private WebElement SaveBtn;
	
	
	//initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}


	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	/**
	 * This method will create organaization with mandatory fields
	 * @param OrgName
	 */
	public void createOrganization(String OrgName)
	{
		OrgNameEdt.sendKeys(OrgName);
		SaveBtn.click();
	}
	/**
	 *  This method will create organaization with industryDropDown
	 * @param OrgName
	 * @param INDUSTRY
	 */
	public void createOrganization(String OrgName,String INDUSTRY)
	{
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(IndustryDropDown, INDUSTRY);
		SaveBtn.click();
		
	}
}
