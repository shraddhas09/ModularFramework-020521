package commonLibs.implementation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IScreenshot;

public class ScreenshotControl implements IScreenshot {
	
	private TakesScreenshot camera;
	
	public ScreenshotControl(WebDriver driver) {
		camera = (TakesScreenshot) driver;
	}

	@Override
	public void captureAndSaveScreenShot(String pathFile) throws Exception {
		pathFile =pathFile.trim();
		File imgFile, tmpFile;
		imgFile = new File(pathFile);
		if(imgFile.exists()) {
			throw new Exception("Image with this file name already exists");
		}
		tmpFile = camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpFile, imgFile);	//Add apache common.io from mvnrepository to pom file to get FileUtils
	}

}
