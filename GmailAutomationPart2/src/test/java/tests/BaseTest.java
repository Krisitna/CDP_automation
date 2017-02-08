package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.DraftPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SendPage;


public class BaseTest {
	protected static WebDriver driver;
	protected static final String startURL = "https://gmail.com";
    protected LoginPage loginPage;
	protected HomePage homePage;
	protected DraftPage draftPage;
	protected SendPage sendPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"../MailAutomation/chromedriver/chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		driver = new ChromeDriver(capabilities);
		driver.get(startURL);
        loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		draftPage = new DraftPage(driver);
		sendPage = new SendPage(driver);
	}

	@AfterClass
	public void tearDown() {
		// driver.close();

	}
}
