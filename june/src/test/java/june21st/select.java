package june21st;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import core.BaseClass;
import screenshot.ScreenShots;

public class select extends BaseClass {
	@Test(enabled = false)
	public void checkBox() throws Exception {
		super.initDriver();
		driver.navigate().to("http://jqueryui.com/checkboxradio/");
		driver.navigate().refresh();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content']/iframe")));
		boolean threeStar = driver.findElement(By.xpath("html/body/div[1]/fieldset[2]/label[2]/span[1]")).isSelected();
		if (!threeStar) {
			driver.findElement(By.xpath("html/body/div[1]/fieldset[2]/label[2]/span[1]")).click();

		}
		driver.navigate().refresh();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content']/iframe")));
		List<WebElement> checkBox = driver.findElements(By.xpath("html/body/div[1]/fieldset[2]/label/span[1]"));
		Iterator<WebElement> ir = checkBox.iterator();
		while (ir.hasNext()) {
			WebElement ir1 = ir.next();
			if (!ir1.isSelected()) {
				ir1.click();
			}
		}

	}

	@Test(enabled = false)
	public void radioButton() throws Exception {

	}

	@Test(enabled = false)
	public void switchFrame() throws Exception {

	}

	@Test(enabled = false)
	public void actionClass() throws Exception {

	}

	@Test(enabled = false)
	public void vrfyList() throws Exception {
		super.initDriver();
		driver.navigate().to("https://www.facebook.com/");
		WebElement mnth = driver.findElement(By.id("month"));
		List<WebElement> lst = mnth.findElements(By.tagName("option"));
		String[] month = { "Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };
		for (WebElement items : lst) {

			boolean l1 = false;
			System.out.println(items.getText());
			for (int i = 0; i < month.length; i++) {
				if (items.getText().equals(month[i])) {
					l1 = true;
				}

			}
			Assert.assertTrue(l1);
			Assert.assertTrue(l1, items.getText());

		}

	}

	@Test(enabled = false)
	public void switchWindow() throws Exception {
		super.initDriver();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('FirstName').value='Jhonny'");
		js.executeScript("window.scrollBy(0,300)", " ");
		String parent_window = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div/div[1]/p/a")).click();
		Set<String> windows = driver.getWindowHandles();
		for (String handles : windows) {
			System.out.println(handles);
			if (!handles.equalsIgnoreCase(parent_window)) {
				driver.switchTo().window(handles);
				Thread.sleep(4000);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}

		driver.switchTo().window(parent_window);
		System.out.println(driver.getTitle());
		driver.navigate().to("https://accounts.google.com/SignUp?hl=en");
		String p1 = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div/div[1]/p/a")).click();
		Set<String> windws = driver.getWindowHandles();
		Iterator<String> ir = windws.iterator();
		while (ir.hasNext()) {
			String child_window1 = ir.next();
			if (!child_window1.equalsIgnoreCase(p1)) {
				driver.switchTo().window(child_window1);
				Thread.sleep(3000, 0);
				System.out.println(driver.getCurrentUrl());
				driver.close();
			}
		}
		driver.switchTo().window(p1);
		System.out.println(driver.getCurrentUrl());

	}

	@Test(enabled = true)
	public void uploadFile() throws Exception {
		super.initDriver();
		driver.navigate().to("file:///C:/Users/shashi/Desktop/Selenium/doc.html");
		driver.findElement(By.id("1")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\shashi\\Desktop\\Selenium\\autoit.exe");

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenShots.takeScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
