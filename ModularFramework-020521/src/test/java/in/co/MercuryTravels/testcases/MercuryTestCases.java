package in.co.MercuryTravels.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class MercuryTestCases extends BaseTests {
	
	@Test
	public void verifyUserLoginWithCorrectCredentials() throws Exception {
		extentTest = extent.createTest("TC-001-Verify user login with correct credentials");
		String username = configProperties.getProperty("userEmailId");
		extentTest.log(Status.INFO, "User Email ID - " + username);
		String password = configProperties.getProperty("userPassword");
		extentTest.log(Status.INFO, "User password - " + password);
		homePage.userLogin(username, password);
		
		String expectedWelcomeText = configProperties.getProperty("expectedWelcomeText");
		String actualWelcomeText = homePage.getWelcomeText();
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
		extentTest.log(Status.INFO, "User Login Successful");
		
	}

}
