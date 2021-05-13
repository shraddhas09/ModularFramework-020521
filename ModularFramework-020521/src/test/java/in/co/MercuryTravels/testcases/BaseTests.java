package in.co.MercuryTravels.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;
import commonLibs.utils.ConfigFileUtils;
import commonLibs.utils.DateUtils;
import in.co.MercuryTravels.pages.Homepage;

public class BaseTests {
	
	CommonDriver cmnDriver;
	// String browserType = "chrome";
	String browserType;
	
	//String url = "https://www.mercurytravels.co.in/";
	String baseUrl;
	Homepage homePage;
	private WebDriver driver;
	static String configFileName;
	static Properties configProperties;
	static String currentWorkingDirectory;
	static String executionStartDate;
	
	int pageloadTimeout;
	int elementDetectionTimeout;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest extentTest;
	
	String reportFilename;
	
	String screenshotFilename;
	ScreenshotControl screenshotControl;
	
	static {
		try {
		//configFileName = System.getProperty("user.dir") + "config/config.properties"; //giving config.properties path
		//OR if you dont give current working directory
		currentWorkingDirectory = System.getProperty("user.dir");
		executionStartDate = DateUtils.getCurrentDateAndTime();
		//configFileName = currentWorkingDirectory + "config/config.properties"; //can also be written as below
		configFileName = String.format("%s/config/config.properties", currentWorkingDirectory); //%s will be replaced by currentworkingdirectory
		configProperties = ConfigFileUtils.readProperties(configFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeSuite //Steps to create an html report
	public void preSetup() {
		reportFilename = String.format("%s/reports/MercuryTravelTestReport-%s.html",currentWorkingDirectory,executionStartDate);
		htmlReporter = new ExtentHtmlReporter(reportFilename);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	
	@BeforeClass
	public void invokeBrowser() throws Exception {
		
		extentTest = extent.createTest("Setup - Setup the pre-requisite to run automated test cases"); //create tc
		
		browserType = configProperties.getProperty("browserType");
		
		extentTest.log(Status.INFO, "Browser type is " + browserType); //create log
		
		cmnDriver = new CommonDriver(browserType);
		
		pageloadTimeout = Integer.parseInt(configProperties.getProperty("pageloadTimeout")); //Converts string to int
		
		extentTest.log(Status.INFO, "Page load timeout is " + pageloadTimeout); //create log
		
		elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));
		
		extentTest.log(Status.INFO, "Element detection timeout or implicit wait is " + elementDetectionTimeout); //create log
		
		cmnDriver.setPageloadTimeout(pageloadTimeout);
		cmnDriver.setElementDetetectionTimeout(elementDetectionTimeout);
		
		baseUrl = configProperties.getProperty("baseUrl");
		extentTest.log(Status.INFO, "URL is " + baseUrl); //create log
		
		cmnDriver.navigateToFirstUrl(baseUrl);
		driver = cmnDriver.getDriver();
		extentTest.log(Status.INFO, "Initializing all pages"); //create log
		homePage = new Homepage(driver);
		
		screenshotControl = new ScreenshotControl(driver);
	
	}
	
	@AfterClass 
	public void closeBrowser() throws Exception {
	 cmnDriver.closeAllBrowsers();
	 
	 extentTest = extent.createTest("Cleanup - Clean process");
	 extentTest.log(Status.INFO, "Closing all browsers"); //create log
	 }
	
	@AfterSuite
	public void afterCleanUp() {
		extent.flush(); //to flush content to report
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		String testcaseName = result.getName();
		String screenshotFilename = String.format("%s/screenshots/-%s-%s.jpeg",currentWorkingDirectory,testcaseName,executionStartDate );
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test case pass - " +testcaseName);
		} else if(result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "Test case fail - " +testcaseName);
			
			screenshotControl.captureAndSaveScreenShot(screenshotFilename); //taking screenshot
			extentTest.addScreenCaptureFromPath(screenshotFilename); //attaching to report
			
			
		} else {
			extentTest.log(Status.SKIP, "Test case skipped - " +testcaseName);
		}
	}
	 
}
