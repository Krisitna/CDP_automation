package ui.driver;

import java.sql.Driver;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import bsh.This;

public class CustomDriverDecorator  implements WebDriver{
	protected WebDriver driver;

	public CustomDriverDecorator(WebDriver driver) {
		this.driver = driver;
	}

	
	// public CustomDriverDecorator(WebDriver driver) { this.driver = driver; }
	 

	public void close() {
		// TODO Auto-generated method stub

	}

	public WebElement findElement(By by) {

		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("arguments[0].style.backgroundColor = '" + "green"
				+ "'", by);		
	
	return driver.findElement(by);
		
	}

	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void get(String arg0) {
		driver.get(arg0);

	}

	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void quit() {
		System.out.println("Browser will be closed now...");
		// TODO Auto-generated method stub

	}

	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

}
