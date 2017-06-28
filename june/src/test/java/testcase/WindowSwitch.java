package testcase;

import java.util.Iterator;
import java.util.Set;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import core.BaseClass;
import screenshot.ScreenShots;
import testdata.GoogleSignUp;

public class WindowSwitch extends BaseClass {

	@Test(priority = 2, enabled = false)
	public void forLoop() throws Exception {
		super.initDriver();
		GoogleSignUp.clickFirstName(driver, "John Legend");
		log.info("User enterting the firstName successfully");
		String parent_window = driver.getWindowHandle();
		log.info("User saved the parent handle window value in a String");
		GoogleSignUp.clickLeanrMore(driver);
		log.info("User opened up a new window");
		Set<String> sp = driver.getWindowHandles();

	}

	@Test(priority = 0)
	public void whileLoop() throws Exception {
		super.initDriver();
		GoogleSignUp.clickFirstName(driver, "John Legend");
		log.info("User enterting the firstName successfully");
		String parent_window = driver.getWindowHandle();
		log.info("User saved the parent handle window value in a String");
		GoogleSignUp.clickLeanrMore(driver);
		log.info("User opened up a new window");
		Set<String> sp = driver.getWindowHandles();
		Iterator<String> ir = sp.iterator();
		while (ir.hasNext()) {
			String child_window = ir.next();
			System.out.println(driver.getTitle());
			if (!parent_window.equalsIgnoreCase(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.getTitle());
				GoogleSignUp.clickSignIn(driver);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parent_window);
		System.out.println(driver.getTitle());
	}

	@Test(priority = 1)
	public void forEachLoop() throws Exception {
		super.initDriver();
		GoogleSignUp.clickFirstName(driver, "John Legend");
		log.info("User enterting the firstName successfully");
		String parent_window = driver.getWindowHandle();
		log.info("User saved the parent handle window value in a String");
		GoogleSignUp.clickLeanrMore(driver);
		log.info("User opened up a new window");
		Set<String> sp = driver.getWindowHandles();
		for (String handles : sp) {
			System.out.println(handles);
			if (!parent_window.equalsIgnoreCase(handles)) {
				driver.switchTo().window(handles);
				System.out.println(driver.getTitle());
				GoogleSignUp.clickSignIn(driver);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parent_window);
		System.out.println(driver.getTitle());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenShots.takeScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
