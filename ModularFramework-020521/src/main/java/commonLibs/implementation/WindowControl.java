package commonLibs.implementation;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IWindowHandle;

public class WindowControl implements IWindowHandle{
	
	private WebDriver driver;
	
	public WindowControl(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void switchToAnyWindow(String windowhandle) throws Exception {
		driver.switchTo().window(windowhandle);
		
	}

	@Override
	public void switchToAnyWindow(int childWindowIndex) throws Exception {
		String childWindowHandle = driver.getWindowHandles().toArray()[childWindowIndex].toString();
		//Above line - gets array of child window handles - child window index need to give 0,1,2 which window you want to go to
		//which is converted to string and the passed to childwindowhandle
		driver.switchTo().window(childWindowHandle);
		
	}

	@Override
	public String getWindowHandle() throws Exception {
		return driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() throws Exception {
		return driver.getWindowHandles();
	}

}
