package framework;

import org.openqa.selenium.By;

public class Gmail {
	public static final String GMAIL_START_PAGE = "https://gmail.com";
	public static final String USER_NAME = "yonentin@gmail.com";
	public static final String PASSWORD = "epamyon123456";
	
	public static final String ADDRESSEE = "keazonir@gmail.com";
	public static final String SUBJECT = "test";
	public static final String MESSAGE_TEXT  = "Hello! This message was generated automatically.";
	
	//---------login-----------
	public static final By INPUT_LOGIN_LOCATOR = By.cssSelector("input#Email");
	public static final By BUTTON_NEXT_LOCATOR = By.cssSelector("input#next");
	public static final By INPUT_PASSWORD_LOCATOR = By.cssSelector("input#Passwd");
	public static final By BUTTON_SIGN_IN_LOCATOR = By.cssSelector("input#signIn");

	
	//-------create a new mail------
	public static final By BUTTON_COMPOSE_LOCATOR = By.xpath("//div[contains(text(), 'COMPOSE')]");
	public static final By FIELD_ADDRESSEE_LOCATOR = By.xpath("//textarea[@name='to']");
	public static final By NEW_LOCATOR = By.xpath("//div[@class = 'aq aFf']");
	public static final By FIELD_SUBJECT_LOCATOR = By.xpath("//input[@name = 'subjectbox']");
	public static final By FIELD_MESSAGE_TEXT_LOCATOR = By.xpath("//div[@class = 'Am Al editable LW-avf']");
	public static final By SAVED_LOCATOR = By.xpath("//span[contains(text(), 'Saved')]");
	public static final By BUTTON_CLOSE_MESSAGE_LOCATOR = By.xpath("//img[@class = 'Ha']");
	
	public static final By BUTTON_DRAFTS_LOCATOR = By.xpath("//a[contains(text(), 'Drafts')]");
	public static final By MESSAGE_IN_DRAFT_FOLDER_LOCATOR = By.xpath("//span[@class = 'y2']");
	public static final By CHECK_ADDRESSEE_LOCATOR = By.xpath("//div[@class = 'vT']");

	public static final By CHECK_MESSAGE_TEXT_LOCATOR = By.xpath("//div[@class = 'Am Al editable LW-avf']");	
	public static final By BUTTON_SEND_MESSAGE_LOCATOR = By.xpath("//div[contains(text(), 'Send')]");
	
	public static final By BUTTON_INBOX_LOCATOR = By.xpath("//a[contains(text(), 'Inbox')]");
	
	public static final By BUTTON_SENT_MAIL_LOCATOR = By.xpath("//a[contains(text(), 'Sent Mail')]");
	public static final By CHECK_SEND_MESSAGE_TEXT_LOCATOR = By.xpath("//span[@class = 'y2']");
	
	public static final By BUTTON_USER_ICON_LOCATOR = By.xpath("//span[@class = 'gb_9a gbii']");
	public static final By BUTTON_LOG_OUT_LOCATOR = By.xpath("//a[text() ='Sign out']");
}
