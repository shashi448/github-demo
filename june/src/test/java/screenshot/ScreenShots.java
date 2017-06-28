package screenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {

	public static void takeScreenshot(WebDriver driver, String fileName) throws Exception {
		fileName = fileName + " .png ";
		String filePath = "C:\\Users\\shashi\\Desktop\\fulltime\\screenshots\\";
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(filePath + fileName));
	}

}
