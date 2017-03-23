package by.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	//@FindBy (xpath = "//div[@class='fw-b']")
	@FindBy (xpath ="//a[@href='http://www.ebay.com/itm/361900942883']")
	private WebElement selectedProduct;

	@FindBy(xpath = "//a[@class='action actionLink']")
	private WebElement deleteButton;

	@FindBy(id = "gh-cart-n")
	private WebElement cartIcon;

	@FindBy(id = "contShoppingBtn")
	private WebElement contShoppingButton;

	@FindBy(xpath = "//img[@src='https://i.ebayimg.com/images/g/zYUAAOSw4A5YnAgu/s-l140.jpg']")
	private WebElement productImage;

	@FindBy(xpath = "//a[@id='361900942883_title']")
	private WebElement productName;

	public boolean productInCart() {
		wait.waitForElementIsVisible(selectedProduct);
		return selectedProduct.isDisplayed();

	}
   public boolean productIsNotInCart () {
	   return selectedProduct.isEnabled();
   }
	

	public CartPage deleteProduct() {
		wait.waitForElementIsVisible(deleteButton);
		deleteButton.click();
		return this;
	}

	public CartPage quantityOfProductsInCart(String quantity) {
		cartIcon.getAttribute(quantity);
		return this;
	}

	public SearchResultPage goToSearchResultPage() {
		wait.waitForElementIsClickable(contShoppingButton);
		contShoppingButton.click();
		return new SearchResultPage(driver);
	}

	public ProductPage goToProductPage(String productElement) {
		if (productElement == "product image") {
			productImage.click();
		} else {
			productName.click();
		}
		return new ProductPage(driver);
	}
}
