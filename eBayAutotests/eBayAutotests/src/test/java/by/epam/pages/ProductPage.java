package by.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "isCartBtn_btn")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//input[@id='qtyTextBox']")
	private WebElement quantityBox;
	
	@FindBy(id = "gh-cart-i")
	private WebElement cartIcon;
	
	@FindBy (id = "paymentsPlaceHolderId")
	private WebElement paymentDetails;
	
	public CartPage addProductToCart(){
		wait.waitForElementIsClickable(addToCartButton);
		addToCartButton.click();
		return new CartPage (driver);	
	}
	
	public ProductPage changeProductQuintity (String quantity){
		wait.waitForElementIsClickable(addToCartButton);
		quantityBox.clear();
		quantityBox.sendKeys(quantity);
		return this;	
	}
	
	public boolean productPageIsDisplayed (){
		return paymentDetails.isDisplayed();
		
	}
	
	public CartPage goToCartPageFromProductPage (){
		cartIcon.click();
		return new CartPage (driver);
		
	}
}
