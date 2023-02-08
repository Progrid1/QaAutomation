package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.CartPage;
import pageobjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;
	WebDriverWait wait;

	public AbstractComponent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.driver = driver;
		this.wait=wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/app-root/app-dashboard/app-sidebar/nav/ul/li[4]/button")
	private WebElement cart;
	
	@FindBy(xpath = "/html/body/app-root/app-dashboard/app-sidebar/nav/ul/li[3]/button")
	private WebElement orderHeader;
	
	public void waitForElementToAppear(By findBy) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToDisappear(By findBy) throws InterruptedException {
		Thread.sleep(1000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public CartPage goToCartPage() {
		cart.click();
		return new CartPage(driver);
		
	}
	
	public OrderPage goToOrderPage() {
		orderHeader.click();
		return new OrderPage(driver);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
