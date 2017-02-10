package tests;

	import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;


	public class GmailTestFF extends BaseTest {
		private static final String EMAIL = "yonentin@gmail.com";
		private static final String PASSWORD = "epamyon123456";
		private static final String ADDRESS = "keazonir@gmail.com";
		private static final String SUBJECT = "test";
		private static final String MESSAGE_TEXT = "Hello! This message was generated automatically.";
		
		@BeforeTest
		public void browserSetFF() {
			System.setProperty("webdriver.gecko.driver",
					"../MailAutomation/firefox/geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setPlatform(Platform.WINDOWS);
			try {
				driver = new RemoteWebDriver(
						new URL("http://localhost:4444/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		@Test(priority = 0)
		public void login() {

			Assert.assertTrue(loginPage.authorization(EMAIL, PASSWORD)
					.loginIsCorrect(), "Login is failed");
		}

		@Test(priority = 1)
		public void createEmail() {
			Assert.assertTrue(homePage.writeMessage(ADDRESS, MESSAGE_TEXT, SUBJECT)
					.goToDraftPage().messageIsPresent(),
					"Letter was not saved as draft");

			Assert.assertTrue(
					draftPage.checkMessageContent(MESSAGE_TEXT, SUBJECT, ADDRESS),
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



