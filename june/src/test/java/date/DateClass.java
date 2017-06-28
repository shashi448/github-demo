package date;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import core.BaseClass;
import screenshot.ScreenShots;
import testdata.Expedia;

public class DateClass extends BaseClass {
	@Test
	public void dateTest() throws Exception {
		super.initDriver();
		driver.navigate().to("https://www.expedia.com/");
		Expedia.clickFlights(driver);
		Expedia.clickRoundTrip(driver);
		Expedia.clickFlyFrom(driver, "Dallas");
		Expedia.clickFlyTo(driver, "Atlanta");
		Expedia.clickDepartDate(driver);
		Expedia.enterDepartDate(driver, "Sep 2017", "9");
		Thread.sleep(2000);
		Expedia.clickArrivalDate(driver);
		Expedia.enterArrivalDate(driver, "Sep 2017", "27");
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,300)"," ");
		Expedia.searchButton(driver);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenShots.takeScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
