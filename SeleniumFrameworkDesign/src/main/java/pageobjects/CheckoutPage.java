package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;
	Actions a;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		Actions a = new Actions(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.a = a;
	}

	By countryResults = By.xpath("//*[@class=\"ta-results list-group ng-star-inserted\"]");

	@FindBy(xpath = "//*[@placeholder=\"Select Country\"]")
	private WebElement typeCountry;

	@FindBy(xpath = "//*[@class=\"ta-item list-group-item ng-star-inserted\"][1]")
	private WebElement selectCountry;

	@FindBy(xpath = "//*[contains(@class,'action__submit')]")
	private	WebElement orderSubmit;

	public void typeCountry(String typCountry) {
		a.sendKeys(typeCountry, typCountry).build().perform();
		waitForElementToAppear(countryResults);

	}

	public void selectCountry() {
		a.click(selectCountry).build().perform();
	}

	public ConfirmationPage goToOrderSubmit() {
		a.click(orderSubmit).build().perform();
		return new ConfirmationPage(driver);
	}

}
