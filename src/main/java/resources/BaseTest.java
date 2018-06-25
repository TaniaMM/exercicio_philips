package resources;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;

	public WebDriver getDriver() {
		return driver;
	}

	public Properties getProperties() {
		return prop;
	}

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		
		prop.load(BaseTest.class.getResourceAsStream("data.properties"));

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			// execute in chrome driver
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome.driver"));
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			// execute in firefox driver
			System.setProperty("webdriver.firefox.driver", prop.getProperty("firefox.driver"));
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			// execute in IE driver
			System.setProperty("webdriver.ie.driver", prop.getProperty("msie.driver"));
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
