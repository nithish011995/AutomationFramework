package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1:create a seperate pom class for every web page
	
	//Identify the web elements using @FindBy,@FindBys, @FindAll
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;    //Edt means textfield we can edit amd do sendkeys action
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;// Btn =button we do click action
	
	//Rule 3: Create a constructor to initialise the web elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4: Provide getters to access these elements
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Buisness Library - project specific generic method
	/* it should contain the elements in this particular page only
	 there is no option to take it from different pom class
	 */
	/**
	 * This method will perform Login operation
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginApp(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
}
