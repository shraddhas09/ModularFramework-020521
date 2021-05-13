package designPatterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementation.CommonElement;
import commonLibs.implementation.DropdownControl;

public class AmazonHomepagePageFactory {
	
	@CacheLookup
	@FindBy(id="twotabsearchtextbox")
	private WebElement searcbBox; //Defining all web elements
	
	@CacheLookup
	@FindBy(id="searchDropdownBox")
	private WebElement searchCategory;
	
	@CacheLookup
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	private WebElement searchButton;
	
	@FindBy(xpath="//span[contains(text(),'results')]")
	private WebElement searchResult;
	
	private CommonElement elementControl; //Defining all classes to be used from implementation
	private DropdownControl dropdownControl;
	
	public AmazonHomepagePageFactory(WebDriver driver) { //Initializing web elements
		
		PageFactory.initElements(driver, this);
		elementControl = new CommonElement();
		dropdownControl = new DropdownControl();
	}
	
	public void searchProduct(String product, String category) throws Exception { //writing logic 
		elementControl.setText(searcbBox, product);
		dropdownControl.selectViaVisibleText(searchCategory, category);
		elementControl.ClickElement(searchButton);
		
		System.out.println(elementControl.getText(searchResult));
	}

}
