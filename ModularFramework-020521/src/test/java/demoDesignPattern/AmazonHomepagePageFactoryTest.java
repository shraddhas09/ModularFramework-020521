package demoDesignPattern;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commonLibs.implementation.CommonDriver;
import designPatterns.AmazonHomepagePageFactory;

public class AmazonHomepagePageFactoryTest {
	
	CommonDriver cmnDriver;
	String url = "https://www.amazon.in/";
	AmazonHomepagePageFactory homepage;
	WebDriver driver;
	
	@BeforeClass
	public void invokeBrowser() throws Exception {
		
		cmnDriver = new CommonDriver("chrome");
		
		cmnDriver.setPageloadTimeout(60);
		cmnDriver.setElementDetetectionTimeout(10);
		cmnDriver.navigateToFirstUrl(url);
		driver = cmnDriver.getDriver();
		homepage = new AmazonHomepagePageFactory(driver);
	}
	
	@Test
	public void searchProduct() throws Exception{
		String product = "iPhone";
		String category = "Electronics";
		homepage.searchProduct(product, category);
	}
	
	@AfterClass
	public void closeBrowser() throws Exception{
		
		cmnDriver.closeAllBrowsers();
		
	}

}
