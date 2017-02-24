package tests;

import message.MessageFactory;


import org.testng.annotations.Test;
import org.testng.Assert;

import business_objects.Users;

public class GmailTest extends BaseTest {
	private static final String ADDRESS = "keazonir@gmail.com";
	private static final String SUBJECT = "test";
	private static final String MESSAGE_TEXT = "Hello! This message was generated automatically.";

	
	MessageFactory message = new MessageFactory();
	
	@Test(priority = 0)
	public void login() {

		Assert.assertTrue(
				loginPage.authorization(new Users()).loginIsCorrect(),
				"Login is failed");
	}

	@Test(priority = 1)
	public void createEmail() {
		Assert.assertTrue(homePage.writeMessage(message.getMessage(ADDRESS, SUBJECT,MESSAGE_TEXT ))
				.goToDraftPage().messageIsPresent(),
				"Letter was not saved as draft");

		Assert.assertTrue(
				draftPage.checkMessageContent(message.getMessage(MESSAGE_TEXT, SUBJECT, ADDRESS)),
				"The content of the letter is not the same");
	}

	@Test(priority = 2)
	public void sendEmail() {
		Assert.assertTrue(draftPage.sendMessage().messageWasSent(),
				"The letter wasn't sent, letter is in the draft folder");

		Assert.assertTrue(draftPage.goToSendPage().checkEmailIsSent(),
				"The letter wasn't sent");
	}

	@Test(priority = 3)
	public void logout() {

		Assert.assertTrue(sendPage.logOut().logoutIsCompleted(),
				"The logout was not completed");

	}

}
