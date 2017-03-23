package by.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gh-cart-i")
	private WebElement cartIcon;

	@FindBy(id = "gh-btn")
	private WebElement searchButton;

	@FindBy(id = "gh-ac")
	private WebElement searchField;

	public void goToHomePage() {
		driver.get("http://ebay.com");
		
		
	}

	public SearchResultPage searchProduct(String request) {
		wait.waitForElementIsClickable(searchButton);
		searchField.sendKeys(request);
		searchButton.click();
		return new SearchResultPage(driver);
	}

	public CartPage goToCartPage() {
		cartIcon.click();
		return new CartPage(driver);
	}
}
