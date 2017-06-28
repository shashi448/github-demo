package List;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import core.BaseClass;
import screenshot.ScreenShots;

public class MulTests extends BaseClass {
	@Test(enabled = false, priority = 1)
	public void switchWindow() throws Exception {
		super.initDriver();
		WebElement firstName = driver.findElement(By.id("FirstName"));
		firstName.sendKeys("Jhonny");
		String parent_window = driver.getWindowHandle();
		System.out.println(parent_window);
		WebElement learnMore = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div/div[1]/p/a"));
		learnMore.click();
		Set<String> allWindows = driver.getWindowHandles();
		for (String child_window : allWindows) {
			System.out.println(child_window);
			if (!parent_window.equalsIgnoreCase(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.getTitle());
				Thread.sleep(3000);
				driver.close();
			}
		}
		driver.switchTo().window(parent_window);
		System.out.println(driver.getTitle());
	}

	@Test(enabled = false, priority = 0)
	public void verifyListItems() throws Exception {
		super.initDriver();
		int[] elements = { 1, 2, 3, 4, 5, 6 };
		driver.navigate().to("https://www.expedia.com/");
		WebElement flight = driver.findElement(By.id("tab-flight-tab-hp"));
		flight.click();
		WebElement noOfPax = driver.findElement(By.id("flight-adults-hp-flight"));
		List<WebElement> lst = noOfPax.findElements(By.tagName("option"));
		for (WebElement a1 : lst) {
			boolean s1 = false;
			System.out.println(a1.getText());
			for (int i = 0; i < elements.length; i++) {
				if (!a1.getText().equals(elements[i])) {
					s1 = true;
				}
			}
			Assert.assertTrue(s1);
			Assert.assertTrue(s1, a1.getText());
		}
	}

	@Test(enabled = true)
	public void jScript() throws Exception {
		super.initDriver();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('FirstName').value='Jhonny'");
		Thread.sleep(5000);
		js.executeAsyncScript("window.scrollBy(0,200)", " ");
	}

	@Test(priority = 2, enabled = false)
	public void checkBox() throws Exception {
		super.initDriver();
		driver.navigate().to("http://jqueryui.com/checkboxradio/");
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content']/iframe")));
		List<WebElement> checkBoxes = driver.findElements(By.xpath("html/body/div[1]/fieldset[2]/label/span[1]"));
		for (int i = 0; i < checkBoxes.size(); i++) {
			WebElement chkBox = checkBoxes.get(i);
			if (!chkBox.isSelected()) {
				chkBox.click();
			}
		}
	}

	@Test(enabled = false)
	public void actionClass() throws Exception {
		super.initDriver();
	}

	@Test(enabled = false)
	public void selectClass() throws Exception {
		super.initDriver();
	}

	@Test(enabled = false)
	public void dateClass() throws Exception {
		super.initDriver();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenShots.takeScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
