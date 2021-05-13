package in.co.MercuryTravels.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.AlertControl;
import commonLibs.implementation.CommonElement;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.FrameControl;
import commonLibs.implementation.MouseControl;

public class BasePage {
	
	protected AlertControl alertcontrol;
	protected CommonElement commonElement;
	protected DropdownControl dropdownControl;
	protected FrameControl frameControl;
	protected MouseControl mouseControl;

	public BasePage(WebDriver driver) {
		alertcontrol = new AlertControl(driver);
		commonElement = new CommonElement();
		dropdownControl = new DropdownControl();
		frameControl = new FrameControl(driver);
		mouseControl = new MouseControl(driver);
	}

}
