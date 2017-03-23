package by.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchResultPage extends AbstractPage {

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@id='item5442fa2623']/h3/a")
	private WebElement selectedProduct;
	
	@FindBy (xpath ="//a[@id='viewType']")
	private WebElement controlButton;
	
	@FindBy(id = "gh-cart-i")
	private WebElement cartIcon;
	
	public ProductPage goToProductPage (){
		wait.waitForElementIsVisible(selectedProduct);
		selectedProduct.click();
		return new ProductPage (driver);
		
	}
	
		
	public boolean searchResultPageisDisplayed (){
		return controlButton.isDisplayed() ;
		
	}

	public CartPage goToCartPage (){
		cartIcon.click();
		return new CartPage (driver);	
	}
	
}
