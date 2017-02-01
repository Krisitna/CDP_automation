package tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import framework.Gmail;

public class GmailTest extends BaseTest {
	@Test
	public void checkMessageIsSent() {
		driver.get(Gmail.GMAIL_START_PAGE);
		waitForElementIsClickable(Gmail.INPUT_LOGIN_LOCATOR);
		driver.findElement(Gmail.INPUT_LOGIN_LOCATOR).sendKeys(Gmail.USER_NAME);
		driver.findElement(Gmail.BUTTON_NEXT_LOCATOR).click();
		waitForElementIsClickable(Gmail.INPUT_PASSWORD_LOCATOR);
		driver.findElement(Gmail.INPUT_PASSWORD_LOCATOR).sendKeys(Gmail.PASSWORD);
		driver.findElement(Gmail.BUTTON_SIGN_IN_LOCATOR).click();
		waitForElementIsPresented(Gmail.BUTTON_COMPOSE_LOCATOR);

		Assert.assertTrue(driver.findElement(Gmail.BUTTON_COMPOSE_LOCATOR).isDisplayed(), "login failed");

		driver.findElement(Gmail.BUTTON_COMPOSE_LOCATOR).click();
		driver.switchTo().activeElement();
		waitForElementIsClickable(Gmail.FIELD_ADDRESSEE_LOCATOR);
		driver.findElement(Gmail.FIELD_ADDRESSEE_LOCATOR).click();
		driver.findElement(Gmail.FIELD_ADDRESSEE_LOCATOR).sendKeys(Gmail.ADDRESSEE);
		waitForElementIsClickable(Gmail.NEW_LOCATOR);
		driver.findElement(Gmail.NEW_LOCATOR).click();
		driver.findElement(Gmail.FIELD_SUBJECT_LOCATOR).click();
		driver.findElement(Gmail.FIELD_SUBJECT_LOCATOR).sendKeys(Gmail.SUBJECT);
		driver.findElement(Gmail.FIELD_MESSAGE_TEXT_LOCATOR).click();
		driver.findElement(Gmail.FIELD_MESSAGE_TEXT_LOCATOR).sendKeys(Gmail.MESSAGE_TEXT);
		waitForElementIsPresented(Gmail.SAVED_LOCATOR);
		driver.findElement(Gmail.BUTTON_CLOSE_MESSAGE_LOCATOR).click();

		driver.findElement(Gmail.BUTTON_DRAFTS_LOCATOR).click();
		waitForElementIsPresented(Gmail.MESSAGE_IN_DRAFT_FOLDER_LOCATOR);

		Assert.assertTrue(driver.findElement(Gmail.MESSAGE_IN_DRAFT_FOLDER_LOCATOR).isDisplayed(),
				"no messages in draft folder");

		driver.findElement(Gmail.MESSAGE_IN_DRAFT_FOLDER_LOCATOR).click();
		waitForElementIsPresented(Gmail.CHECK_MESSAGE_TEXT_LOCATOR);

		Assert.assertEquals(driver.findElement(Gmail.CHECK_MESSAGE_TEXT_LOCATOR).getText(), Gmail.MESSAGE_TEXT);

		driver.findElement(Gmail.BUTTON_SEND_MESSAGE_LOCATOR).click();

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		Assert.assertTrue(driver.findElements(Gmail.MESSAGE_IN_DRAFT_FOLDER_LOCATOR).size() == 0,
				"message is in drafts folder yet");

		driver.findElement(Gmail.BUTTON_SENT_MAIL_LOCATOR).click();
		waitForElementIsPresented(Gmail.CHECK_SEND_MESSAGE_TEXT_LOCATOR);

		Assert.assertEquals(driver.findElement(Gmail.CHECK_SEND_MESSAGE_TEXT_LOCATOR).getText(),
				" - Hello! This message was generated automatically.", "message is not in sent mail folder");

		waitForElementIsClickable(Gmail.BUTTON_USER_ICON_LOCATOR);
		driver.findElement(Gmail.BUTTON_USER_ICON_LOCATOR).click();
		waitForElementIsClickable(Gmail.BUTTON_LOG_OUT_LOCATOR);
		driver.findElement(Gmail.BUTTON_LOG_OUT_LOCATOR).click();

	}
}
