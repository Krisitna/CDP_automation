package pages;

//import org.openqa.selenium.By;


import message.Message;
import message.MessageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {

	@FindBy(xpath = "//div[@class ='z0']/div")
	private WebElement createMessageButton;

	@FindBy(xpath = "//textarea[@name='to']")
	private WebElement addressField;

	@FindBy(xpath = "//input[@name = 'subjectbox']")
	private WebElement subjectField;

	@FindBy(xpath = "//div[@class = 'Am Al editable LW-avf']")
	private WebElement messageField;

	@FindBy(xpath = "//div[@class = 'aq aFf']")
	private WebElement popUpWindow;

	@FindBy(xpath = "//span[contains(text(), 'Saved')]")
	private WebElement saveSign;

	@FindBy(xpath = "//img[@class = 'Ha']")
	private WebElement closeMessageButton;

	@FindBy(xpath = "//a[contains(text(), 'Drafts')]")
	private WebElement draftButton;

	public HomePage(WebDriver driver) {
		super(driver);

	}

	MessageFactory message = new MessageFactory();
	
	public boolean loginIsCorrect() {
		wait.waitForElementIsClickable(createMessageButton);
		System.out.println("Login was completed correctly.");
		return createMessageButton.isDisplayed();
	}

	private HomePage goToSendMessageForm() {
		//double click to the button
		new Actions(driver).click(createMessageButton).build().perform();
		return this;
	}

	private HomePage switchToNewWindow() {
		driver.switchTo().activeElement();
		return this;
	}

	private HomePage fillAddressField(String address) {
		wait.waitForElementIsClickable(addressField);
		addressField.click();
		addressField.sendKeys(address);
		wait.waitForElementIsClickable(popUpWindow);
		popUpWindow.click();
		addressField.click();
		return this;
	}

	private HomePage fillSubjectField(String subject) {
		wait.waitForElementIsClickable(subjectField);
		subjectField.click();
		//type text into particular webElement
		new Actions(driver).sendKeys(subjectField, subject).build().perform();
		subjectField.click();
		return this;
	}

	private HomePage fillMessageField(String message) {
		messageField.click();
		//type text into particular webElement
		new Actions(driver).sendKeys(messageField, message).build().perform();
		return this;
	}

	private HomePage closeMessageWindow() {
		wait.waitForElementIsClickable(closeMessageButton);
		//move mouse cursor to the center of close button
		new Actions(driver).moveToElement(closeMessageButton).click().build().perform();
		return this;
	}

	public HomePage writeMessage(Message message) {
		goToSendMessageForm();
		switchToNewWindow();
		fillAddressField(message.getToEmail());
		fillSubjectField(message.getSubject());
		fillMessageField(message.getContent());
		wait.waitForElementIsVisible(saveSign);
		closeMessageWindow();
		System.out.println("Writting email in progress...");
		return this;
	}

	public DraftPage goToDraftPage() {
		wait.waitForElementIsClickable(draftButton);
		draftButton.click();
		return new DraftPage(driver);
	}

}
