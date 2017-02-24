package ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverSingleton {
	private static WebDriver driver;

	private WebDriverSingleton() {
	}

	public static WebDriver getWebDriverInstance(BrowserTypes type)
			throws Exception {
		if (driver == null) {

			switch (type) {
			case FIREFOX: {
				System.setProperty("webdriver.ie.driver",
						"../MailAutomation/firefox/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			}
			case IE: {
				System.setProperty("webdriver.ie.driver",
						"../MailAutomation/ie/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			}
			case CHROME: {
				System.setProperty("webdriver.chrome.driver",
						"../MailAutomation/chromedriver/chromedriver.exe");
				driver = new ChromeDriver();
				driver = new CustomDriverDecorator(driver);
				break;
			}
			default:
				throw new Exception("Unknown web driver specified: " + type);
			}

		}

		return driver;
	}
}