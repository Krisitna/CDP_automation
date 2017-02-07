package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	protected static WebDriver driver;
	protected static final String startURL = "https://gmail.com";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"../MailAutomation/chromedriver/chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		driver = new ChromeDriver(capabilities);
		driver.get(startURL);
	}

	@AfterClass
	public void tearDown() {
		// driver.close();

	}
}
