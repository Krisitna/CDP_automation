package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
