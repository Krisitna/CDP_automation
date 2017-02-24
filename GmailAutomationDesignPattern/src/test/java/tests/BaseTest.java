package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.DraftPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SendPage;
import ui.driver.BrowserTypes;
import ui.driver.WebDriverSingleton;

public class BaseTest {
	protected static WebDriver driver;
	protected static final String START_URL = "https://gmail.com";
	protected LoginPage loginPage;
	protected HomePage homePage;
	protected DraftPage draftPage;
	protected SendPage sendPage;

	@BeforeClass
	public void prepare() throws Exception {
		driver = WebDriverSingleton.getWebDriverInstance(BrowserTypes.CHROME);
		driver.get(START_URL);

	}

	@BeforeClass(dependsOnMethods = "prepare")
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		draftPage = new DraftPage(driver);
		sendPage = new SendPage(driver);
	}

	@AfterClass
	public void tearDown() {
		driver.close();

	}
}
