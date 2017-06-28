package testcase;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import core.BaseClass;
import screenshot.ScreenShots;

public class ListClass extends BaseClass {
	@Test(enabled = false)
	public void forLoop() throws Exception {
		super.initDriver();
		driver.navigate().to("https://www.facebook.com/");
		WebElement mnth = driver.findElement(By.id("month"));
		List<WebElement> lst = mnth.findElements(By.tagName("option"));
		Iterator<WebElement> ir = lst.iterator();
		while (ir.hasNext()) {
			WebElement sp = ir.next();
			System.out.println(sp.getText());
			/*
			 * if(!sp.getText().contentEquals("Sep")){ Select s4=new
			 * Select(mnth); s4.selectByValue("Sep");
			 * 
			 * }
			 */
		}
		Thread.sleep(4000);
	}

	@Test
	public void shiftKey() throws Exception {
		super.initDriver();
		driver.navigate().to("https://www.amazon.com/");
		WebElement dept = driver.findElement(By.xpath("//*[@id='nav-link-shopall']/span[2]"));
		Actions builder = new Actions(driver);
		WebElement context = driver.findElement(By.id("twotabsearchtextbox"));
		builder.contextClick(context).perform();
		Thread.sleep(3000);
		String parent_window = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		builder.keyDown(Keys.SHIFT).build().perform();
		dept.click();
		Set<String> sp = driver.getWindowHandles();
		Iterator<String> ir = sp.iterator();
		while (ir.hasNext()) {
			String child_window = ir.next();
			System.out.println(child_window);
			if (!parent_window.equalsIgnoreCase(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parent_window);
		builder.keyUp(Keys.SHIFT).build().perform();
		
	}

	@Test
	public void waitTest() throws Exception {
		super.initDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("id")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.title");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenShots.takeScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
