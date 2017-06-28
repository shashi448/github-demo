package javascript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import core.BaseClass;
import screenshot.ScreenShots;

public class JavaScrptTest extends BaseClass {

	@Test
	public void jScript() throws Exception {
		super.initDriver();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('FirstName').value='jhonny'");
		js.executeScript("window.scrollBy(0,300)", " ");
		Thread.sleep(8000);
		driver.navigate().to("file:///C:/Users/shashi/Desktop/Selenium/doc.html");
		driver.findElement(By.xpath("//*[@id='1']")).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\shashi\\Desktop\\Selenium\\autoit.exe");

		//driver.quit();
	}

}
