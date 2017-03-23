package by.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import by.epam.utils.ExplicitWait;

public abstract class AbstractPage {
	protected WebDriver driver;
	protected ExplicitWait wait;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		wait = new ExplicitWait(driver);
		PageFactory.initElements(driver, this);
	}

}
