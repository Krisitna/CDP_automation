package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import pages.DraftPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SendPage;

public class GmailTest extends BaseTest {
	private static final String EMAIL = "yonentin@gmail.com";
	private static final String PASSWORD = "epamyon123456";
	private static final String ADDRESS = "keazonir@gmail.com";
	private static final String SUBJECT = "test";
	private static final String MESSAGE_TEXT = "Hello! This message was generated automatically.";
	private LoginPage loginPage;
	private HomePage homePage;
	private DraftPage draftPage;
	private SendPage sendPage;

	@Test(description = "Send letter")
	public void sendLetter() {

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		draftPage = new DraftPage(driver);
		sendPage = new SendPage(driver);

		Assert.assertTrue(loginPage.authorization(EMAIL, PASSWORD)
				.loginIsCorrect(), "Login is failed");

		Assert.assertTrue(homePage.writeMessage(ADDRESS, MESSAGE_TEXT, SUBJECT)
				.goToDraftPage().messageIsPresent(),
				"Letter was not saved as draft");

		Assert.assertTrue(
				draftPage.checkMessageContent(MESSAGE_TEXT, SUBJECT, ADDRESS),
				"The content of the letter is not the same");

		Assert.assertTrue(draftPage.sendMessage().messageWasSent(),
				"The letter wasn't sent, letter is in the draft folder");

		Assert.assertTrue(draftPage.goToSendPage().checkEmailIsSent(),
				"The letter wasn't sent");

		Assert.assertTrue(sendPage.logOut().logoutIsCompleted(),
				"The letter wasn't sent");

	}

}
