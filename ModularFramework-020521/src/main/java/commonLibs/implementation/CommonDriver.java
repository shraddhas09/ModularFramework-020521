package commonLibs.implementation;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import commonLibs.contracts.IDriver;

public class CommonDriver implements IDriver{
	
	private WebDriver driver;
	private int pageloadTimeout;
	private int elementDetetectionTimeout;
	
	private String currentWorkingDirectory;
	
	public CommonDriver(String browserType) throws Exception {   //Constructor to invoke browser
		
		pageloadTimeout = 60;
		elementDetetectionTimeout = 10;
		
		currentWorkingDirectory = System.getProperty("user.dir"); //Current directory path - ModularFramework-020521
		
		if(browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", currentWorkingDirectory + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", currentWorkingDirectory + "/drivers/msedgedriver.exe");
			driver = new EdgeDriver();	
		} else {
			throw new Exception("Invalid browser type");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setPageloadTimeout(int pageloadTimeout) {
		this.pageloadTimeout = pageloadTimeout;
	}

	public void setElementDetetectionTimeout(int elementDetetectionTimeout) {
		this.elementDetetectionTimeout = elementDetetectionTimeout;
	}


	@Override
	public void navigateToFirstUrl(String url) throws Exception {
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadTimeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetetectionTimeout));
		
		url = url.trim(); //Best-practice. Removes any white spaces given by user while entering parameter
		driver.get(url);
		
	}

	@Override
	public String getTitle() throws Exception {
		String title = driver.getTitle();
		return title;
	}

	@Override
	public String getCurrentUrl() throws Exception {
		String currenturl = driver.getCurrentUrl();
		return currenturl;
	}

	@Override
	public String getPageSource() throws Exception {
		String pagesource = driver.getPageSource();
		return pagesource;
	}

	@Override
	public void navigateToUrl(String url) throws Exception {
		url = url.trim();
		driver.navigate().to(url); //Navigate to url except for the first time
		
	}

	@Override
	public void navigateForward() throws Exception {
		driver.navigate().forward();
	}

	@Override
	public void navigateBackward() throws Exception {
		driver.navigate().back();
		
	}

	@Override
	public void refresh() throws Exception {
		driver.navigate().refresh();
		
	}

	@Override
	public void closeBrowser() throws Exception {
		if(driver!=null) {
		driver.close();
		}
		
	}

	@Override
	public void closeAllBrowsers() throws Exception {
		if(driver!=null) {
		driver.quit();
		}
	}

}
