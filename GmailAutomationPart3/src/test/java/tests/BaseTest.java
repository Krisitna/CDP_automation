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

	
	/*@BeforeClass
	public void browserSetUpChrome() {
		System.setProperty("webdriver.chrome.driver",
				"../MailAutomation/chromedriver/chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setPlatform(Platform.WINDOWS);
		try {
			driver = new RemoteWebDriver(
					new URL("http://localhost:4444/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
*/
	
	 /*@BeforeClass public void browserSetUpIE() {
	 * System.setProperty("webdriver.ie.driver",
	 * "../MailAutomation/ie/IEDriverServer.exe"); DesiredCapabilities
	 * capabilities = DesiredCapabilities.internetExplorer();
	 * capabilities.setPlatform(Platform.WINDOWS); try { driver = new
	 * RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities); }
	 * catch (MalformedURLException e) { e.printStackTrace(); } //driver = new
	 * ChromeDriver(capabilities); }
	 */

	/*@BeforeClass
	public void browserSetFF() {
		System.setProperty("webdriver.gecko.driver",
				"../MailAutomation/firefox/geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setPlatform(Platform.WINDOWS);
		try {
			driver = new RemoteWebDriver(
					new URL("http://localhost:4444/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}(dependsOnMethods = "browserSetFF")
	}*/

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
