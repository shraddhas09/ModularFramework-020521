package designPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibs.implementation.CommonElement;
import commonLibs.implementation.DropdownControl;

public class AmazonHomepage {
	
	private WebElement searcbBox; //Defining all web elements
	private WebElement searchCategory;
	private WebElement searchButton;
	
	private CommonElement elementControl; //Defining all classes to be used from implementation
	private DropdownControl dropdownControl;
	
	public AmazonHomepage(WebDriver driver) { //Initializing web elements
		searcbBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchCategory = driver.findElement(By.id("searchDropdownBox"));
		searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		
		elementControl = new CommonElement();
		dropdownControl = new DropdownControl();
	}
	
	public void searchProduct(String product, String category) throws Exception { //writing logic 
		elementControl.setText(searcbBox, product);
		dropdownControl.selectViaVisibleText(searchCategory, category);
		elementControl.ClickElement(searchButton);
	}

}
