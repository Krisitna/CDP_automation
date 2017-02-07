package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

	@FindBy(id = "Email")
	private WebElement loginField;

	@FindBy(id = "Passwd")
	private WebElement passwordField;

	@FindBy(id = "next")
	private WebElement nextButton;

	@FindBy(id = "signIn")
	private WebElement signInButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public HomePage authorization(String email, String password) {
		wait.waitForElementIsClickable(loginField);
		loginField.click();
		loginField.clear();
		loginField.sendKeys(email);
		nextButton.click();
		wait.waitForElementIsClickable(passwordField);
		passwordField.click();
		passwordField.clear();
		passwordField.sendKeys(password);
		signInButton.click();
		System.out.println("Login is in progress...");
		return new HomePage(driver);
	}

	public boolean logoutIsCompleted() {
		wait.waitForElementIsClickable(passwordField);
		System.out.println("Logout is compleated");
		return passwordField.isDisplayed();
	}

}
