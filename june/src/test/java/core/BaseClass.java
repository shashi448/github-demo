package core;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	public static Properties config;
	public static Properties object;
	public static WebDriver driver;
	public static Logger log;

	public static void initDriver() throws Exception {

		log = Logger.getLogger(BaseClass.class);

		config = new Properties();
		log.info(" Loading config properties");
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\shashi\\workspace2\\june\\src\\test\\java\\properties\\config.properties");
		config.load(fis);

		object = new Properties();
		FileInputStream fp = new FileInputStream(
				"C:\\Users\\shashi\\workspace2\\june\\src\\test\\java\\properties\\config.properties");
		object.load(fp);

		if (config.getProperty("browser").equals("ie")) {
			driver = new InternetExplorerDriver();

		}

		else if (config.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (config.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(config.getProperty("url"));
	}

}
