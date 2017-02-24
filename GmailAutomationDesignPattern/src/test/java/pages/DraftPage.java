package pages;

import java.util.List;

import message.Message;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class DraftPage extends AbstractPage {

	@FindBys(@FindBy(xpath = "//span[@class = 'y2']"))
	private List<WebElement> messageInDraftFolderLocator;

	@FindBy(xpath = "//div[@class = 'Am Al editable LW-avf']")
	private WebElement messageText;

	@FindBy(xpath = "//span[@class = 'y2']")
	private WebElement messageLabel;

	@FindBy(name = "subjectbox")
	private WebElement subjectText;

	@FindBy(xpath = "//span[@class = 'vN bfK a3q']")
	private WebElement addressText;

	@FindBy(xpath = "//div[contains(text(), 'Send')]")
	private WebElement sendButton;

	@FindBy(xpath = "//a[contains(text(), 'Sent Mail')]")
	private WebElement sentEmailButton;

	public DraftPage(WebDriver driver) {
		super(driver);

	}

	public boolean messageIsPresent() {
		wait.waitForElementIsVisible(messageLabel);
		System.out.println("Message saved in the draft folder");
		return messageLabel.isDisplayed();
	}

	public boolean checkMessageContent(Message message) {
		messageLabel.click();
		wait.waitForElementIsVisible(messageText);
		boolean result = true;
		result &= message.getSubject().equals(subjectText.getText());
		result &= message.getToEmail().equals(addressText.getText());
		System.out.println("Content is the same.");
		return message.getContent().equals(messageText.getText());
	}

	public DraftPage sendMessage() {
		sendButton.click();
		return this;
	}

	public boolean messageWasSent() {
		try {
			Thread.sleep(13000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("Sending message is in progress...");
		return messageInDraftFolderLocator.size() == 0;
	}

	public SendPage goToSendPage() {
		wait.waitForElementIsClickable(sentEmailButton);
		sentEmailButton.click();
		return new SendPage(driver);
	}
}
