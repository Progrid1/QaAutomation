package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import abstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[contains(@class,'hero-primary')]")
	private WebElement confirmationMessage;
	
	
	public String getConfirmationMessage() {
		return confirmationMessage.getText();
	}
	
	
	
	
	
	
	
	
	
}
