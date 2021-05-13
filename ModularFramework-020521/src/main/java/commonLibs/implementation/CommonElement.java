package commonLibs.implementation;

import org.openqa.selenium.WebElement;

import commonLibs.contracts.ICommonElement;

public class CommonElement implements ICommonElement{

	@Override
	public String getText(WebElement element) throws Exception {
		String getText = element.getText();
		return getText;
	}

	@Override
	public void ClickElement(WebElement element) throws Exception {
		element.click();
		
	}

	@Override
	public String getAttribute(WebElement element, String attribute) throws Exception {
		String getAttribute = element.getAttribute(attribute);
		return getAttribute;
	}

	@Override
	public String getCssValue(WebElement element, String cssproperyname) throws Exception {
		String getCssValue = element.getCssValue(cssproperyname);
		return getCssValue;
	}

	@Override
	public boolean isElementEnabled(WebElement element) throws Exception {
		boolean isElementEnabled = element.isEnabled();
		return isElementEnabled;
	}

	@Override
	public boolean isElementVisible(WebElement element) throws Exception {
		boolean isElementVisible = element.isDisplayed();
		return isElementVisible;
	}

	@Override
	public boolean isElementSelected(WebElement element) throws Exception {
		boolean isElementSelected = element.isSelected();
		return isElementSelected;
	}

	@Override
	public void setText(WebElement element, String textToWrite) throws Exception {
		element.sendKeys(textToWrite);
		
	}

	@Override
	public void clearText(WebElement element) throws Exception {
		element.clear();
		
	}

	@Override
	public void changeCheckboxStatus(WebElement element, boolean expectedStatus) throws Exception {
		boolean currentstatus = element.isSelected();
		if(currentstatus!=expectedStatus) {
			element.click();
		}
		
	}

	@Override
	public int getXLocation(WebElement element) throws Exception {
		int getXLocation = element.getLocation().x;
		return getXLocation;
	}

	@Override
	public int getYLocation(WebElement element) throws Exception {
		int getYLocation = element.getLocation().y;
		return getYLocation;
	}

}
