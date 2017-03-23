package by.epam.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import by.epam.pages.*;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true, features = "classpath:cart/Basket.feature", glue = "by.epam", plugin = {
		"pretty", "json:target/Cucumber.json", })
public class RunCatTests {
	protected static WebDriver driver;
	protected HomePage homePage = new HomePage(driver);
	protected ProductPage productPage = new ProductPage(driver);
	protected SearchResultPage searchResultPage = new SearchResultPage(driver);
	protected CartPage cartPage = new CartPage(driver);

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"../eBayAutotests/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}


	@AfterClass
	public static void afterClass() {
		driver.close();

	}

}
