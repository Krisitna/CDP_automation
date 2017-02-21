package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.DraftPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SendPage;
import ui.driver.Driver;

public class BaseTest {
	protected static WebDriver driver;
	protected static final String startURL = "https://gmail.com";
	protected LoginPage loginPage;
	protected HomePage homePage;
	protected DraftPage draftPage;
	protected SendPage sendPage;

	@BeforeClass
	public void prepare() throws Exception {
		driver = Driver.getWebDriverInstance();
             driver.get(startURL);
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
		// driver.close();

	}
}
