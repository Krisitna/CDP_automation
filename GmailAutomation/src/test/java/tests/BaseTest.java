package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	public static WebDriver driver;

	public void waitForElementIsClickable(By locator) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForElementIsPresented(By locator) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	@BeforeClass(description = "chrome remote launch")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "../MailAutomation/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void tearDown() {
		//driver.close();
	}
}
