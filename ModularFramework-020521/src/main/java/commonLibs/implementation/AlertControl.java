package commonLibs.implementation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IAlert;
import commonLibs.utils.WaitUtils;

public class AlertControl implements IAlert {
	
	private WebDriver driver; //'this' used below is for this statement
	
	public AlertControl(WebDriver driver) {
		this.driver = driver;
	}
	
	private Alert getAlert() {
		return driver.switchTo().alert();
	}

	@Override
	public void acceptAlert() throws Exception {
		getAlert().accept();
	}

	@Override
	public void rejectAlert() throws Exception {
		getAlert().dismiss();
		
	}

	@Override
	public String getMessageFromAlert() throws Exception {
		
		return getAlert().getText();
	}

	@Override
	public boolean checkAlertPresent(int timeoutInSeconds) throws Exception {
		try {
			WaitUtils.waitTillAlertIsPresent(driver, timeoutInSeconds); //Code for WaitUtils is written in utils -> WaitUtils
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

}
