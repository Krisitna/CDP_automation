package by.epam.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import by.epam.runner.RunCatTests;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BaseStepsDef extends RunCatTests {

	@Given("^The homepage is loaded$")
	public void the_homepage_is_loaded() {
		homePage.goToHomePage();
	}

	@Given("^I open my cart$")
	public void i_open_my_cart() {
		homePage.goToCartPage();
	}

	@When("^I quick seacrch for \"([^\"]*)\"$")
	public void i_quick_seacrch_for(String request) {
		homePage.searchProduct(request);
	}

	@When("^I click on the product link$")
	public void i_click_on_the_product_link() {
		searchResultPage.goToProductPage();
	}

	@When("^I add the item to my cart$")
	public void i_add_the_item_to_my_cart() {
		productPage.addProductToCart();

	}

	@Then("^The added product is displayed in my cart$")
	public void the_added_product_is_displayed_in_my_cart() {
		Assert.assertTrue(cartPage.productInCart());
		cartPage.deleteProduct();
	}

	@When("^I set the quantity of item is (\\d+)$")
	public void i_set_the_quantity_of_item_is(String quantity) {
		productPage.changeProductQuintity(quantity);
		//productPage.goToCartPageFromProductPage();

	}

	@Then("^The quantity of product is (\\d+) in my cart$")
	public void the_quantity_of_product_is_in_my_cart(String quantity) {
		cartPage.quantityOfProductsInCart(quantity);
		cartPage.deleteProduct();
	}

	@When("^I click on the remove button on cart$")
	public void i_click_on_the_remove_button_on_cart() {
		cartPage.deleteProduct();
	}

	@Then("^The product is not displayed in my cart$")
	public void the_product_is_not_displayed_in_my_cart() {
		Assert.assertTrue(cartPage.productIsNotInCart());

	}

	@When("^I click on the continue shopping button on the cart page$")
	public void i_click_on_the_continue_shopping_button_on_the_cart_page() {
		cartPage.goToSearchResultPage();
	}

	@Then("^The previous listing page is dispplayed$")
	public void the_previous_listing_page_is_dispplayed() {
		Assert.assertTrue(searchResultPage.searchResultPageisDisplayed());
		searchResultPage.goToCartPage();
		cartPage.deleteProduct();
	}

	@When("^I click on \"([^\"]*)\" on the cart page$")
	public void i_click_on_on_the_cart_page(String productElement) {
		cartPage.goToProductPage(productElement);
	}

	@Then("^The product detailed page is displayed$")
	public void the_product_detailed_page_is_displayed() {
		Assert.assertTrue(productPage.productPageIsDisplayed());
		productPage.goToCartPageFromProductPage();
		cartPage.deleteProduct();

	}
}
