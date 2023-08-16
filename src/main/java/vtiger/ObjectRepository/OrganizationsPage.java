package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	@FindBy(xpath ="//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	
	//initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utiliztion
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}

	public void ClickOnCreateOrgLookUpImg()
	{
		CreateOrgLookUpImg.click();
	}

	public void setCreateOrgLookUpImg(WebElement createOrgLookUpImg) {
		CreateOrgLookUpImg = createOrgLookUpImg;
	}
}
