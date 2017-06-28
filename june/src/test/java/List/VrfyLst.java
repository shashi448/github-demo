package List;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import core.BaseClass;

public class VrfyLst extends BaseClass {

	@Test
	public void testLst() throws Exception {
		super.initDriver();
		String[] itms = { "Slower", "Slow", "Medium", "Fast", "Faster" };
		driver.navigate().to("http://jqueryui.com/selectmenu/");
		driver.navigate().refresh();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content']/iframe")));
		driver.findElement(By.cssSelector("#speed-button")).click();
		WebElement speedMenu = driver.findElement(By.xpath("//*[@id='speed-menu']"));
		List<WebElement> items = speedMenu.findElements(By.tagName("li"));
		for (WebElement it1 : items) {
			boolean a1 = false;
			System.out.println(it1.getText());
			for (int i = 0; i < itms.length; i++) {
				if (it1.getText().equals(itms[i])) {
					a1 = true;
				}
			}
			Assert.assertTrue(a1);
			Assert.assertTrue(a1, it1.getText());
		}
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
