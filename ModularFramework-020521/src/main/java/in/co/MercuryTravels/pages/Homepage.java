package in.co.MercuryTravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonLibs.utils.WaitUtils;

public class Homepage extends BasePage {
	
	@FindBy(linkText = "International Holidays")
	private WebElement internationalHolidayLink;
	
	@FindBy(linkText = "Indian Holidays")
	private WebElement indianHolidayLink;
	
	@FindBy(linkText = "Luxury Rails")
	private WebElement luxuryRailsLink;
	
	@FindBy(linkText = "Luxury Holidays")
	private WebElement luxuryHolidayLink;
	
	@FindBy(linkText = "Customer Login")
	private WebElement customerLogin;
	
	@FindBy(linkText = "User Login")
	private WebElement userLogin;
	
	@FindBy(linkText = "Register")
	private WebElement register;
	
	@FindBy(id = "sign_user_email")
	private WebElement emailAddress;
	
	@FindBy(id = "sign_user_password")
	private WebElement userPassword;
	
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement login;
	
	@FindBy(partialLinkText = "Welcome")
	private WebElement welcomeText;
	
	//Perform hover on customer login -> user login click -> fill details -> login
	
	public Homepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void userLogin(String username, String password) throws Exception {
		
		mouseControl.moveToElement(customerLogin);
		mouseControl.moveToElementAndClick(userLogin);
		WaitUtils.waitForSeconds(3);
		commonElement.setText(emailAddress, username);
		WaitUtils.waitForSeconds(3);
		commonElement.setText(userPassword, password);
		commonElement.ClickElement(login);
		WaitUtils.waitForSeconds(10);
	}
	
	public String getWelcomeText() throws Exception{
		return commonElement.getText(welcomeText);
	}

}
