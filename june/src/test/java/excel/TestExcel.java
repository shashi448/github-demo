package excel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.BaseClass;
import screenshot.ScreenShots;

public class TestExcel extends BaseClass {

	@Test(dataProvider = "loginData")
	public void multiLogin(String username, String password) throws Exception {
		super.initDriver();
		ExcelReadDataSets.setExcelFile(Constants.File_Path + Constants.FileName, "Sheet1");

		driver.navigate().to("http://www.facebook.com");
		WebElement usrName = driver.findElement(By.id("email"));
		WebElement pwd = driver.findElement(By.id("pass"));
		WebElement login = driver.findElement(By.id("loginbutton"));
		usrName.sendKeys(username);
		pwd.sendKeys(password);
		login.click();
	}

	@DataProvider(name = "loginData")
	public Object[][] dataProvider() {
		Object[][] testData = ExcelReadDataSets.getTestData("Invalid_login");
		return testData;
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenShots.takeScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
