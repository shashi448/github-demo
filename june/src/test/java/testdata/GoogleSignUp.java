package testdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSignUp {

	public static WebElement element = null;

	/**
	 * Finding the learn more element
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement learnMore(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div/div[1]/p/a"));
		return element;

	}

	/**
	 * Click on learn more element
	 * 
	 * @param driver
	 */
	public static void clickLeanrMore(WebDriver driver) {
		element = learnMore(driver);
		element.click();
	}

	/**
	 * find the element for first Name
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement firstName(WebDriver driver) {
		element = driver.findElement(By.id("FirstName"));
		return element;
	}

	/**
	 * Click on the firstName and enter a value
	 * 
	 * @param driver
	 * @param firstName
	 */
	public static void clickFirstName(WebDriver driver, String firstName) {
		element = firstName(driver);
		element.clear();
		element.sendKeys(firstName);
	}

	public static WebElement signIn(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[3]/div/a"));
		return element;
	}

	public static void clickSignIn(WebDriver driver) {
		element = signIn(driver);
		element.click();
	}

}
