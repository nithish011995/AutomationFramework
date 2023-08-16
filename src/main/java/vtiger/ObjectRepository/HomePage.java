package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	//declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLink;
	

	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	

	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLink;
	

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminstratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getAdminstratorImg() {
		return AdminstratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//Buisness Library
	/**
	 * This method will click on organization link
	 */
	public void ClickOnOrgLink()
	{
		OrganizationsLink.click();
	}

	/**
	 * This method will click on contacts link
	 */
	public void ClickOnContactsLink()
	{
		ContactsLink.click();
	}

	public void logoutofApp(WebDriver driver) throws InterruptedException
/*need mouseoveraction ,dont need create action clss because alredy create in webdriverUtilty
*for writting buisness library if need any element or any generic method from webdriverutilty
*wejust extends webdriverutility 
	 */
	{
		mouseHoverAction(driver, AdminstratorImg);
		Thread.sleep(1000);
// no need to use any external waits here because its not in the script,its a seperate method
	SignOutLnk.click();
	}
}
