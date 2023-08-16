package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath ="//img[@alt='Create Contact...']")
	private WebElement CreateContactLookUpImg;
	
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgLookUpImg() {
		return CreateContactLookUpImg;
	}
	
	//buisness lib
	/**
	 * This method willclick on create llok up image
	 */
	public void clickOnCreateContactLookUpImage()
	{
		CreateContactLookUpImg.click();
	}
	
}
