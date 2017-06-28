package testdata;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Expedia {

	public static WebElement element = null;

	public static WebElement depart(WebDriver driver) {
		element = driver.findElement(By.id("flight-departing-hp-flight"));
		return element;
	}

	public static void clickDepartDate(WebDriver driver) {
		element = depart(driver);
		element.click();
	}

	public static WebElement flights(WebDriver driver) {
		element = driver.findElement(By.id("tab-flight-tab-hp"));
		return element;
	}

	public static void clickFlights(WebDriver driver) {
		element = flights(driver);
		element.click();
	}

	public static WebElement roundTrip(WebDriver driver) {
		element = driver.findElement(By.id("flight-type-roundtrip-label-hp-flight"));
		return element;
	}

	public static void clickRoundTrip(WebDriver driver) {
		element = roundTrip(driver);
		element.click();
	}

	public static WebElement flyFrom(WebDriver driver) {
		element = driver.findElement(By.id("flight-origin-hp-flight"));
		return element;
	}

	public static void clickFlyFrom(WebDriver driver, String city) {
		element = flyFrom(driver);
		element.clear();
		element.sendKeys(city);

	}

	public static WebElement flyTo(WebDriver driver) {
		element = driver.findElement(By.id("flight-destination-hp-flight"));
		return element;
	}

	public static void clickFlyTo(WebDriver driver, String city) {
		element = flyTo(driver);
		element.clear();
		element.sendKeys(city);
	}

	public static void enterDepartDate(WebDriver driver, String mnth, String date) {
		while (true) {
			WebElement mnthDt = driver
					.findElement(By.xpath("//*[@id='flight-departing-wrapper-hp-flight']/div/div/div/table/caption"));
			if (mnthDt.getText().equalsIgnoreCase(mnth)) {
				List<WebElement> allDates = driver.findElements(
						By.xpath("//*[@id='flight-departing-wrapper-hp-flight']/div/div/div/table/tbody/tr/td/button"));
				Iterator<WebElement> ir = allDates.iterator();
				while (ir.hasNext()) {
					WebElement getElements = ir.next();
					if (getElements.getText().equalsIgnoreCase(date)) {
						getElements.click();
						break;
					}
				}
				break;
			} else {
				WebElement next = driver
						.findElement(By.xpath("//*[@id='flight-departing-wrapper-hp-flight']/div/div/button[2]"));
				next.click();

			}

		}
	}

	public static WebElement arrivalDate(WebDriver driver) {
		element = driver.findElement(By.id("flight-returning-hp-flight"));
		return element;
	}

	public static void clickArrivalDate(WebDriver driver) {
		element = arrivalDate(driver);
		element.click();
	}

	public static void enterArrivalDate(WebDriver driver, String mnthDt, String date) {
		while (true) {
			WebElement mnthDate = driver
					.findElement(By.xpath("//*[@id='flight-returning-wrapper-hp-flight']/div/div/div/table/caption"));
			if (mnthDate.getText().equalsIgnoreCase(mnthDt)) {
				List<WebElement> dates = driver.findElements(
						By.xpath("//*[@id='flight-returning-wrapper-hp-flight']/div/div/div/table/tbody/tr/td/button"));
				Iterator<WebElement> ir = dates.iterator();
				while (ir.hasNext()) {
					WebElement getAlldates = ir.next();
					if (getAlldates.getText().equalsIgnoreCase(date)) {
						getAlldates.click();
					}
				}
				break;
			} else {
				WebElement nxt = driver
						.findElement(By.xpath("//*[@id='flight-returning-wrapper-hp-flight']/div/div/button[2]"));

			}
		}
	}

	public static WebElement search(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#search-button-hp-package"));
		return element;
	}

	public static void searchButton(WebDriver driver) {
		element = search(driver);
		element.click();
	}
}
