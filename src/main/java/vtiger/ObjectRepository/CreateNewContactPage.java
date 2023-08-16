package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	//declaration
		@FindBy(name="lastname")
		private WebElement LastNameEdt;
		
		@FindBy(xpath ="//input[@title='Save [Alt+S]']")
		private WebElement SaveBtn;
		
		@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
		private WebElement OrgLookUpImg;
		
		@FindBy(name = "search_text")
		private WebElement OrgSearchEdt;
		
		@FindBy(name = "search")
		private WebElement OrgSearchBtn;
		
		//initialization
		public CreateNewContactPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getLastNameEdt() {
			return LastNameEdt;
		}

		public WebElement getSaveBtn() {
			return SaveBtn;
		}

		public WebElement getOrgLookUpImg() {
			return OrgLookUpImg;
		}

		public WebElement getOrgSearchEdt() {
			return OrgSearchEdt;
		}

		public WebElement getOrgSearchBtn() {
			return OrgSearchBtn;
		}
		
		//Buisness Library
		/**
		 * this method will create with mandatory information
		 * @param LASTNAME
		 */
		public void createContact(String LASTNAME)
		{
			LastNameEdt.sendKeys(LASTNAME);
			SaveBtn.click();
		}
		
		/**
		 * this method will create contact with relevent organization
		 * @param driver
		 * @param LASTNAME
		 * @param OrgName
		 */
		public void createContact(WebDriver driver,String LASTNAME,String OrgName)//what ever is not there just paramaterised
		{
			LastNameEdt.sendKeys(LASTNAME);
			OrgLookUpImg.click();
			switchToWindow(driver,"Accounts");
			OrgSearchEdt.sendKeys(OrgName);
			OrgSearchBtn.click();
			driver.findElement(By.xpath("//a[.='"+OrgName+"']")).click();
			switchToWindow(driver, "Contacts");
			SaveBtn.click();
		}
		
}
