package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendPage extends AbstractPage {

	@FindBy(xpath = "//span[@class = 'y2']")
	private WebElement sentMessageLocator;

	@FindBy(xpath = "//span[@class = 'gb_9a gbii']")
	private WebElement userIcon;

	@FindBy(xpath = "//a[text() ='Sign out']")
	private WebElement logoutButton;

	public SendPage(WebDriver driver) {
		super(driver);

	}

	public boolean checkEmailIsSent() {
		wait.waitForElementIsClickable(sentMessageLocator);
		System.out.println("Email was sent");
		return sentMessageLocator.isDisplayed();

	}

	public LoginPage logOut() {
		wait.waitForElementIsClickable(userIcon);
		userIcon.click();
		wait.waitForElementIsClickable(logoutButton);
		logoutButton.click();
		return new LoginPage(driver);

	}

}
